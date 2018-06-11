package embeddable_embedded_example_01.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Course {

	@Column
	private String name;
	@Column
	private int year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
