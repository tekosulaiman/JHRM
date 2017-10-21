package org.app.portofolio.webui.hr.recruitment.candidate;

import java.util.List;

import org.app.portofolio.webui.hr.common.collections.ArgKey;
import org.app.portofolio.webui.hr.common.collections.ModalAction;
import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.recruitment.candidate.validator.TrsJobCandidateFormValidator;
import org.module.hr.model.TrsJobCandidate;
import org.module.hr.model.TrsJobVacancy;
import org.module.hr.service.EmployeeService;
import org.module.hr.service.RecruitmentService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;

public class RecruitmentCandidateDialogVM {

	/*----------- zul ----------*/
	@Wire("#buttonSaveCandidate")
	private Button buttonSaveCandidate;
	
	@Wire("#buttonSaveAndNewCandidate")
	private Button buttonSaveAndNewCandidate;
	
	@Wire("#buttonEditCandidate")
	private Button buttonEditCandidate;
	
	/*----------- Services -----------*/
	@WireVariable
	private RecruitmentService recruitmentService;
	
	@WireVariable
	private EmployeeService employeeService;
	
	/*----------- Bean -----------*/
	private List<TrsJobVacancy> trsJobVacancies;
	private TrsJobCandidateFormValidator formValidator;
	private TrsJobCandidate trsJobCandidate;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
			@ExecutionArgParam("object") Object object,
			@ExecutionArgParam(ArgKey.MODAL_ACTION_KEY) ModalAction action) {
		Selectors.wireComponents(component, this, false);
		
		switch(action) {
			case NEW : this.formAddCondition();
			break;
			case DETAIL : this.formDetailCondition();
			break;
		}
		
		initComponents();
	}
	
	/**
	 * Initialisasi bean yang digunakan di dalam ViewModel
	 */
	private void initComponents() {
		trsJobVacancies = recruitmentService.getAllTrsJobVacancy();
	}

	/**
	 * 
	 */
	private void formAddCondition() {
		ComponentConditionUtil.visibleButton(buttonEditCandidate, buttonSaveAndNewCandidate);
		ComponentConditionUtil.invisibleButton(buttonEditCandidate);
	}
	
	/**
	 * 
	 */
	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSaveCandidate, buttonSaveAndNewCandidate);
		ComponentConditionUtil.visibleButton(buttonEditCandidate);
	}
	
	@Command
	public void doSave(){
		ComponentConditionUtil.visibleButton(buttonEditCandidate);
		ComponentConditionUtil.invisibleButton(buttonSaveCandidate, buttonSaveAndNewCandidate);
	}
	
	@Command
	public void doSaveNew() {
		
	}
	
	@Command
	public void doEdit() {
		ComponentConditionUtil.invisibleButton(buttonEditCandidate);
		ComponentConditionUtil.visibleButton(buttonSaveCandidate);
	}
	
	
	/* ---------- GETTER-SETTER --------------*/
	
	public List<TrsJobVacancy> getTrsJobVacancies() {
		return trsJobVacancies;
	}
	
	public TrsJobCandidate getTrsJobCandidate() {
		return trsJobCandidate;
	}

	public void setTrsJobCandidate(TrsJobCandidate trsJobCandidate) {
		this.trsJobCandidate = trsJobCandidate;
	}

	public void setTrsJobVacancies(List<TrsJobVacancy> trsJobVacancies) {
		this.trsJobVacancies = trsJobVacancies;
	}
	
	public TrsJobCandidateFormValidator getFormValidator() {
		return formValidator;
	}
	
	public void setFormValidator(TrsJobCandidateFormValidator formValidator) {
		this.formValidator = formValidator;
	}
}
