package org.app.portofolio.webui.hr.employee;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.employee.model.MembershipListItemRenderer;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeMembership;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
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

public class Membership {
	
	@Wire("#listBoxMembership")
	private Listbox listBoxMembership;
	
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployee trsEmployee;
	
	private MembershipListItemRenderer membershipListItemRenderer;
	private List<TrsEmployeeMembership> employeeMemberships;
	private TrsEmployeeMembership selectedDEployeeMembership;
	
	public void doPrepareList(){
		listBoxMembership.setCheckmark(true);
		listBoxMembership.setMultiple(true);
		listBoxMembership.setRows(15);
		listBoxMembership.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object,
			@ExecutionArgParam("type") TrsEmployee trsEmployee) {
		Selectors.wireComponents(component, this, false);
		this.trsEmployee = trsEmployee;
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeMemberships = employeeService.getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(requestMap);
		membershipListItemRenderer = new MembershipListItemRenderer();
		
		listBoxMembership.setModel(new ListModelList<TrsEmployeeMembership>());
		listBoxMembership.setItemRenderer(membershipListItemRenderer);
		doPrepareList();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxMembership.getModel();
		TrsEmployeeMembership trsEmployeeMembership = new TrsEmployeeMembership();
		trsEmployeeMembership.setIdEmployee(trsEmployee);
		listModelList.add(0, trsEmployeeMembership);
	}
	
	@GlobalCommand
	@NotifyChange({"employeeEmergencyContacts","mytest"})
	public void refreshAfterSaveOrUpdate(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		employeeMemberships = employeeService.getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(requestMap);
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public MembershipListItemRenderer getMembershipListItemRenderer() {
		return membershipListItemRenderer;
	}

	public void setMembershipListItemRenderer(MembershipListItemRenderer membershipListItemRenderer) {
		this.membershipListItemRenderer = membershipListItemRenderer;
	}

	public List<TrsEmployeeMembership> getEmployeeMemberships() {
		return employeeMemberships;
	}

	public void setEmployeeMemberships(List<TrsEmployeeMembership> employeeMemberships) {
		this.employeeMemberships = employeeMemberships;
	}

	public TrsEmployeeMembership getSelectedDEployeeMembership() {
		return selectedDEployeeMembership;
	}

	public void setSelectedDEployeeMembership(TrsEmployeeMembership selectedDEployeeMembership) {
		this.selectedDEployeeMembership = selectedDEployeeMembership;
	}
	
	
}
