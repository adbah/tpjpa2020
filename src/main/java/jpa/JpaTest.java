package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

public class JpaTest {
	
	private static EntityManager manager;
	
	public JpaTest(EntityManager manager) {
		
		this.manager = manager;
	}
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
			EntityManager manager = factory.createEntityManager();
			JpaTest test = new JpaTest(manager);
             EntityTransaction tx = manager.getTransaction();
			tx.begin();
			try {
				test.persistUser();
				test.persistSection();
				test.createFiches();
				test.createSondageDate();
				test.createSondageLieu();
				test.selectTypeSondage();
				test.getUsers() ;
				test.sections(9L) ;
				test.sectionEncours(); 
				 test.getUsersFomAgeMax();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			tx.commit();		
	   	    manager.close();
			System.out.println(".. done");
     }
	
     public static void persistUser() {
		
        User user1 = new User("Diana", "Denise", 20);
        User user2 = new User("Mike", "Rose",45);
        User user3 = new User("Tim", "bah",30);
        User user4 = new User("Jack", "olivier",45);
        Tableau tab = new Tableau("Kanban1", user1);
        Tableau tab1 = new Tableau("Kanban2", user2);
        Tableau tab2 = new Tableau("Kanban3", user2);
      
        manager.persist(user1);
        manager.persist(user2);
        manager.persist(user3);
        manager.persist(user4);
        manager.persist(tab);
        manager.persist(tab1);
        manager.persist(tab2);
        
	}
     
    public static void persistSection() {
 		
         Tableau tab = new Tableau("Kanban6");
         Tableau tab1 = new Tableau("Kanban4");
         Tableau tab2 = new Tableau("Kanban5");
         Section  s1  = new Section("En cours",tab );
         Section  s2  = new Section("En Attente",tab );
         Section  s3  = new Section("Réalisé",tab );
       
         manager.persist(s1);
         manager.persist(s2);
         manager.persist(s3);
         manager.persist(tab);
         manager.persist(tab1);
         manager.persist(tab2);
         
 	}
    /**
 	* récupérer tous les  utilisateurs 
 	*/
 	private static void getUsers() {
 		
         System.out.println("-- executing query --");
         Query query = manager.createQuery("SELECT DISTINCT e FROM User e ");
         List<User> resultList = query.getResultList();
     	 System.out.println("number of users: " + resultList.size());
         for (User user : resultList) {
             System.out.println( " User :" +user.getNom() + " - " + user.getPrenom());
         }
     }
 	
 	/**
 	* récupérer tous les  utilisateurs  âgés moins de ageMax
 	*/
 	private static void getUsersFomAgeMax() {
 		
 		int ageMax = 25;
 		List<User> resultList = manager
 		                .createQuery("select u from User u where u.age <= :ageMax", User.class)
 		                .setParameter("ageMax", ageMax)
 		                .getResultList();
 		for (User user : resultList) {
            System.out.println( " User :" +user.getNom() + " - " + user.getPrenom()  + " - " + user.getAge());
        }
     }
 	
     /**
	 *  récupérer toutes les sections  en cours
	 */
	private void sectionEncours() {
		String sectionName="En cours";
		List<Section> sections = null;
		sections = manager .createNativeQuery("select * from Section where NAME  = ?", Section.class)
                     .setParameter(1, sectionName)
		              .getResultList();
		 for (Section s: sections) {
	            System.out.println(s.getName());
	        }
			
	}
	/**
	 * 
	 * @param id
	 *  retourne les section d'un tableau 
	 */
	
	public void sections(Long id) {
		
		List<String> resultList= manager.createQuery("SELECT s.name FROM Section s, Tableau t where t.idTableau = ?1 and s.tableau.idTableau = t.idTableau")
                  .setParameter(1, id).getResultList();

		for (String s: resultList) {
            System.out.println(s);
		
        }
	}
	
	/**
	 * création d'une fiche 	
	 */
	private void createFiches() {
		
		int numOfEmployees = manager.createQuery("Select f From Fiche f", Fiche.class).getResultList().size();
		if (numOfEmployees == 0) {
			User user = new User("Bah", "Adama", 20);
			Tableau tab = new Tableau("Kanban", user);
			Section section  = new Section("En Attente", tab);
			manager.persist(section);
            manager.persist(new Fiche("Conception", "2021-03-21", "tags", "Rennes", 
					"https://trello.com/b/YAgZ49uf/mod%C3%A8le-kanban", 
					"Une liste des choses que nous pensons vouloir faire",section));
     }
	
	}
	

    /**
	 * création d'un sondageTypeDate
	 */
	private void createSondageDate() {
	 manager.createNativeQuery("INSERT INTO TypeSondage (sondage_type, libelle, nbreSondage)"
                + " VALUES ( :a, :b, :c)")
                .setParameter("a", "D")
                .setParameter("b", "Sondage date")
                .setParameter("c", "45")
                .executeUpdate();
		
	}
	/**
	 * création d'un sondageTypeLieu
	 */
	private void createSondageLieu() {
		
		   manager.createNativeQuery("INSERT INTO TypeSondage (sondage_type, libelle, nbreSondage)"
	                + " VALUES ( :a, :b, :c)")
	                .setParameter("a", "L")
	                .setParameter("b", "Sondage lieu")
	                .setParameter("c", "50")
	                .executeUpdate();
	}
	/**
	 *  Retourne les types de sondages et le nombre de sondages dans chaque type
	 */
	private void selectTypeSondage() {
		
	    List<TypeSondage> resultList = manager.createQuery("Select a From TypeSondage  a", TypeSondage.class).getResultList();
		System.out.println("number of TypeSondage: " + resultList.size());
		for ( TypeSondage next : resultList) {
			System.out.println(" TypeSondage: " + next.getNom()+ " - " + next.getNbreSondage());
		}
    }
	
  }
	
	

