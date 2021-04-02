package jpa;

import java.sql.Time;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("D") 
public class SondageDate extends TypeSondage{
	
	
	
    public SondageDate() {
		super();
	}

}
