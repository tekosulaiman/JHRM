package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.webui.hr.employee.model.EmployeeEducationListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeExperienceListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeLanguageListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeLicenseListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeSkillListItemRenderer;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstSkill;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEducation;
import org.module.hr.model.TrsEmployeeExprience;
import org.module.hr.model.TrsEmployeeLanguage;
import org.module.hr.model.TrsEmployeeLicense;
import org.module.hr.model.TrsEmployeeSkill;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;

public class Qualifications {
	
	@Wire("ListBoxEmployeeExperience")
	private Listbox listEmployeeExperience;
	
	@Wire("ListBoxEmployeeEducation")
	private Listbox listEmployeeEducation;
	
	@Wire("ListBoxEmployeeSkill")
	private Listbox listEmployeeSkill;
	
	@Wire("ListBoxEmployeeLanguage")
	private Listbox listEmployeeLanguage;
	
	@Wire("ListBoxEmployeeLicense")
	private Listbox listEmployeeLicense;
	
	private EmployeeExperienceListItemRenderer employeeExperienceListItemRenderer;
	private List<TrsEmployeeExprience> employeeExpriences;
	private TrsEmployeeExprience selectedEmployeeExprience;
	
	private EmployeeEducationListItemRenderer employeeEducationListItemRenderer;
	private List<TrsEmployeeEducation> employeeEducations;
	private TrsEmployeeEducation selectedEmployeeEducation;
	
	private EmployeeSkillListItemRenderer employeeSkillListItemRenderer;
	private List<TrsEmployeeSkill> employeeSkills;
	private TrsEmployeeSkill selectedEmployeeSkill;
	
	private EmployeeLanguageListItemRenderer employeeLanguageListItemRenderer;
	private List<TrsEmployeeLanguage> employeeLanguages;
	private TrsEmployeeLanguage selectedEmployeeLanguage;
	
