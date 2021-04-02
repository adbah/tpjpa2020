package jpa;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("L") 
public class SondageLieu extends TypeSondage {

	
	public SondageLieu() {
		super();
	}
	 

}
