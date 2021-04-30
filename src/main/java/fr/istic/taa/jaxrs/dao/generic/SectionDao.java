package fr.istic.taa.jaxrs.dao.generic;
import fr.istic.taa.jaxrs.domain.Section;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SectionDao extends AbstractJpaDao<Long, Section>{

    public void save(Section section) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.persist(section);
        t.commit();
    }

    public void delete(Section section) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(section);
        t.commit();
    }

    public List<Section> listSection() {
        return this.entityManager.createQuery("Select s From Section s", Section.class).getResultList();
    }

    public Section sectionById(Long id) {
        return this.entityManager.createQuery("Select s From Section s Where s.id = :id ", Section.class).setParameter("id",id).getSingleResult();

    }
}
