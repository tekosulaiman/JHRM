package org.app.portofolio.webui.hr.master.qualification.skills;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.MstSkill;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class MasterQualificationSkills {

	@Wire("#listBoxSkills")
	private Listbox listBoxSkills;

	private SkillsListItemRenderer skillItemRenderer;
	private List<MstSkill> skills;
	private MstSkill selectedSkills;

	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);

		// dummy
		skills = new ArrayList<MstSkill>();
		for(int i = 1; i < 5; i++) {
			MstSkill ohrmSkill = new MstSkill();
			ohrmSkill.setIdSkill(i);
			ohrmSkill.setNameSkill("Skill " + i);
			ohrmSkill.setDescriptionSkill("Deskripsi untuk Skill " + i);
			skills.add(ohrmSkill);
		}
		
		
		this.skillItemRenderer = new SkillsListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
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
