package jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Tableau {
	@Id
	@GeneratedValue
	private Long idTableau ;
	@OneToMany(mappedBy ="tableau", cascade = CascadeType.ALL )
	private List<Section> sections ;
	private String name ;
	@ManyToOne(cascade = CascadeType.ALL)
	private User user ;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getIdTableau() {
		return idTableau;
	}
	public void setIdTableau(Long idTableau) {
		this.idTableau = idTableau;
	}
	
	
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public Tableau() {
		super();
	}
	public Tableau( String name, User user) {
		super();
		this.user = user;
		this.name =  name;
	}
	
	public Tableau(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
		
}

















































































































