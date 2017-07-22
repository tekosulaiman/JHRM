package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_exprience database table.
 * 
 */
@Entity
@Table(name="trs_employee_exprience")
@NamedQuery(name="TrsEmployeeExprience.findAll", query="SELECT t FROM TrsEmployeeExprience t")
public class TrsEmployeeExprience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_exprience")
	private Integer idExprience;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeExprience() {
	}

	public Integer getIdExprience() {
		return this.idExprience;
	}

	public void setIdExprience(Integer idExprience) {
		this.idExprience = idExprience;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}