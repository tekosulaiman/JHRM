package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_education database table.
 * 
 */
@Entity
@Table(name="trs_employee_education")
@NamedQuery(name="TrsEmployeeEducation.findAll", query="SELECT t FROM TrsEmployeeEducation t")
public class TrsEmployeeEducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employee_education")
	private Integer idEmployeeEducation;

	//bi-directional many-to-one association to MstEducation
	@ManyToOne
	@JoinColumn(name="id_education")
	private MstEducation mstEducation;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeEducation() {
	}

	public Integer getIdEmployeeEducation() {
		return this.idEmployeeEducation;
	}

	public void setIdEmployeeEducation(Integer idEmployeeEducation) {
		this.idEmployeeEducation = idEmployeeEducation;
	}

	public MstEducation getMstEducation() {
		return this.mstEducation;
	}

	public void setMstEducation(MstEducation mstEducation) {
		this.mstEducation = mstEducation;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}