package fr.istic.taa.jaxrs.dao.generic;
import fr.istic.taa.jaxrs.domain.Fiche;
import javax.persistence.EntityTransaction;
import java.util.List;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {

    public void save(Fiche fiche) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(fiche);
        t.commit();
    }

    public void delete(Fiche fiche) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().remove(fiche);
        t.commit();
    }

    public List<Fiche> listFiche() {
        return EntityManagerHelper.getEntityManager().createQuery("Select f From Fiche f", Fiche.class).getResultList();
    }

    public Fiche ficheById(Long id) {
        return EntityManagerHelper.getEntityManager().createQuery("Select f From Fiche f Where f.id = :id ", Fiche.class).setParameter("id",id).getSingleResult();

    }
}
