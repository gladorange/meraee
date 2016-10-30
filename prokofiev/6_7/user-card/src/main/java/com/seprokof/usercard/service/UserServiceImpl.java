package com.seprokof.usercard.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.RollbackException;

import com.seprokof.usercard.dao.UserCard;

@ManagedBean(name = "userService", eager = true)
@ApplicationScoped
public class UserServiceImpl implements UserService, Serializable {
	private static final long serialVersionUID = -2665687359261559140L;

	@PersistenceUnit(unitName = "user-card")
	private EntityManagerFactory emfactory;

	@Override
	public void addUser(UserCard userCard) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emfactory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			if (em.contains(userCard)) {
				// merge if it managed
				em.merge(userCard);
			} else {
				// save if not
				em.persist(userCard);
			}
			tx.commit();
		} catch (RollbackException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public UserCard updateUser(UserCard userCard, List<UserCard> removedFriends) {
		UserCard ret = userCard;
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emfactory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			// if some friends were removed we should update bidirectional
			// reference manually
			if (removedFriends != null && !removedFriends.isEmpty()) {
				for (UserCard u : removedFriends) {
					u.getFriends().remove(userCard);
					em.merge(u);
				}
			}

			// update current friends
			userCard.getFriends().stream().forEach(u -> {
				if (!u.getFriends().contains(userCard)) {
					u.getFriends().add(userCard);
				}
			});

			// merge main entity, so active friends will be updated by cascade
			ret = em.merge(userCard);
			tx.commit();
			// return updated
			return ret;
		} catch (RollbackException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void deleteUser(UserCard userCard) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emfactory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			// unlink and update manually friends first if any
			if (userCard.getFriends() != null && !userCard.getFriends().isEmpty()) {
				for (UserCard u : userCard.getFriends()) {
					u.getFriends().remove(userCard);
					em.merge(u);
				}
			}

			// if entity is not managed get it first
			em.remove(em.contains(userCard) ? userCard : em.merge(userCard));
			tx.commit();
		} catch (RollbackException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<UserCard> getAllUsers() {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emfactory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			List<UserCard> ret = em.createNamedQuery(UserCard.GET_ALL).getResultList();
			tx.commit();
			return ret;
		} catch (RollbackException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public UserCard getUserById(Long id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emfactory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			UserCard ret = em.find(UserCard.class, id);
			tx.commit();
			return ret;
		} catch (RollbackException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public List<UserCard> getPossibleFriends(Long id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emfactory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			List<UserCard> ret = em.createNamedQuery(UserCard.GET_AVAILABLE_FRIENDS_FOR_ID).setParameter(1, id)
					.getResultList();
			tx.commit();
			return ret;
		} catch (RollbackException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
