package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fiche implements Serializable {

    @Id
    @GeneratedValue
    private Long idFiche ;
    private String libelle;
    private String dateButoir ;
    private String tags;
    private String lieu ;
    private String url;
    private  String description ;
    @ManyToOne(cascade= CascadeType.ALL)
    @JsonIgnore
    private Section section ;
    public Section getSection() {
        return section;
    }
    public void setSection(Section section) {
        this.section = section;
    }
    public Fiche() {
        super();
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getDateButoir() {
        return dateButoir;
    }
    public void setDateButoir(String dateButoir) {
        this.dateButoir = dateButoir;
    }
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdFiche() {
        return idFiche;
    }

    public void setIdFiche(Long idFiche) {
        this.idFiche = idFiche;
    }

    public Fiche(String libelle, String dateButoir, String tags, String lieu, String url, String description,Section section) {
        super();
        this.libelle = libelle;
        this.dateButoir = dateButoir;
        this.tags = tags;
        this.lieu = lieu;
        this.url = url;
        this.description = description;
        this.section = section;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}

