package kyunysh.dao;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import kyunysh.User;

@Named
@ApplicationScoped
public class UserDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "lesson7PU")
	private EntityManager em;

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void saveUser(final User user) {
		if(user.getId() == null) {
			em.persist(user);
		} else {
			em.merge(user);
		}
	}

	@Transactional
	public void removeUser(final User user) {
		User mergedUser = em.merge(user);
		em.remove(mergedUser);
	}

	public User getUser(final Integer id) {
		final Query query = em.createQuery("select u from User as u where u.id=:id");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	public Collection<User> getUsers() {
		final Query query = em.createQuery("select u from User as u");
		return query.getResultList();
	}
}
