package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_language database table.
 * 
 */
@Entity
@Table(name="trs_employee_language")
@NamedQuery(name="TrsEmployeeLanguage.findAll", query="SELECT t FROM TrsEmployeeLanguage t")
public class TrsEmployeeLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employee_language")
	private Integer idEmployeeLanguage;

	//bi-directional many-to-one association to MstLanguage
	@ManyToOne
	@JoinColumn(name="id_language")
	private MstLanguage mstLanguage;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeLanguage() {
	}

	public Integer getIdEmployeeLanguage() {
		return this.idEmployeeLanguage;
	}

	public void setIdEmployeeLanguage(Integer idEmployeeLanguage) {
		this.idEmployeeLanguage = idEmployeeLanguage;
	}

	public MstLanguage getMstLanguage() {
		return this.mstLanguage;
	}

	public void setMstLanguage(MstLanguage mstLanguage) {
		this.mstLanguage = mstLanguage;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}