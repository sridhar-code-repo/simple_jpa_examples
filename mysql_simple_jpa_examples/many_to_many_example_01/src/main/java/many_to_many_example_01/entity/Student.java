package many_to_many_example_01.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String gender;

	@ManyToMany
	@JoinTable(name = "student_sport_mappings", joinColumns = {
			@JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "sport_id") })
	private Set<Sport> sports;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}

}
