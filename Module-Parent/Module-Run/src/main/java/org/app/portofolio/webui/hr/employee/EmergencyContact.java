package org.app.portofolio.webui.hr.employee;

import java.util.List;

import org.app.portofolio.webui.hr.employee.model.EmergencyContactListItemRenderer;
import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.MstSkill;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.service.TransactionEmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class EmergencyContact {

	@Wire("#listBoxEmergencyContact")
	private Listbox listBoxEmergencyContact;

	@WireVariable
	private TransactionEmployeeService transactionEmployeeService;

	private EmergencyContactListItemRenderer emergencyContactListItemRenderer;
	private List<TrsEmployeeEmergencyContact> employeeEmergencyContacts;
	private TrsEmployeeEmergencyContact selectedEmployeeEmergencyContact;
	private ListModelList<TrsEmployeeEmergencyContact> listModelList;

	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object, 
			@ExecutionArgParam("params") TrsEmployee trsEmployee) {
		Selectors.wireComponents(component, this, false);
		
		constructItemRenderer();
		
		employeeEmergencyContacts = transactionEmployeeService.getAllTrsEmployeeEmergencyContact();
		listModelList = new ListModelList<TrsEmployeeEmergencyContact>(employeeEmergencyContacts);
		
		constructListbox();
	}
	
	private void constructItemRenderer(){
		this.emergencyContactListItemRenderer = new EmergencyContactListItemRenderer(){
			@Override
			protected void buttonSaveActionListener(){
				super.buttonSaveActionListener();
				
			}
			
			@Override
			protected void buttonDeleteActionListener(){
				super.buttonDeleteActionListener();
			}
		};
	}
	
	private void constructListbox() {
		listBoxEmergencyContact.setModel(listModelList);
		listBoxEmergencyContact.setItemRenderer(emergencyContactListItemRenderer.renderer);
	}
	
	@Command
	public void doNew() {
		listModelList.add(0, new TrsEmployeeEmergencyContact());
	}
	
	@GlobalCommand("refreshAfterSaveOrUpdate")
	@NotifyChange("employeeEmergencyContacts")
	public void refreshAfterSaveOrUpdate() {
		constructItemRenderer();
		
		employeeEmergencyContacts = transactionEmployeeService.getAllTrsEmployeeEmergencyContact();
		listModelList = new ListModelList<TrsEmployeeEmergencyContact>(employeeEmergencyContacts);
		listBoxEmergencyContact.setModel(listModelList);
		listBoxEmergencyContact.setItemRenderer(emergencyContactListItemRenderer.renderer);
	}
	
	@GlobalCommand("setTransactionValue")
	public void setTransactionValue(@BindingParam(EmergencyContactListItemRenderer.SELECTED_TRANSACTION_VALUE) TrsEmployeeEmergencyContact selectedTransactionValue) {
		emergencyContactListItemRenderer.setTransactionValue(selectedTransactionValue);
	}
	
	public void save(){
		transactionEmployeeService.saveOrUpdate(emergencyContactListItemRenderer.getTransactionValue());
	}
	
	public void delete(){
		transactionEmployeeService.delete(emergencyContactListItemRenderer.getTransactionValue());
	}
	

	public Listbox getListBoxEmergencyContact() {
		return listBoxEmergencyContact;
	}

	public void setListBoxEmergencyContact(Listbox listBoxEmergencyContact) {
		this.listBoxEmergencyContact = listBoxEmergencyContact;
	}

	public EmergencyContactListItemRenderer getEmergencyContactListItemRenderer() {
		return emergencyContactListItemRenderer;
	}

	public void setEmergencyContactListItemRenderer(EmergencyContactListItemRenderer emergencyContactListItemRenderer) {
		this.emergencyContactListItemRenderer = emergencyContactListItemRenderer;
	}

	public List<TrsEmployeeEmergencyContact> getEmployeeEmergencyContacts() {
		return employeeEmergencyContacts;
	}

	public void setEmployeeEmergencyContacts(List<TrsEmployeeEmergencyContact> employeeEmergencyContacts) {
		this.employeeEmergencyContacts = employeeEmergencyContacts;
	}

	public TrsEmployeeEmergencyContact getSelectedEmployeeEmergencyContact() {
		return selectedEmployeeEmergencyContact;
	}

	public void setSelectedEmployeeEmergencyContact(TrsEmployeeEmergencyContact selectedEmployeeEmergencyContact) {
		this.selectedEmployeeEmergencyContact = selectedEmployeeEmergencyContact;
	}

	public TransactionEmployeeService getTransactionEmployeeService() {
		return transactionEmployeeService;
	}

	public void setTransactionEmployeeService(TransactionEmployeeService transactionEmployeeService) {
		this.transactionEmployeeService = transactionEmployeeService;
	}

}
