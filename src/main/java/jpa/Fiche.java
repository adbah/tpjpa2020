package jpa;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fiche {
	
	@Id 
	@GeneratedValue
	private Long idFiche ;
    private String libelle;
	private String dateButoir ;
	private String tags;
	private String lieu ;
	private String url;
	private  String description ;
    @ManyToOne
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
	

} 
