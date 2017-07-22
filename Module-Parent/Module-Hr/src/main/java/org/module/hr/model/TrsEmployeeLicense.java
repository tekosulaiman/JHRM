package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_license database table.
 * 
 */
@Entity
@Table(name="trs_employee_license")
@NamedQuery(name="TrsEmployeeLicense.findAll", query="SELECT t FROM TrsEmployeeLicense t")
public class TrsEmployeeLicense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employee_license")
	private Integer idEmployeeLicense;

	//bi-directional many-to-one association to MstLicense
	@ManyToOne
	@JoinColumn(name="id_license")
	private MstLicense mstLicense;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeLicense() {
	}

	public Integer getIdEmployeeLicense() {
		return this.idEmployeeLicense;
	}

	public void setIdEmployeeLicense(Integer idEmployeeLicense) {
		this.idEmployeeLicense = idEmployeeLicense;
	}

	public MstLicense getMstLicense() {
		return this.mstLicense;
	}

	public void setMstLicense(MstLicense mstLicense) {
		this.mstLicense = mstLicense;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}