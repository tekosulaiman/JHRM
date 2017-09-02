package org.app.portofolio.webui.hr.master.qualification.skills;

import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.MstSkill;
import org.module.hr.service.MasterQualificationService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class MasterQualificationSkills {

	/* ------------ Zul -------------- */
	@Wire("#listBoxSkills")
	private Listbox listBoxSkills;

	
	/* ----------Services -------------*/
	@WireVariable
	private MasterQualificationService masterQualificationService;
	
	/* ------------ Beans -------------*/
	private SkillsListItemRenderer skillItemRenderer;
	private List<MstSkill> skills;
	private MstSkill selectedSkills;
	private ListModelList<MstSkill> listModelList;
	
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
 
		constructItemRenderer();
		
		skills = masterQualificationService.getAllMstSkill(); 
		listModelList = new ListModelList<MstSkill>(skills);
		constructListbox();
	}

	private void constructItemRenderer() {
		this.skillItemRenderer = new SkillsListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
				save();
			}
			
			@Override
			protected void buttonDeleteActionListener() {
				super.buttonDeleteActionListener();
				delete();
			}
		};
	}

	/**
	 * 
	 */
	private void constructListbox() {
		listBoxSkills.setModel(listModelList);
		listBoxSkills.setItemRenderer(skillItemRenderer.renderer);
	}

	/**
	 * 
	 */
	@Command
	public void doNew() {
		listModelList.add(0, new MstSkill());
	}

	/**
	 * 
	 */
	@Command
	public void doDetail() {
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Skills.DETAIL_FORM, null, null);
	}
	
	/**
	 * 
	 */
	public void save(){
		masterQualificationService.saveOrUpdate(skillItemRenderer.getTransactionValue());
	}
	
	/**
	 * 
	 */
	public void delete() {
		masterQualificationService.delete(skillItemRenderer.getTransactionValue());
	}

	/**
	 * 
	 */
	@GlobalCommand("refreshAfterSaveOrUpdate")
	@NotifyChange("skills")
	public void refreshAfterSaveOrUpdate() {
		constructItemRenderer();
		
		skills = masterQualificationService.getAllMstSkill();
		listModelList = new ListModelList<MstSkill>(skills);
		listBoxSkills.setModel(listModelList);
		listBoxSkills.setItemRenderer(skillItemRenderer.renderer);
	}
	
	@GlobalCommand("setTransactionValue")
	public void setTransactionValue(@BindingParam(SkillsListItemRenderer.SELECTED_TRANSACTION_VALUE) MstSkill selectedTransactionValue) {
		skillItemRenderer.setTransactionValue(selectedTransactionValue);
	}

	public SkillsListItemRenderer getSkillItemRenderer() {
		return skillItemRenderer;
	}

	public void setSkillItemRenderer(SkillsListItemRenderer skillItemRenderer) {
		this.skillItemRenderer = skillItemRenderer;
	}

	public List<MstSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<MstSkill> skills) {
		this.skills = skills;
	}

	public MstSkill getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(MstSkill selectedSkills) {
		this.selectedSkills = selectedSkills;
	}

}
