package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {

    private Long id ;

    private String nom;
    private String prenom;

    private List<Fiche> ficheU = new ArrayList<>() ;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public User(){
        super();
    }

    public User(String nom, String prenom){
        this.nom=nom;
        this.prenom = prenom;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @OneToMany(mappedBy = "owner" , cascade = CascadeType.PERSIST)
    public List<Fiche> getFicheU() {
        return ficheU;
    }

    public void setFicheU(List<Fiche> fiche) {
        this.ficheU = fiche;
    }


}
