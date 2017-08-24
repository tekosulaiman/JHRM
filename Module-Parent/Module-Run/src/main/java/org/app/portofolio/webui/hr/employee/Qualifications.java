package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.webui.hr.employee.model.EmployeeEducationListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.EmployeeExperienceListItemRenderer;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEducation;
import org.module.hr.model.TrsEmployeeExprience;
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
	
	private EmployeeExperienceListItemRenderer employeeExperienceListItemRenderer;
	private List<TrsEmployeeExprience> employeeExpriences;
	private TrsEmployeeExprience selectedEmployeeExprience;
	
	private EmployeeEducationListItemRenderer employeeEducationListItemRenderer;
	private List<TrsEmployeeEducation> employeeEducations;
	private TrsEmployeeEducation selectedEmployeeEducation;

	
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
		
		this.employeeExperienceListItemRenderer = new EmployeeExperienceListItemRenderer();
		this.employeeEducationListItemRenderer = new EmployeeEducationListItemRenderer();
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
}
