package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fiche implements Serializable {

    private Long id ;

    private String libelle;
    private String lieu;
    private String date;
    private String note;
    private String temps;
    private String url;


    private List<Tags> tagsF = new ArrayList<>();


    private Section sectionF;


    private User owner;


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Fiche(){
    }

    public Fiche(String libelle, String lieu, String date, String note, String temps, String url,Section section, User user, List<Tags> tags){
        this.libelle = libelle;
        this.lieu = lieu;
        this.date = date;
        this.note = note;
        this.temps = temps;
        this.url = url;
        this.tagsF = tags;
        this.sectionF=section;
        this.owner=user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToMany(mappedBy = "ficheT", cascade = CascadeType.PERSIST)
    public List<Tags> getTagsF() {
        return tagsF;
    }

    public void setTagsF(List<Tags> tags) {
        this.tagsF = tags;
    }

    @ManyToOne()
    public Section getSectionF() {
        return sectionF;
    }

    public void setSectionF(Section sect) {
        this.sectionF = sect;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
