package fr.istic.taa.jaxrs.dao.generic;


import jpa.domain.Fiche;

import javax.persistence.EntityManager;
import java.util.List;

public class FicheDao {

    private EntityManager manager;

public FicheDao(EntityManager manager){
    this.manager = manager;
}
    public void createFiche(Fiche fiche){

    int numOfFiche = manager.createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        if (numOfFiche == 0) {
            manager.persist(fiche);

        }
    }


    public List<Fiche> listFiche() {
        return manager.createQuery("Select a From Fiche a", Fiche.class).getResultList();
    }

    public Fiche ficheById(Long id) {
        return manager.createQuery("Select a From Fiche a Where a.id = :id ", Fiche.class).setParameter("id",id).getSingleResult();

    }
}
