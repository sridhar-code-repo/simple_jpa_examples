package one_to_one_example_01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one_to_one_example_01.entity.Employee;
import one_to_one_example_01.entity.EmployeeDetail;
import one_to_one_example_01.entity.Student;
import one_to_one_example_01.entity.StudentDetail;

public class Demo {

	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		try {
			emf = Persistence.createEntityManagerFactory("pu");
			//create();
			create1();
		} finally {
			if (emf != null)
				emf.close();
		}

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
