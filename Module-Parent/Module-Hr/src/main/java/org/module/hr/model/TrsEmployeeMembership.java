package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_membership database table.
 * 
 */
@Entity
@Table(name="trs_employee_membership")
@NamedQuery(name="TrsEmployeeMembership.findAll", query="SELECT t FROM TrsEmployeeMembership t")
public class TrsEmployeeMembership implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employee_membership")
	private Integer idEmployeeMembership;

	//bi-directional many-to-one association to MstMembership
	@ManyToOne
	@JoinColumn(name="id_membership")
	private MstMembership mstMembership;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeMembership() {
	}

	public Integer getIdEmployeeMembership() {
		return this.idEmployeeMembership;
	}

	public void setIdEmployeeMembership(Integer idEmployeeMembership) {
		this.idEmployeeMembership = idEmployeeMembership;
	}

	public MstMembership getMstMembership() {
		return this.mstMembership;
	}

	public void setMstMembership(MstMembership mstMembership) {
		this.mstMembership = mstMembership;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}