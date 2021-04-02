package jpa;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="sondage_type")
@NamedQuery(name="sondage", query="SELECT c FROM TypeSondage c") 
public abstract class TypeSondage {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSondage ;	
    private String libelle ;
    private int nbreSondage ;
    
	public int getNbreSondage() {
		return nbreSondage;
	}
	public void setNbreSondage(int nbreSondage) {
		this.nbreSondage = nbreSondage;
	}
	public Long getIdSondage() {
		return idSondage;
	}
	public void setIdSondage(Long idSondage) {
		this.idSondage = idSondage;
	}
	public String getNom() {
		return libelle;
	}
	public void setNom(String nom) {
		this.libelle =libelle;
	}
	public TypeSondage() {
		super();
	}
	public TypeSondage(String libelle) {
		super();
		this.libelle = libelle;
	}
	 


}
