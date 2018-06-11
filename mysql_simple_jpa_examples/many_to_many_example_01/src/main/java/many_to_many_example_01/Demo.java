package many_to_many_example_01;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_many_example_01.entity.Sport;
import many_to_many_example_01.entity.Student;

public class Demo {

	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		try {
			emf = Persistence.createEntityManagerFactory("pu");

			// create();
			// create1();
			load();

		} finally {
			if (emf != null)
				emf.close();
		}
	}

	public static void load() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Sport sport = em.find(Sport.class, new Long(1));
		System.out.println(sport);
		tx.commit();
		em.close();

	}

	public static void create1() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Sport sport = em.find(Sport.class, new Long(1));

		Student student = new Student();
		student.setName("Jayanthi");
		student.setGender("Femal");
		Set<Sport> sports = new HashSet<>();
		sports.add(sport);
		student.setSports(sports);

		em.persist(student);
		tx.commit();
		em.close();

	}

	public static void create() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Sport sport = new Sport();
		sport.setName("Cricket");
		em.persist(sport);

		Student student = new Student();
		student.setName("Sridhar");
		student.setGender("Male");
		Set<Sport> sports = new HashSet<>();
		sports.add(sport);
		student.setSports(sports);

		em.persist(student);

		tx.commit();
		em.close();

	}
}
