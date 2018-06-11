package one_to_one_example_01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "STUDENT_DETAILS")
@Data
@ToString
@EqualsAndHashCode
public class StudentDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentDetailId;
	@Column
	private String street;
	@Column
	private String place;
}
