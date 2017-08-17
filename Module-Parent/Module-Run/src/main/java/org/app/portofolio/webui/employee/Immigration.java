package org.app.portofolio.webui.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.app.portofolio.webui.employee.model.ImmigrationListItemRenderer;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeImmigration;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.ExecutionParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Listbox;

public class Immigration {
	
	@WireVariable("listBoxImmigration")
	private Listbox listImmigration;
	
	private ImmigrationListItemRenderer immigrationListItemRenderer;
	private List<TrsEmployeeImmigration> employeeImmigrations;
	private TrsEmployeeImmigration selectedEmployeeImmigration;
	
	@AfterCompose
	public void setupComponent(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object){
		Selectors.wireComponents(component, this, false);
		
		// dummy
		employeeImmigrations = new ArrayList<TrsEmployeeImmigration>();
		for (int i = 1 ; i < 5 ; i++){
			TrsEmployeeImmigration trsEmployeeImmigration = new TrsEmployeeImmigration();
			TrsEmployee trsEmployee = new TrsEmployee();
			trsEmployee.setIdEmployee("idEmployee" + i);
			trsEmployeeImmigration.setIdEmployee(trsEmployee);
			trsEmployeeImmigration.setIdImmigration(i);
			trsEmployeeImmigration.setDocument("document" +  i);
			trsEmployeeImmigration.setNumber(i);
			trsEmployeeImmigration.setIssuedDate(new Date());
			trsEmployeeImmigration.setExpiredDate(new Date());
			employeeImmigrations.add(trsEmployeeImmigration);
		}
		immigrationListItemRenderer = new ImmigrationListItemRenderer();
	}

	public Listbox getListImmigration() {
		return listImmigration;
	}

	public void setListImmigration(Listbox listImmigration) {
		this.listImmigration = listImmigration;
	}

	public ImmigrationListItemRenderer getImmigrationListItemRenderer() {
		return immigrationListItemRenderer;
	}

	public void setImmigrationListItemRenderer(ImmigrationListItemRenderer immigrationListItemRenderer) {
		this.immigrationListItemRenderer = immigrationListItemRenderer;
	}

	public List<TrsEmployeeImmigration> getEmployeeImmigrations() {
		return employeeImmigrations;
	}

	public void setEmployeeImmigrations(List<TrsEmployeeImmigration> employeeImmigrations) {
		this.employeeImmigrations = employeeImmigrations;
	}

	public TrsEmployeeImmigration getSelectedEmployeeImmigration() {
		return selectedEmployeeImmigration;
	}

	public void setSelectedEmployeeImmigration(TrsEmployeeImmigration selectedEmployeeImmigration) {
		this.selectedEmployeeImmigration = selectedEmployeeImmigration;
	}
	
	

}
