package one_to_one_example_01;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Setup {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("create");
		emf.close();

	}

}
