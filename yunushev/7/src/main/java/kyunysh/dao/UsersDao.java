package kyunysh.dao;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
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
public class UsersDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "lesson7PU")
	private EntityManager em;

	public UsersDao() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void addUser(final User user) {
		final User user1 = new User();
		user1.setFirstName("1");
		user1.setSecondName("2");
		user1.setPassword("3");
		try {
			user1.setPhotoUrl(new URL("http://my.com"));
		} catch (final MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.persist(user1);
	}

	@Transactional
	public void removeUser(final User user) {
		// em.persist(user);
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
