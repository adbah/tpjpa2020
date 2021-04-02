package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long idUser ;
    private String nom ;
    private String prenom;
    private int age;
    @OneToMany (mappedBy = "user",  cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tableau> tableaux ;


    public List<Tableau> getTableaux() {
        return tableaux;
    }
    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public User(String nom, String prenom, int age) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.age= age;
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
    public User() {
        super();
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}