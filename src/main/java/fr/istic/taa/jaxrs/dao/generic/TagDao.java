package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Tags;
import javax.persistence.EntityTransaction;
import java.util.List;


public class TagDao extends AbstractJpaDao<Long, Tags> {

    public void save(Tags tag) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(tag);
        t.commit();
    }

    public void delete(Tags tag) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(tag);
        t.commit();
    }

    public List<Tags> listTags() {
        return this.entityManager.createQuery("Select t From Fiche t", Tags.class).getResultList();
    }

    public Tags tagsById(Long id) {
        return this.entityManager.createQuery("Select t From Fiche t Where t.id = :id ", Tags.class).setParameter("id",id).getSingleResult();

    }
}
