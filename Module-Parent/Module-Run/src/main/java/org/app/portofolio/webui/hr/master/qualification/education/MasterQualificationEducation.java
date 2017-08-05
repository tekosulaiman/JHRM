package org.app.portofolio.webui.hr.master.qualification.education;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.master.qualification.education.model.EducationListItemRenderer;
import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.MstEducation;
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

public class MasterQualificationEducation {

	@Wire("#listBoxEducation")
	private Listbox listBoxEducation;

	private EducationListItemRenderer educationListItemRenderer;
	private List<MstEducation> educations;
	private MstEducation selectedEducation;

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
		educations = new ArrayList<MstEducation>();
		for(int i = 1; i < 5; i++) {
			MstEducation mstEducation = new MstEducation();
			mstEducation.setIdEducation(i);
			mstEducation.setEducationName("Education " + i);
			educations.add(mstEducation);
		}
		
		
		this.educationListItemRenderer = new EducationListItemRenderer();
	}

	/**
	 * 
	 */
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) listBoxEducation.getModel();
		listModelList.add(0, new MstEducation());
	}

	/**
	 * 
	 */
	@Command
	public void doDetail() {
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Education.DETAIL_FORM, null, null);
	}

	public EducationListItemRenderer getEducationListItemRenderer() {
		return educationListItemRenderer;
	}

	public void setEducationListItemRenderer(EducationListItemRenderer educationListItemRenderer) {
		this.educationListItemRenderer = educationListItemRenderer;
	}

	public List<MstEducation> getEducations() {
		return educations;
	}

	public void setEducations(List<MstEducation> educations) {
		this.educations = educations;
	}

	public MstEducation getSelectedEducation() {
		return selectedEducation;
	}

	public void setSelectedEducation(MstEducation selectedEducation) {
		this.selectedEducation = selectedEducation;
	}

}
