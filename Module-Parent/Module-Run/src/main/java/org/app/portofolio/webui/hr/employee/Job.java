package org.app.portofolio.webui.hr.employee;

import org.module.hr.model.TrsEmployee;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Job {
	
	private TrsEmployee trsEmployee;

	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object, @ExecutionArgParam("type") TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}
