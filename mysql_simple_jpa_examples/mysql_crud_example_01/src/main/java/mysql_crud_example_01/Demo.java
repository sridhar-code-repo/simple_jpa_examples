package mysql_crud_example_01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mysql_crud_example_01.entity.Student;

public class Demo {

	/***
	 * 
	 * persist : The persist method makes an instance managed and persistent.
	 * 
	 * merge : the merge method merges the state of the given entity into the current persistence context
	 * 
	 * remove : The remove method removes the given entity from database
	 * 
	 */
	
	
	
	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		try {
			emf = Persistence.createEntityManagerFactory("pu");
			//createStudent(1000L, "Sridhar", "Male");
			getReferenceTest();
			//updateStudent();
			//updateViaMerge();
			//remove();
		} finally {
			if (emf != null)
				emf.close();
		}
	}

	public static void getReferenceTest() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Student student = em.getReference(Student.class, 2000L);
//		System.out.println(student.getName());
		tx.commit();
		em.close();

	}

	public static void remove() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Student student = em.find(Student.class, 1000L);
		em.remove(student);
		tx.commit();
		em.close();

	}

	public static void updateViaMerge() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Student student = em.find(Student.class, 1000L);
		Student other = new Student();
		other.setId(1000L);
		other.setName("Sridhar S");
		other.setGender("Male");
		em.merge(other);
		tx.commit();
		em.close();
	}

	public static void updateStudent() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Student student = em.find(Student.class, 1000L);
		student.setName("Sridhar Srinivasan");
		tx.commit();
		em.close();
	}

	public static void createStudent(Long id, String name, String gender) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setGender(gender);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(student);
		tx.commit();
		em.close();
	}

}
