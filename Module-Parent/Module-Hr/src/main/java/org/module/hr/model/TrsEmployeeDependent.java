package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trs_employee_dependent database table.
 * 
 */
@Entity
@Table(name="trs_employee_dependent")
@NamedQuery(name="TrsEmployeeDependent.findAll", query="SELECT t FROM TrsEmployeeDependent t")
public class TrsEmployeeDependent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_dependent")
	private Integer idDependent;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String name;

	private String relationship;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeDependent() {
	}

	public Integer getIdDependent() {
		return this.idDependent;
	}

	public void setIdDependent(Integer idDependent) {
		this.idDependent = idDependent;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}