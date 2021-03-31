package fr.istic.taa.jaxrs.dao.generic;

//import jpa.domain.Section;

import javax.persistence.EntityManager;
import java.util.List;

public class SectionDao {

    private EntityManager manager;

    public SectionDao(EntityManager manager) {
        this.manager = manager;
    }

    public void createSection(Section section){
        manager.persist(section);
    }

    public void listSection(){
        List<Section> resultList = manager.createQuery("Select a From Section a", Section.class).getResultList();
        System.out.println("num of section:" + resultList.size());
        for (Section next : resultList) {
            System.out.println("next section: " + next);
        }
    }

    public Section chooseSection(Long id){

        return manager.createQuery("Select a From Tags a Where a.id = :id ", Section.class).setParameter("id",id).getSingleResult();
    }
}
