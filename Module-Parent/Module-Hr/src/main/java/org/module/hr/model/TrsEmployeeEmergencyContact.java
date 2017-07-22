package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trs_employee_emergency_contact database table.
 * 
 */
@Entity
@Table(name="trs_employee_emergency_contact")
@NamedQuery(name="TrsEmployeeEmergencyContact.findAll", query="SELECT t FROM TrsEmployeeEmergencyContact t")
public class TrsEmployeeEmergencyContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employee_emergency_contact")
	private Integer idEmployeeEmergencyContact;

	@Column(name="home_telephone")
	private String homeTelephone;

	private String mobile;

	private String name;

	private String relationship;

	@Column(name="work_telephone")
	private String workTelephone;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeEmergencyContact() {
	}

	public Integer getIdEmployeeEmergencyContact() {
		return this.idEmployeeEmergencyContact;
	}

	public void setIdEmployeeEmergencyContact(Integer idEmployeeEmergencyContact) {
		this.idEmployeeEmergencyContact = idEmployeeEmergencyContact;
	}

	public String getHomeTelephone() {
		return this.homeTelephone;
	}

	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public String getWorkTelephone() {
		return this.workTelephone;
	}

	public void setWorkTelephone(String workTelephone) {
		this.workTelephone = workTelephone;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}