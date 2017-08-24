package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.webui.hr.employee.model.EmergencyContactListItemRenderer;
import org.app.portofolio.webui.hr.master.qualification.language.model.LanguageListItemRenderer;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.service.TrsEmployeeEmergencyContactService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class EmergencyContact {

	@Wire("#listBoxEmergencyContact")
	private Listbox listEmergencyContact;
	
	@WireVariable
	private TrsEmployeeEmergencyContactService trsEmployeeEmergencyContactService;
	
	private EmergencyContactListItemRenderer emergencyContactListItemRenderer;
	private List<TrsEmployeeEmergencyContact> employeeEmergencyContacts;
	private TrsEmployeeEmergencyContact selectedEmployeeEmergencyContact;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		employeeEmergencyContacts = trsEmployeeEmergencyContactService.getAllTrsEmployeeEmergencyContact();
		
		
		// dummy
//		employeeEmergencyContacts = new ArrayList<TrsEmployeeEmergencyContact>();
//		for (int i = 1; i < 5; i++) {
//			TrsEmployeeEmergencyContact trsEmployeeEmergencyContact = new TrsEmployeeEmergencyContact();
//			
//			TrsEmployee trsEmployee = new TrsEmployee();
//			trsEmployee.setIdEmployee("idEmploye" + i);
//			trsEmployeeEmergencyContact.setIdEmployee(trsEmployee);
//			trsEmployeeEmergencyContact.setIdEmployeeEmergencyContact(i);
//			trsEmployeeEmergencyContact.setName("employee" + i);
//			trsEmployeeEmergencyContact.setRelationship("Relationship" + i);
//			trsEmployeeEmergencyContact.setHomeTelephone("HomeTelephone" + i);
//			trsEmployeeEmergencyContact.setMobile("Mobile" + i);
//			trsEmployeeEmergencyContact.setWorkTelephone("WorkTelephone" + i);
//			employeeEmergencyContacts.add(trsEmployeeEmergencyContact);
//		}

		this.emergencyContactListItemRenderer = new EmergencyContactListItemRenderer(){
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
			}
		};
		
		listEmergencyContact.setModel(new ListModelList<TrsEmployeeEmergencyContact>(employeeEmergencyContacts));
	}

	public Listbox getListEmergencyContact() {
		return listEmergencyContact;
	}

	public void setListEmergencyContact(Listbox listEmergencyContact) {
		this.listEmergencyContact = listEmergencyContact;
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

	public TrsEmployeeEmergencyContactService getTrsEmployeeEmergencyContactService() {
		return trsEmployeeEmergencyContactService;
	}

	public void setTrsEmployeeEmergencyContactService(
			TrsEmployeeEmergencyContactService trsEmployeeEmergencyContactService) {
		this.trsEmployeeEmergencyContactService = trsEmployeeEmergencyContactService;
	}
	
}
