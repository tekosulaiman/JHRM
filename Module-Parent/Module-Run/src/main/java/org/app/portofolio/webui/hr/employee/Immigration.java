package org.app.portofolio.webui.hr.employee;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeImmigration;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Listbox;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Immigration {
	
	@Wire("#listBoxImmigration")
	private Listbox listBoxImmigration;
	
	@WireVariable
	private EmployeeService employeeService;
	
	private TrsEmployee trsEmployee;
	
	private List<TrsEmployeeImmigration> trsEmployeeImmigrations;
	private TrsEmployeeImmigration selectedEmployeeImmigration;
	
	public void doPrepareList(){
		listBoxImmigration.setCheckmark(true);
		listBoxImmigration.setMultiple(true);
		listBoxImmigration.setRows(15);
		listBoxImmigration.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponent(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object, 
			@ExecutionArgParam("type") TrsEmployee trsEmployee) {
		Selectors.wireComponents(component, this, false);
		this.trsEmployee = trsEmployee;
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		trsEmployeeImmigrations = employeeService.getTrsEmployeeImmigrationByTrsEmployeeImmigrationRequestMap(requestMap);
		
		doPrepareList();
	}
	
	@Command
	public void doNew() {
		Executions.createComponents("/WEB-INF/pages/module_hr/employee/immigrationDialog.zul", null, null);
	}
	
	@Command
	public void doDetail(){
		/*HashMap<K, V> K = Key, V = Value*/
		HashMap<String, Object> arg = new HashMap<String, Object>();
		arg.put("trsEmployeeImmigration", selectedEmployeeImmigration);
		
		Executions.createComponents("", null, arg);
	}
	
	@GlobalCommand
	@NotifyChange("trsEmployeeImmigrations")
	public void trsEmployeeDependents(){
		HashMap< String, Object> requestMap = new HashMap<>();
		requestMap.put("trsEmployee", trsEmployee);
		trsEmployeeImmigrations = employeeService.getTrsEmployeeImmigrationByTrsEmployeeImmigrationRequestMap(requestMap);
	}

	public Listbox getListBoxImmigration() {
		return listBoxImmigration;
	}

	public void setListBoxImmigration(Listbox listBoxImmigration) {
		this.listBoxImmigration = listBoxImmigration;
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public List<TrsEmployeeImmigration> getTrsEmployeeImmigrations() {
		return trsEmployeeImmigrations;
	}

	public void setTrsEmployeeImmigrations(List<TrsEmployeeImmigration> trsEmployeeImmigrations) {
		this.trsEmployeeImmigrations = trsEmployeeImmigrations;
	}

	public List<TrsEmployeeImmigration> getEmployeeImmigrations() {
		return trsEmployeeImmigrations;
	}

	public void setEmployeeImmigrations(List<TrsEmployeeImmigration> trsEmployeeImmigrations) {
		this.trsEmployeeImmigrations = trsEmployeeImmigrations;
	}

	public TrsEmployeeImmigration getSelectedEmployeeImmigration() {
		return selectedEmployeeImmigration;
	}

	public void setSelectedEmployeeImmigration(TrsEmployeeImmigration selectedEmployeeImmigration) {
		this.selectedEmployeeImmigration = selectedEmployeeImmigration;
	}
	
	
	

}
