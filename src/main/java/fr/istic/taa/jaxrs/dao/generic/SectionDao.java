package fr.istic.taa.jaxrs.dao.generic;
import fr.istic.taa.jaxrs.domain.Section;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SectionDao extends AbstractJpaDao<Long, Section>{

    public void save(Section section) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(section);
        t.commit();
    }

    public void delete(Section section) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().remove(section);
        t.commit();
    }

    public List<Section> listSection() {
        return EntityManagerHelper.getEntityManager().createQuery("Select s From Section s", Section.class).getResultList();
    }

    public Section sectionById(Long id) {
        return EntityManagerHelper.getEntityManager().createQuery("Select s From Section s Where s.id = :id ", Section.class).setParameter("id",id).getSingleResult();

    }
}
