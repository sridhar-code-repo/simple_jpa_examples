package embeddable_embedded_example_01;

import java.util.ArrayList;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import embeddable_embedded_example_01.entity.Address;
import embeddable_embedded_example_01.entity.Country;
import embeddable_embedded_example_01.entity.Course;
import embeddable_embedded_example_01.entity.Person;
import embeddable_embedded_example_01.entity.Student;

public class Demo {

	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		try {
			emf = Persistence.createEntityManagerFactory("pu");
			create2();
			create();
			load();
		} finally {
			if (emf != null)
				emf.close();
		}

	}

	public static void load() {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, 1L);
		System.out.println(student);
		em.close();
	}

	public static void create() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Student student = new Student();
		student.setName("Sridhar");
		student.setCourses(new ArrayList<>());
		Course course = new Course();
		course.setName("SCJP");
		course.setYear(2007);
		
		Course course1 = new Course();
		course1.setName("OCJP");
		course1.setYear(2018);
		student.getCourses().add(course);
		student.getCourses().add(course1);
		em.persist(student);
		tx.commit();
		em.close();
	}

	public static void create2() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Country country = new Country();
		country.setName("India");
		country.setDescription("India");

		em.persist(country);

		Person person = new Person();
		person.setName("Sridhar Srinivasan");
		person.setGender("Male");

		Address address = new Address();
		address.setCountry(country);
		address.setPlace("Panathur,Bangalore");
		address.setStreet("JCR 2nd Main,1st Cross");

		person.setAddress(address);
		em.persist(person);
		tx.commit();
		em.close();

		em = emf.createEntityManager();
		Country country1 = em.find(Country.class, 1L);
		try {
			Set<Person> persons = country1.getPersons();
			System.out.println(persons);
		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();

	}

}
