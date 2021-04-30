package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.User;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UserDao extends AbstractJpaDao<Long, User> {

    public void save(User user) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(user);
        t.commit();
    }

    public void delete(User user) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(user);
        t.commit();
    }

    public List<User> listUsers() {
        return this.entityManager.createQuery("Select u From Fiche u", User.class).getResultList();
    }

    public User userById(Long id) {
        return this.entityManager.createQuery("Select u From Fiche u Where u.id = :id ", User.class).setParameter("id",id).getSingleResult();

    }

}