package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.app.portofolio.webui.hr.employee.model.DependentListItemRenderer;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeDependent;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;

public class Dependent {
	
	@Wire("ListBoxDependent")
	private Listbox listDependent;
	
	private DependentListItemRenderer dependentListItemRenderer;
	private List<TrsEmployeeDependent> employeeDependents;
	private TrsEmployeeDependent selectedEmployeDependent;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionParam("object") Object object){
		Selectors.wireComponents(component, this, false);
		
		// dummy
		employeeDependents = new ArrayList<TrsEmployeeDependent>();
		for (int i = 1 ; i < 5 ; i++){
			TrsEmployeeDependent trsEmployeeDependent = new TrsEmployeeDependent();
			
			TrsEmployee trsEmployee = new TrsEmployee();
			trsEmployee.setIdEmployee("idEmployee" + i);
			trsEmployeeDependent.setIdEmployee(trsEmployee);
			trsEmployeeDependent.setName("employee name " +i);
			trsEmployeeDependent.setRelationship("relationship " +i);
			trsEmployeeDependent.setDateOfBirth(new Date());
			employeeDependents.add(trsEmployeeDependent);
		}
		
		this.dependentListItemRenderer = new DependentListItemRenderer();
	}

	public Listbox getListDependent() {
		return listDependent;
	}

	public void setListDependent(Listbox listDependent) {
		this.listDependent = listDependent;
	}

	public DependentListItemRenderer getDependentListItemRenderer() {
		return dependentListItemRenderer;
	}

	public void setDependentListItemRenderer(DependentListItemRenderer dependentListItemRenderer) {
		this.dependentListItemRenderer = dependentListItemRenderer;
	}

	public List<TrsEmployeeDependent> getEmployeeDependents() {
		return employeeDependents;
	}

	public void setEmployeeDependents(List<TrsEmployeeDependent> employeeDependents) {
		this.employeeDependents = employeeDependents;
	}

	public TrsEmployeeDependent getSelectedEmployeDependent() {
		return selectedEmployeDependent;
	}

	public void setSelectedEmployeDependent(TrsEmployeeDependent selectedEmployeDependent) {
		this.selectedEmployeDependent = selectedEmployeDependent;
	}

	
}
