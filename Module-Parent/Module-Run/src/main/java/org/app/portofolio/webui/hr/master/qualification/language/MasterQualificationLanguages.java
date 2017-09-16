package org.app.portofolio.webui.hr.master.qualification.language;

import java.util.List;

import org.app.portofolio.webui.hr.master.qualification.language.model.LanguageListItemRenderer;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstSkill;
import org.module.hr.service.MasterQualificationService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

public class MasterQualificationLanguages {

	/* ------------ Zul -------------- */
	@Wire("#listBoxLanguage")
	private Listbox listBoxLanguage;

	/* ----------Services -------------*/
	@WireVariable
	private MasterQualificationService masterQualificationService;
	
	/* ------------ Beans -------------*/
	private LanguageListItemRenderer languageListItemRenderer;
	private List<MstLanguage> languages;
	private MstLanguage selectedlanguage;

	public void doPrepareList(){
		listBoxLanguage.setCheckmark(true);
		listBoxLanguage.setMultiple(true);
		listBoxLanguage.setRows(15);
		listBoxLanguage.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);

		languages = masterQualificationService.getAllMstLanguage();
		languageListItemRenderer= new LanguageListItemRenderer();
		
		listBoxLanguage.setModel(new ListModelList<MstLicense>());
		listBoxLanguage.setItemRenderer(languageListItemRenderer);
		
		doPrepareList();
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) listBoxLanguage.getModel();
		listModelList.add(0, new MstLanguage());
	}

	@GlobalCommand
	@NotifyChange("languages")
	public void refreshAfterSaveOrUpdate(){
		languages = masterQualificationService.getAllMstLanguage();
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstLanguage> listModelListLanguage = (ListModelList) listBoxLanguage.getModel();
		
		if(listBoxLanguage.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstLanguage language : listModelListLanguage){
			 				if(listModelListLanguage.isSelected(language)){
			 					masterQualificationService.delete(language);
			 				}
			 			}
			 			
			 			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
			 		}else{
			 			return;
			 		}
			 	}
			});
		}
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
