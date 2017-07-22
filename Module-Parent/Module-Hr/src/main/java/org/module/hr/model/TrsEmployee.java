package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trs_employee database table.
 * 
 */
@Entity
@Table(name="trs_employee")
@NamedQuery(name="TrsEmployee.findAll", query="SELECT t FROM TrsEmployee t")
public class TrsEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employee")
	private String idEmployee;

	//bi-directional many-to-one association to TrsEmployeeDependent
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeDependent> trsEmployeeDependents;

	//bi-directional many-to-one association to TrsEmployeeEducation
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeEducation> trsEmployeeEducations;

	//bi-directional many-to-one association to TrsEmployeeEmergencyContact
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeEmergencyContact> trsEmployeeEmergencyContacts;

	//bi-directional many-to-one association to TrsEmployeeExprience
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeExprience> trsEmployeeExpriences;

	//bi-directional many-to-one association to TrsEmployeeImmigration
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeImmigration> trsEmployeeImmigrations;

	//bi-directional many-to-one association to TrsEmployeeLanguage
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeLanguage> trsEmployeeLanguages;

	//bi-directional many-to-one association to TrsEmployeeLicense
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeLicense> trsEmployeeLicenses;

	//bi-directional many-to-one association to TrsEmployeeMembership
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeMembership> trsEmployeeMemberships;

	//bi-directional many-to-one association to TrsEmployeeSalary
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeSalary> trsEmployeeSalaries;

	//bi-directional many-to-one association to TrsEmployeeSkill
	@OneToMany(mappedBy="trsEmployee")
	private List<TrsEmployeeSkill> trsEmployeeSkills;

	public TrsEmployee() {
	}

	public String getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public List<TrsEmployeeDependent> getTrsEmployeeDependents() {
		return this.trsEmployeeDependents;
	}

	public void setTrsEmployeeDependents(List<TrsEmployeeDependent> trsEmployeeDependents) {
		this.trsEmployeeDependents = trsEmployeeDependents;
	}

	public TrsEmployeeDependent addTrsEmployeeDependent(TrsEmployeeDependent trsEmployeeDependent) {
		getTrsEmployeeDependents().add(trsEmployeeDependent);
		trsEmployeeDependent.setTrsEmployee(this);

		return trsEmployeeDependent;
	}

	public TrsEmployeeDependent removeTrsEmployeeDependent(TrsEmployeeDependent trsEmployeeDependent) {
		getTrsEmployeeDependents().remove(trsEmployeeDependent);
		trsEmployeeDependent.setTrsEmployee(null);

		return trsEmployeeDependent;
	}

	public List<TrsEmployeeEducation> getTrsEmployeeEducations() {
		return this.trsEmployeeEducations;
	}

	public void setTrsEmployeeEducations(List<TrsEmployeeEducation> trsEmployeeEducations) {
		this.trsEmployeeEducations = trsEmployeeEducations;
	}

	public TrsEmployeeEducation addTrsEmployeeEducation(TrsEmployeeEducation trsEmployeeEducation) {
		getTrsEmployeeEducations().add(trsEmployeeEducation);
		trsEmployeeEducation.setTrsEmployee(this);

		return trsEmployeeEducation;
	}

	public TrsEmployeeEducation removeTrsEmployeeEducation(TrsEmployeeEducation trsEmployeeEducation) {
		getTrsEmployeeEducations().remove(trsEmployeeEducation);
		trsEmployeeEducation.setTrsEmployee(null);

		return trsEmployeeEducation;
	}

	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContacts() {
		return this.trsEmployeeEmergencyContacts;
	}

	public void setTrsEmployeeEmergencyContacts(List<TrsEmployeeEmergencyContact> trsEmployeeEmergencyContacts) {
		this.trsEmployeeEmergencyContacts = trsEmployeeEmergencyContacts;
	}

	public TrsEmployeeEmergencyContact addTrsEmployeeEmergencyContact(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		getTrsEmployeeEmergencyContacts().add(trsEmployeeEmergencyContact);
		trsEmployeeEmergencyContact.setTrsEmployee(this);

		return trsEmployeeEmergencyContact;
	}

	public TrsEmployeeEmergencyContact removeTrsEmployeeEmergencyContact(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		getTrsEmployeeEmergencyContacts().remove(trsEmployeeEmergencyContact);
		trsEmployeeEmergencyContact.setTrsEmployee(null);

		return trsEmployeeEmergencyContact;
	}

	public List<TrsEmployeeExprience> getTrsEmployeeExpriences() {
		return this.trsEmployeeExpriences;
	}

	public void setTrsEmployeeExpriences(List<TrsEmployeeExprience> trsEmployeeExpriences) {
		this.trsEmployeeExpriences = trsEmployeeExpriences;
	}

	public TrsEmployeeExprience addTrsEmployeeExprience(TrsEmployeeExprience trsEmployeeExprience) {
		getTrsEmployeeExpriences().add(trsEmployeeExprience);
		trsEmployeeExprience.setTrsEmployee(this);

		return trsEmployeeExprience;
	}

	public TrsEmployeeExprience removeTrsEmployeeExprience(TrsEmployeeExprience trsEmployeeExprience) {
		getTrsEmployeeExpriences().remove(trsEmployeeExprience);
		trsEmployeeExprience.setTrsEmployee(null);

		return trsEmployeeExprience;
	}

	public List<TrsEmployeeImmigration> getTrsEmployeeImmigrations() {
		return this.trsEmployeeImmigrations;
	}

	public void setTrsEmployeeImmigrations(List<TrsEmployeeImmigration> trsEmployeeImmigrations) {
		this.trsEmployeeImmigrations = trsEmployeeImmigrations;
	}

	public TrsEmployeeImmigration addTrsEmployeeImmigration(TrsEmployeeImmigration trsEmployeeImmigration) {
		getTrsEmployeeImmigrations().add(trsEmployeeImmigration);
		trsEmployeeImmigration.setTrsEmployee(this);

		return trsEmployeeImmigration;
	}

	public TrsEmployeeImmigration removeTrsEmployeeImmigration(TrsEmployeeImmigration trsEmployeeImmigration) {
		getTrsEmployeeImmigrations().remove(trsEmployeeImmigration);
		trsEmployeeImmigration.setTrsEmployee(null);

		return trsEmployeeImmigration;
	}

	public List<TrsEmployeeLanguage> getTrsEmployeeLanguages() {
		return this.trsEmployeeLanguages;
	}

	public void setTrsEmployeeLanguages(List<TrsEmployeeLanguage> trsEmployeeLanguages) {
		this.trsEmployeeLanguages = trsEmployeeLanguages;
	}

	public TrsEmployeeLanguage addTrsEmployeeLanguage(TrsEmployeeLanguage trsEmployeeLanguage) {
		getTrsEmployeeLanguages().add(trsEmployeeLanguage);
		trsEmployeeLanguage.setTrsEmployee(this);

		return trsEmployeeLanguage;
	}

	public TrsEmployeeLanguage removeTrsEmployeeLanguage(TrsEmployeeLanguage trsEmployeeLanguage) {
		getTrsEmployeeLanguages().remove(trsEmployeeLanguage);
		trsEmployeeLanguage.setTrsEmployee(null);

		return trsEmployeeLanguage;
	}

	public List<TrsEmployeeLicense> getTrsEmployeeLicenses() {
		return this.trsEmployeeLicenses;
	}

	public void setTrsEmployeeLicenses(List<TrsEmployeeLicense> trsEmployeeLicenses) {
		this.trsEmployeeLicenses = trsEmployeeLicenses;
	}

	public TrsEmployeeLicense addTrsEmployeeLicens(TrsEmployeeLicense trsEmployeeLicens) {
		getTrsEmployeeLicenses().add(trsEmployeeLicens);
		trsEmployeeLicens.setTrsEmployee(this);

		return trsEmployeeLicens;
	}

	public TrsEmployeeLicense removeTrsEmployeeLicens(TrsEmployeeLicense trsEmployeeLicens) {
		getTrsEmployeeLicenses().remove(trsEmployeeLicens);
		trsEmployeeLicens.setTrsEmployee(null);

		return trsEmployeeLicens;
	}

	public List<TrsEmployeeMembership> getTrsEmployeeMemberships() {
		return this.trsEmployeeMemberships;
	}

	public void setTrsEmployeeMemberships(List<TrsEmployeeMembership> trsEmployeeMemberships) {
		this.trsEmployeeMemberships = trsEmployeeMemberships;
	}

	public TrsEmployeeMembership addTrsEmployeeMembership(TrsEmployeeMembership trsEmployeeMembership) {
		getTrsEmployeeMemberships().add(trsEmployeeMembership);
		trsEmployeeMembership.setTrsEmployee(this);

		return trsEmployeeMembership;
	}

	public TrsEmployeeMembership removeTrsEmployeeMembership(TrsEmployeeMembership trsEmployeeMembership) {
		getTrsEmployeeMemberships().remove(trsEmployeeMembership);
		trsEmployeeMembership.setTrsEmployee(null);

		return trsEmployeeMembership;
	}

	public List<TrsEmployeeSalary> getTrsEmployeeSalaries() {
		return this.trsEmployeeSalaries;
	}

	public void setTrsEmployeeSalaries(List<TrsEmployeeSalary> trsEmployeeSalaries) {
		this.trsEmployeeSalaries = trsEmployeeSalaries;
	}

	public TrsEmployeeSalary addTrsEmployeeSalary(TrsEmployeeSalary trsEmployeeSalary) {
		getTrsEmployeeSalaries().add(trsEmployeeSalary);
		trsEmployeeSalary.setTrsEmployee(this);

		return trsEmployeeSalary;
	}

	public TrsEmployeeSalary removeTrsEmployeeSalary(TrsEmployeeSalary trsEmployeeSalary) {
		getTrsEmployeeSalaries().remove(trsEmployeeSalary);
		trsEmployeeSalary.setTrsEmployee(null);

		return trsEmployeeSalary;
	}

	public List<TrsEmployeeSkill> getTrsEmployeeSkills() {
		return this.trsEmployeeSkills;
	}

	public void setTrsEmployeeSkills(List<TrsEmployeeSkill> trsEmployeeSkills) {
		this.trsEmployeeSkills = trsEmployeeSkills;
	}

	public TrsEmployeeSkill addTrsEmployeeSkill(TrsEmployeeSkill trsEmployeeSkill) {
		getTrsEmployeeSkills().add(trsEmployeeSkill);
		trsEmployeeSkill.setTrsEmployee(this);

		return trsEmployeeSkill;
	}

	public TrsEmployeeSkill removeTrsEmployeeSkill(TrsEmployeeSkill trsEmployeeSkill) {
		getTrsEmployeeSkills().remove(trsEmployeeSkill);
		trsEmployeeSkill.setTrsEmployee(null);

		return trsEmployeeSkill;
	}

}