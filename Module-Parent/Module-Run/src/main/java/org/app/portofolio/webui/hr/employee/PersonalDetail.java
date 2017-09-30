package org.app.portofolio.webui.hr.employee;

import org.app.portofolio.webui.hr.employee.model.MaritalStatusListItemRenderer;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.dto.MaritalStatusType;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;

public class PersonalDetail {
	
	@WireVariable
	private EmployeeService employeeService;
	
	@Wire("#comboBoxMaritalStatus")
	private Combobox comboBoxMaritalStatus;
	
	private TrsEmployee trsEmployee;
	
	private MaritalStatusType selectedMaritalStatus;
	
	private Boolean isEdit;
	
	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++ Inisialize Methode MVVM yang pertama kali dijalankan
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++
	 */
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("type") TrsEmployee trsEmployee) {
		Selectors.wireComponents(component, this, false);
		this.trsEmployee = trsEmployee;
		comboBoxMaritalStatus.setReadonly(true);
		comboBoxMaritalStatus.setModel(new ListModelList<MaritalStatusType>(employeeService.getAllMaritalStatusType()));
		comboBoxMaritalStatus.setItemRenderer(new MaritalStatusListItemRenderer());
		isEdit = Boolean.FALSE;
	}
	
	@Command
	@NotifyChange("isEdit")
	public void doEdit(){
		isEdit = Boolean.TRUE;
	}
	
	@Command
	@NotifyChange("isEdit")
	public void doSave(){
		employeeService.update(trsEmployee);
		isEdit = Boolean.FALSE;
	}
	
	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}



	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public MaritalStatusType getSelectedMaritalStatus() {
		return selectedMaritalStatus;
	}

	public void setSelectedMaritalStatus(MaritalStatusType selectedMaritalStatus) {
		this.selectedMaritalStatus = selectedMaritalStatus;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}
	
	

}
