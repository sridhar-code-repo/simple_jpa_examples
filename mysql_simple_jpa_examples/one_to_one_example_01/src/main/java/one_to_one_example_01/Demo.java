package one_to_one_example_01;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_example_01.entity.Address;
import one_to_one_example_01.entity.Country;
import one_to_one_example_01.entity.Employee;
import one_to_one_example_01.entity.EmployeeDetail;
import one_to_one_example_01.entity.Person;
import one_to_one_example_01.entity.Student;
import one_to_one_example_01.entity.StudentDetail;

public class Demo {

	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		try {
			emf = Persistence.createEntityManagerFactory("pu");
			// create();
			// create1();
			create2();
		} finally {
			if (emf != null)
				emf.close();
		}

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
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		
	}

	public static void create1() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Student student = new Student();
		student.setName("Sridhar Srinivasan");
		student.setGender("Male");

		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setPlace("Panathur");
		studentDetail.setStreet("JCR 2nd Main,1st Cross");

		student.setStudentDetail(studentDetail);
		em.persist(student);

		tx.commit();
		em.close();
	}

	public static void create() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Employee employee = new Employee();
		employee.setName("Sridhar Srinivasan");
		employee.setGender("Male");

		em.persist(employee);

		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setEmployeeId(employee.getId());
		employeeDetail.setPlace("Panathur");
		employeeDetail.setStreet("JCR 2nd Main,1st Cross");

		em.persist(employeeDetail);

		tx.commit();
		em.close();
	}

}