	private EmployeeLicenseListItemRenderer employeeLicenseListItemRenderer;
	private List<TrsEmployeeLicense> employeeLicenses;
	private TrsEmployeeLicense selectedEmployeeLicense;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object){
		Selectors.wireComponents(component, this, false);
		
		// dummy data working experience
		employeeExpriences = new ArrayList<TrsEmployeeExprience>();
		TrsEmployee employee ;
		TrsEmployeeExprience employeeExprience;
		for (int i = 1 ; i < 5; i++){
			employeeExprience = new TrsEmployeeExprience();
			employee = new TrsEmployee();
			employee.setIdEmployee("idEmploye" + i);
			employeeExprience.setIdEmployee(employee);
			employeeExprience.setIdExprience(i);
			employeeExpriences.add(employeeExprience);
		}
		
		// dummy data education
		employeeEducations = new ArrayList<TrsEmployeeEducation>();
		TrsEmployeeEducation employeeEducation;
		for (int i = 1; i < 5 ; i++){
			employeeEducation = new TrsEmployeeEducation();
			employee = new TrsEmployee();
			employee.setIdEmployee("idEmploye" + i);
			employeeEducation.setIdEmployee(employee);
			employeeEducation.setIdEmployeeEducation(i);
			employeeEducations.add(employeeEducation);
		}
		
		// dummy data skill
		employeeSkills = new ArrayList<TrsEmployeeSkill>();
		TrsEmployeeSkill employeeSkill;
		MstSkill mstSkill;
		for (int i = 1; i < 5; i++) {
			employeeSkill = new TrsEmployeeSkill();
			employee = new TrsEmployee();
			employee.setIdEmployee("idEmploye" + i);
			mstSkill = new MstSkill();
			mstSkill.setIdSkill(i);
			mstSkill.setNameSkill("Skill " + i);
			employeeSkill.setIdSkill(mstSkill);
			employeeSkill.setIdEmployeeSkill(i);
			employeeSkills.add(employeeSkill);
		}
		
		// dummy data language
		employeeLanguages = new ArrayList<TrsEmployeeLanguage>();
		TrsEmployeeLanguage employeeLanguage;
		MstLanguage mstLanguage;
		for (int i = 1; i < 5; i++) {
			employeeLanguage = new TrsEmployeeLanguage();
			employee = new TrsEmployee();
			employee.setIdEmployee("idEmploye" + i);
			mstLanguage = new MstLanguage();
			mstLanguage.setIdLanguage(i);
			mstLanguage.setNameLanguage("Language " + i);
			employeeLanguage.setIdEmployee(employee);
			employeeLanguage.setIdLanguage(mstLanguage);
			employeeLanguage.setIdEmployeeLanguage(i);
			employeeLanguages.add(employeeLanguage);
		}

		// dummy data license
		employeeLicenses = new ArrayList<TrsEmployeeLicense>();
		TrsEmployeeLicense employeeLicense;
		MstLicense mstLicense;
		for (int i = 1; i < 5; i++) {
			employeeLicense = new TrsEmployeeLicense();
			employee = new TrsEmployee();
			employee.setIdEmployee("idEmploye" + i);
			mstLicense = new MstLicense();
			mstLicense.setIdLicense(i);
			mstLicense.setNameLicense("License " + i);
			employeeLicense.setIdEmployee(employee);
			employeeLicense.setIdLicense(mstLicense);
			employeeLicense.setIdEmployeeLicense(i);
			employeeLicenses.add(employeeLicense);
		}
		
		this.employeeExperienceListItemRenderer = new EmployeeExperienceListItemRenderer();
		this.employeeEducationListItemRenderer = new EmployeeEducationListItemRenderer();
		this.employeeSkillListItemRenderer = new EmployeeSkillListItemRenderer();
		this.employeeLanguageListItemRenderer = new EmployeeLanguageListItemRenderer();
		this.employeeLicenseListItemRenderer = new EmployeeLicenseListItemRenderer();
	}


	public EmployeeExperienceListItemRenderer getEmployeeExperienceListItemRenderer() {
		return employeeExperienceListItemRenderer;
	}


	public void setEmployeeExperienceListItemRenderer(
			EmployeeExperienceListItemRenderer employeeExperienceListItemRenderer) {
		this.employeeExperienceListItemRenderer = employeeExperienceListItemRenderer;
	}


	public List<TrsEmployeeExprience> getEmployeeExpriences() {
		return employeeExpriences;
	}


	public void setEmployeeExpriences(List<TrsEmployeeExprience> employeeExpriences) {
		this.employeeExpriences = employeeExpriences;
	}

	public TrsEmployeeExprience getSelectedEmployeeExprience() {
		return selectedEmployeeExprience;
	}


	public void setSelectedEmployeeExprience(TrsEmployeeExprience selectedEmployeeExprience) {
		this.selectedEmployeeExprience = selectedEmployeeExprience;
	}


	public Listbox getListEmployeeExperience() {
		return listEmployeeExperience;
	}


	public void setListEmployeeExperience(Listbox listEmployeeExperience) {
		this.listEmployeeExperience = listEmployeeExperience;
	}


	public Listbox getListEmployeeEducation() {
		return listEmployeeEducation;
	}


	public void setListEmployeeEducation(Listbox listEmployeeEducation) {
		this.listEmployeeEducation = listEmployeeEducation;
	}


	public EmployeeEducationListItemRenderer getEmployeeEducationListItemRenderer() {
		return employeeEducationListItemRenderer;
	}


	public void setEmployeeEducationListItemRenderer(EmployeeEducationListItemRenderer employeeEducationListItemRenderer) {
		this.employeeEducationListItemRenderer = employeeEducationListItemRenderer;
	}


	public List<TrsEmployeeEducation> getEmployeeEducations() {
		return employeeEducations;
	}


	public void setEmployeeEducations(List<TrsEmployeeEducation> employeeEducations) {
		this.employeeEducations = employeeEducations;
	}


	public TrsEmployeeEducation getSelectedEmployeeEducation() {
		return selectedEmployeeEducation;
	}


	public void setSelectedEmployeeEducation(TrsEmployeeEducation selectedEmployeeEducation) {
		this.selectedEmployeeEducation = selectedEmployeeEducation;
	}


	public Listbox getListEmployeeSkill() {
		return listEmployeeSkill;
	}


	public void setListEmployeeSkill(Listbox listEmployeeSkill) {
		this.listEmployeeSkill = listEmployeeSkill;
	}


	public Listbox getListEmployeeLanguage() {
		return listEmployeeLanguage;
	}


	public void setListEmployeeLanguage(Listbox listEmployeeLanguage) {
		this.listEmployeeLanguage = listEmployeeLanguage;
	}


	public Listbox getListEmployeeLicense() {
		return listEmployeeLicense;
	}


	public void setListEmployeeLicense(Listbox listEmployeeLicense) {
		this.listEmployeeLicense = listEmployeeLicense;
	}


	public EmployeeSkillListItemRenderer getEmployeeSkillListItemRenderer() {
		return employeeSkillListItemRenderer;
	}


	public void setEmployeeSkillListItemRenderer(EmployeeSkillListItemRenderer employeeSkillListItemRenderer) {
		this.employeeSkillListItemRenderer = employeeSkillListItemRenderer;
	}


	public List<TrsEmployeeSkill> getEmployeeSkills() {
		return employeeSkills;
	}


	public void setEmployeeSkills(List<TrsEmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}


	public TrsEmployeeSkill getSelectedEmployeeSkill() {
		return selectedEmployeeSkill;
	}


	public void setSelectedEmployeeSkill(TrsEmployeeSkill selectedEmployeeSkill) {
		this.selectedEmployeeSkill = selectedEmployeeSkill;
	}


	public EmployeeLanguageListItemRenderer getEmployeeLanguageListItemRenderer() {
		return employeeLanguageListItemRenderer;
	}


	public void setEmployeeLanguageListItemRenderer(EmployeeLanguageListItemRenderer employeeLanguageListItemRenderer) {
		this.employeeLanguageListItemRenderer = employeeLanguageListItemRenderer;
	}


	public List<TrsEmployeeLanguage> getEmployeeLanguages() {
		return employeeLanguages;
	}


	public void setEmployeeLanguages(List<TrsEmployeeLanguage> employeeLanguages) {
		this.employeeLanguages = employeeLanguages;
	}


	public TrsEmployeeLanguage getSelectedEmployeeLanguage() {
		return selectedEmployeeLanguage;
	}


	public void setSelectedEmployeeLanguage(TrsEmployeeLanguage selectedEmployeeLanguage) {
		this.selectedEmployeeLanguage = selectedEmployeeLanguage;
	}


	public EmployeeLicenseListItemRenderer getEmployeeLicenseListItemRenderer() {
		return employeeLicenseListItemRenderer;
	}


	public void setEmployeeLicenseListItemRenderer(EmployeeLicenseListItemRenderer employeeLicenseListItemRenderer) {
		this.employeeLicenseListItemRenderer = employeeLicenseListItemRenderer;
	}


	public List<TrsEmployeeLicense> getEmployeeLicenses() {
		return employeeLicenses;
	}


	public void setEmployeeLicenses(List<TrsEmployeeLicense> employeeLicenses) {
		this.employeeLicenses = employeeLicenses;
	}


	public TrsEmployeeLicense getSelectedEmployeeLicense() {
		return selectedEmployeeLicense;
	}


	public void setSelectedEmployeeLicense(TrsEmployeeLicense selectedEmployeeLicense) {
		this.selectedEmployeeLicense = selectedEmployeeLicense;
	}
	
}
