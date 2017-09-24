package org.app.portofolio.webui.hr.recruitment.vacancy;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.common.collections.ArgKey;
import org.app.portofolio.webui.hr.common.collections.ModalAction;
import org.module.hr.model.TrsJobVacancy;
import org.module.hr.service.RecruitmentService;
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
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class RecruitmentVacancyListVM {

	/* ------------- Services -------------*/
	@WireVariable
	private RecruitmentService recruitmentService;
	
	/* --------------- Beans --------------*/
	private List<TrsJobVacancy> trsJobVacancies;
	private TrsJobVacancy selectedTrsJobVacancy;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		trsJobVacancies = recruitmentService.getAllTrsJobVacancy();
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
		arg.put(ArgKey.SELECTED_TRANSACTION_JOB_VACANCY, this.selectedTrsJobVacancy);
		Executions.createComponents(JHRMAdditionalZulPath.Recruitment.Vacancy.DIALOG_FORM, null, arg);
	}
	
	@GlobalCommand("refreshTrsJobVacancyList")
	@NotifyChange("trsJobVacancies")
	public void refreshTrsJobVacancyList() {
		trsJobVacancies = recruitmentService.getAllTrsJobVacancy();
	}
	
	
	/* ---------- GETTER-SETTER --------------*/
	
	public List<TrsJobVacancy> getTrsJobVacancies() {
		return trsJobVacancies;
	}
	
	public void setTrsJobVacancies(List<TrsJobVacancy> trsJobVacancies) {
		this.trsJobVacancies = trsJobVacancies;
	}
	
	public TrsJobVacancy getSelectedTrsJobVacancy() {
		return selectedTrsJobVacancy;
	}
	
	public void setSelectedTrsJobVacancy(TrsJobVacancy selectedTrsJobVacancy) {
		this.selectedTrsJobVacancy = selectedTrsJobVacancy;
	}
}
