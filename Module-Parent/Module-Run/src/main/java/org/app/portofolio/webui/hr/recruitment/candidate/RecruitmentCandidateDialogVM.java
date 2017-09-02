package org.app.portofolio.webui.hr.recruitment.candidate;

import org.app.portofolio.webui.hr.common.collections.ArgKey;
import org.app.portofolio.webui.hr.common.collections.ModalAction;
import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

public class RecruitmentCandidateDialogVM {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	
	@Wire("#buttonSaveCandidate")
	private Button buttonSaveCandidate;
	
	@Wire("#buttonSaveAndNewCandidate")
	private Button buttonSaveAndNewCandidate;
	
	@Wire("#buttonEditCandidate")
	private Button buttonEditCandidate;
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Bean
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	
	
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
		/*ComponentConditionUtil.disableCombobox(comboboxJobTitle);
		ComponentConditionUtil.disableTextbox(textboxVacancyName, textboxNumberOfPositions, textboxHiringManager, textboxDescription);
		ComponentConditionUtil.disableCheckbox(checkboxActive);*/
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
		/*ComponentConditionUtil.enableCombobox(comboboxJobTitle);
		ComponentConditionUtil.enableTextbox(textboxVacancyName, textboxNumberOfPositions, textboxHiringManager, textboxDescription);
		ComponentConditionUtil.enableCheckbox(checkboxActive);*/
	}
}
