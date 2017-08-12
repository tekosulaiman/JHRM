package org.app.portofolio.webui.hr.master.qualification.language;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.master.qualification.education.model.EducationListItemRenderer;
import org.app.portofolio.webui.hr.master.qualification.language.model.LanguageListItemRenderer;
import org.module.hr.model.MstEducation;
import org.module.hr.model.MstLanguage;
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

public class MasterQualificationLanguages {

	@Wire("#listBoxLanguage")
	private Listbox listBoxLanguage;

	private LanguageListItemRenderer languageListItemRenderer;
	private List<MstLanguage> languages;
	private MstLanguage selectedlanguage;

	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);

		// dummy
		languages = new ArrayList<MstLanguage>();
		for (int i = 1; i < 5; i++) {
			MstLanguage mstLanguage = new MstLanguage();
			mstLanguage.setIdLanguage(i);
			mstLanguage.setNameLanguage("Language " + i);
			languages.add(mstLanguage);
		}

		this.languageListItemRenderer = new LanguageListItemRenderer();
	}

	/**
	 * 
	 */
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) listBoxLanguage.getModel();
		listModelList.add(0, new MstLanguage());
	}

	/**
	 * 
	 */
	@Command
	public void doDetail() {
		Executions.createComponents(JHRMAdditionalZulPath.MasterData.Qualifications.Education.DETAIL_FORM, null, null);
	}

	
	/*
	 * ------------ GETTER - SETTER -------------------
	 */
	public LanguageListItemRenderer getLanguageListItemRenderer() {
		return languageListItemRenderer;
	}

	public void setLanguageListItemRenderer(LanguageListItemRenderer languageListItemRenderer) {
		this.languageListItemRenderer = languageListItemRenderer;
	}

	public List<MstLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<MstLanguage> languages) {
		this.languages = languages;
	}

	public MstLanguage getSelectedlanguage() {
		return selectedlanguage;
	}

	public void setSelectedlanguage(MstLanguage selectedlanguage) {
		this.selectedlanguage = selectedlanguage;
	}

}
