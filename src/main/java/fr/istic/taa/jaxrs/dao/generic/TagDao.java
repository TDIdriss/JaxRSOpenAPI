package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Tags;
import javax.persistence.EntityTransaction;
import java.util.List;


public class TagDao extends AbstractJpaDao<Long, Tags> {

    public void save(Tags tag) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(tag);
        t.commit();
    }

    public void delete(Tags tag) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().remove(tag);
        t.commit();
    }

    public List<Tags> listTags() {
        return EntityManagerHelper.getEntityManager().createQuery("Select t From Tags t", Tags.class).getResultList();
    }

    public Tags tagsById(Long id) {
        return EntityManagerHelper.getEntityManager().createQuery("Select t From Tags t Where t.id = :id ", Tags.class).setParameter("id",id).getSingleResult();

    }
}
