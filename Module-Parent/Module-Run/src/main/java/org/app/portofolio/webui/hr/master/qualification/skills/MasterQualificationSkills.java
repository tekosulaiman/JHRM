package org.app.portofolio.webui.hr.master.qualification.skills;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.OhrmSkill;
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
	private List<OhrmSkill> skills;
	private OhrmSkill selectedSkills;

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++ Inisialize Methode MVVM yang pertama kali dijalankan
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++
	 */
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);

		// dummy
		skills = new ArrayList<OhrmSkill>();
		for(int i = 1; i < 5; i++) {
			OhrmSkill ohrmSkill = new OhrmSkill();
			ohrmSkill.setId(i);
			ohrmSkill.setName("Skill " + i);
			ohrmSkill.setDescription("Deskripsi untuk Skill " + i);
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
		listModelList.add(0, new OhrmSkill());
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

	public List<OhrmSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<OhrmSkill> skills) {
		this.skills = skills;
	}

	public OhrmSkill getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(OhrmSkill selectedSkills) {
		this.selectedSkills = selectedSkills;
	}

}
