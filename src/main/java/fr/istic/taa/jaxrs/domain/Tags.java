package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tags {

   private Long id ;

   private String tag;

   private List<Fiche> ficheT = new ArrayList<>();


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Tags(){
    }

    public Tags(String tag){
        this.tag=tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @ManyToMany
    public List<Fiche> getFicheT() {
        return ficheT;
    }

    public void setFicheT(List<Fiche> fiche) {
        this.ficheT = fiche;
    }
}
