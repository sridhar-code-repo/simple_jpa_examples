package one_to_one_example_01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DETAILS")
public class StudentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentDetailId;
	@Column
	private String street;
	@Column
	private String place;

	public Long getStudentDetailId() {
		return studentDetailId;
	}

	public void setStudentDetailId(Long studentDetailId) {
		this.studentDetailId = studentDetailId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
