package mysql_crud_example_01;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Drop {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("drop");
		emf.close();
	}
}
