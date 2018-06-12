package secondary_table_example_01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import secondary_table_example_01.entity.Employee;

public class Demo {

	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		try {
			emf = Persistence.createEntityManagerFactory("pu");
			create();
			load();
		} finally {
			if (emf != null)
				emf.close();
		}
	}

	public static void load() {
		EntityManager em = emf.createEntityManager();
		Employee employee = em.find(Employee.class, 1L);
		System.out.println(employee);
		em.close();

	}

	public static void create() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Employee employee = new Employee();
		employee.setName("Sridhar");
		employee.setGender("Male");
		employee.setPlace("Panathur,Bangalore");
		employee.setStreet("JCR 2nd Main,1st Cross");
		em.persist(employee);
		tx.commit();
		em.close();
	}

}
