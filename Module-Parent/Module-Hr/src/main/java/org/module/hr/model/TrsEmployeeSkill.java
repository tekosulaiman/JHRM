package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_skill database table.
 * 
 */
@Entity
@Table(name="trs_employee_skill")
@NamedQuery(name="TrsEmployeeSkill.findAll", query="SELECT t FROM TrsEmployeeSkill t")
public class TrsEmployeeSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employee_skill")
	private Integer idEmployeeSkill;

	//bi-directional many-to-one association to MstSkill
	@ManyToOne
	@JoinColumn(name="id_skill")
	private MstSkill mstSkill;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeSkill() {
	}

	public Integer getIdEmployeeSkill() {
		return this.idEmployeeSkill;
	}

	public void setIdEmployeeSkill(Integer idEmployeeSkill) {
		this.idEmployeeSkill = idEmployeeSkill;
	}

	public MstSkill getMstSkill() {
		return this.mstSkill;
	}

	public void setMstSkill(MstSkill mstSkill) {
		this.mstSkill = mstSkill;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}