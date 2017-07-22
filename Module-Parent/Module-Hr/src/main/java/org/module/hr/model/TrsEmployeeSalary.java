package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_salary database table.
 * 
 */
@Entity
@Table(name="trs_employee_salary")
@NamedQuery(name="TrsEmployeeSalary.findAll", query="SELECT t FROM TrsEmployeeSalary t")
public class TrsEmployeeSalary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_salary")
	private Integer idSalary;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeSalary() {
	}

	public Integer getIdSalary() {
		return this.idSalary;
	}

	public void setIdSalary(Integer idSalary) {
		this.idSalary = idSalary;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}