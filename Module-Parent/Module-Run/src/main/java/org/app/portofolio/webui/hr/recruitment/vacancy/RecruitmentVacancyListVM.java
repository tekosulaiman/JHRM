package org.app.portofolio.webui.hr.recruitment.vacancy;

import java.util.HashMap;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.common.collections.ArgKey;
import org.app.portofolio.webui.hr.common.collections.ModalAction;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;

public class RecruitmentVacancyListVM {

	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
	}
	
	@Command
	public void doNew(){
		HashMap<String, Object> arg = new HashMap<>();
		arg.put(ArgKey.MODAL_ACTION_KEY, ModalAction.NEW);
		Executions.createComponents(JHRMAdditionalZulPath.Recruitment.Vacancy.DIALOG_FORM, null, arg);
	}
	
	@Command
	public void doDetail(){
		HashMap<String, Object> arg = new HashMap<>();
		arg.put(ArgKey.MODAL_ACTION_KEY, ModalAction.DETAIL);
		Executions.createComponents(JHRMAdditionalZulPath.Recruitment.Vacancy.DIALOG_FORM, null, arg);
	}
}
