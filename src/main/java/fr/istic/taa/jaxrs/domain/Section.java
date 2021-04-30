package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section implements Serializable {


    private Long id ;

    private String section;

    private List<Fiche> ficheS = new ArrayList<>() ;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Section(){
    }

    public Section(String section){
        this.section= section;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @OneToMany(mappedBy = "sectionF", cascade = CascadeType.PERSIST)
    public List<Fiche> getFicheS() {
        return ficheS;
    }

    public void setFicheS(List<Fiche> fiche) {
        this.ficheS = fiche;
    }


}
