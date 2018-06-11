package many_to_one_example_01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import many_to_one_example_01.entity.Department;
import many_to_one_example_01.entity.Employee;

public class Demo {

	private static EntityManagerFactory emf;

	public static void main(String[] args) {
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
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Department department = em.find(Department.class, 1L);
		Employee employee = em.find(Employee.class, 1L);
		System.out.println(department);
		System.out.println(employee);
		
		tx.commit();
		em.close();
	}

	public static void create() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Department department = new Department();
		department.setName("SSO");

		em.persist(department);

		Employee employee = new Employee();
		employee.setName("Sridhar S");
		employee.setGender("Male");
		employee.setDepartment(department);

		em.persist(employee);

		tx.commit();
		em.close();
	}

}
