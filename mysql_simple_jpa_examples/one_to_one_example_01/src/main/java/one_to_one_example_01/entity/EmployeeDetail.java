package one_to_one_example_01.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
@Data
@ToString
@EqualsAndHashCode
public class EmployeeDetail {

	@Id
	private Long employeeId;
	@Column
	private String street;
	@Column
	private String place;
	@OneToOne(mappedBy = "employeeDetail")
	private Employee employee;
}
