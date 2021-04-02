package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public  class Section {

    @Id
    @GeneratedValue
    private Long idSection ;
    @OneToMany(mappedBy ="section", cascade= CascadeType.ALL)
    @JsonIgnore
    private List<Fiche> fiches ;
    @ManyToOne( cascade = CascadeType.ALL)
    @JsonIgnore
    private Tableau tableau ;
    private String name ;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Tableau getTableau() {
        return tableau;
    }


    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }


    public Long getIdSection() {
        return idSection;
    }


    public void setIdSection(Long idSection) {
        this.idSection = idSection;
    }


    public List<Fiche> getFiches() {
        return fiches;
    }


    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }


    public Section() {
        super();
    }


    public Section(Tableau tableau) {
        super();
        this.tableau = tableau;
    }


    public Section(String name, Tableau tableau) {
        super();
        this.name = name;
        this.tableau = tableau;
    }

}

