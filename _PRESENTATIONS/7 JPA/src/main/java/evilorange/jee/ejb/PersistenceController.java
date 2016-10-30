package evilorange.jee.ejb;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import evilorange.jee.model.User;

@Named
@ApplicationScoped
public class PersistenceController {

    @PersistenceContext(unitName = "myPU")
    EntityManager em;



    @Transactional
    public String saveRandom() {
        final User entity = new User();
        entity.setFirstName("Andrey");
        entity.setLastName(String.valueOf(Math.random()));
        entity.setImageUrl("");
        entity.setPasswordConfirmation("1");
        entity.setPassword("1");
        em.persist(entity);
        return "";

    }
    @Transactional
    public String getUser() {
        final User user = em.find(User.class, 1L);
        return "";
    }

    public List<User> getUserList() {
        final Query query = em.createQuery(
                "select u from User as u");
        List<User> list = query.getResultList();
        return list;
    }

}
