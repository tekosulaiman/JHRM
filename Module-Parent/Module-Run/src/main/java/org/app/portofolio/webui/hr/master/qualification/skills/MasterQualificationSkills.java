package org.app.portofolio.webui.hr.master.qualification.skills;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.MstSkill;
import org.module.hr.service.MasterQualificationService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
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

	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
 
		skills = masterQualificationService.getAllMstSkill(); 
		
		this.skillItemRenderer = new SkillsListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
				save();
			}
		};
	}

	/**
	 * 
	 */
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) listBoxSkills.getModel();
		listModelList.add(0, new MstSkill());
	}

	/**
	 * 
	 */
	@Command
	public void doDetail() {
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Skills.DETAIL_FORM, null, null);
	}
	
	@NotifyChange({"skills"})
	public void save(){
		MstSkill value = skillItemRenderer.getValue();
		if (value.getIdSkill() == null) {
			masterQualificationService.save(value);
		} else {
			masterQualificationService.update(value);
		}
		skills = masterQualificationService.getAllMstSkill();
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
