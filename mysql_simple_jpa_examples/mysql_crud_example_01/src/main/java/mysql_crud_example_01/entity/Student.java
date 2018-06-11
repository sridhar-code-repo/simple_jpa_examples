package mysql_crud_example_01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Students")
@Data
public class Student {

	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private String gender;
}
