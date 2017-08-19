package org.app.portofolio.webui.hr.recruitment.vacancy;

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

public class RecruitmentVacancyDialogVM {

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#comboboxJobTitle")
	private Combobox comboboxJobTitle;
	
	@Wire("#textboxVacancyName")
	private Textbox textboxVacancyName;
	
	@Wire("#textboxHiringManager")
	private Textbox textboxHiringManager;
	
	@Wire("#textboxNumberOfPositions")
	private Textbox textboxNumberOfPositions;
	
	@Wire("#textboxDescription")
	private Textbox textboxDescription;
	
	@Wire("#checkboxActive")
	private Checkbox checkboxActive;
	
	@Wire("#buttonSaveVacancy")
	private Button buttonSaveVacancy;
	
	@Wire("#buttonSaveAndNewVacancy")
	private Button buttonSaveAndNewVacancy;
	
	@Wire("#buttonEditVacancy")
	private Button buttonEditVacancy;
	
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
		ComponentConditionUtil.visibleButton(buttonEditVacancy, buttonSaveAndNewVacancy);
		ComponentConditionUtil.invisibleButton(buttonEditVacancy);
	}
	
	/**
	 * 
	 */
	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSaveVacancy, buttonSaveAndNewVacancy);
		ComponentConditionUtil.visibleButton(buttonEditVacancy);
		ComponentConditionUtil.disableCombobox(comboboxJobTitle);
		ComponentConditionUtil.disableTextbox(textboxVacancyName, textboxNumberOfPositions, textboxHiringManager, textboxDescription);
		ComponentConditionUtil.disableCheckbox(checkboxActive);
	}
	
	@Command
	public void doSave(){
		ComponentConditionUtil.visibleButton(buttonEditVacancy);
		ComponentConditionUtil.invisibleButton(buttonSaveVacancy, buttonSaveAndNewVacancy);
	}
	
	@Command
	public void doSaveNew() {
		
	}
	
	@Command
	public void doEdit() {
		ComponentConditionUtil.invisibleButton(buttonEditVacancy);
		ComponentConditionUtil.visibleButton(buttonSaveVacancy);
		ComponentConditionUtil.enableCombobox(comboboxJobTitle);
		ComponentConditionUtil.enableTextbox(textboxVacancyName, textboxNumberOfPositions, textboxHiringManager, textboxDescription);
		ComponentConditionUtil.enableCheckbox(checkboxActive);
	}
}
