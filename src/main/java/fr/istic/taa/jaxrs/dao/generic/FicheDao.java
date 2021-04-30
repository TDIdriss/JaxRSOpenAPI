package fr.istic.taa.jaxrs.dao.generic;
import fr.istic.taa.jaxrs.domain.Fiche;
import javax.persistence.EntityTransaction;
import java.util.List;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {

    public void save(Fiche fiche) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        entityManager.persist(fiche);
        t.commit();
    }

    public void delete(Fiche fiche) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(fiche);
        t.commit();
    }

    public List<Fiche> listFiche() {
        return this.entityManager.createQuery("Select f From Fiche f", Fiche.class).getResultList();
    }

    public Fiche ficheById(Long id) {
        return this.entityManager.createQuery("Select f From Fiche f Where f.id = :id ", Fiche.class).setParameter("id",id).getSingleResult();

    }
}
