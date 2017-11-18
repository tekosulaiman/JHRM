package org.app.portofolio.webui.hr.employee;

import org.module.hr.model.TrsEmployeeImmigration;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class ImmigrationDialog {
	
	@WireVariable
	private EmployeeService employeeService;
	
	/* ---------- Bean ----------*/
	private TrsEmployeeImmigration trsEmployeeImmigration;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") TrsEmployeeImmigration trsEmployeeImmigration) {
		Selectors.wireComponents(component, this, false);
		if (trsEmployeeImmigration == null){
			this.trsEmployeeImmigration = new TrsEmployeeImmigration();
		} else {
			this.trsEmployeeImmigration = trsEmployeeImmigration;
		}
	}
	
	@Command
	public void doSave(){
		if (this.trsEmployeeImmigration.getIdImmigration() == null){
			employeeService.save(trsEmployeeImmigration);
		} else {
			employeeService.update(trsEmployeeImmigration);
		}
	}

	public TrsEmployeeImmigration getTrsEmployeeImmigration() {
		return trsEmployeeImmigration;
	}

	public void setTrsEmployeeImmigration(TrsEmployeeImmigration trsEmployeeImmigration) {
		this.trsEmployeeImmigration = trsEmployeeImmigration;
	}
	
	
}
