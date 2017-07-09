package org.app.portofolio.webui.hr.master.qualification.education;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;

public class MasterQualificationEducation {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
	}
	
	/**
	 * 
	 */
	@Command
	public void doNew(){
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Education.ADD_FORM, null, null);
	}
	
	/**
	 * 
	 */
	@Command
	public void doDetail(){
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Education.DETAIL_FORM, null, null);
	}
}
