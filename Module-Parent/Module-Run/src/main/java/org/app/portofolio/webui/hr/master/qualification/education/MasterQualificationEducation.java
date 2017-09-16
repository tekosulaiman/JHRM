package org.app.portofolio.webui.hr.master.qualification.education;

import java.util.List;

import org.app.portofolio.webui.hr.master.qualification.education.model.EducationListItemRenderer;
import org.module.hr.model.MstEducation;
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

public class MasterQualificationEducation {

	/* ------------ Zul -------------- */
	@Wire("#listBoxEducation")
	private Listbox listBoxEducation;

	/* ----------Services -------------*/
	@WireVariable
	private MasterQualificationService masterQualificationService;
	
	/* ------------ Beans -------------*/
	private EducationListItemRenderer educationListItemRenderer;
	private List<MstEducation> educations;
	private MstEducation selectedEducation;

	public void doPrepareList(){
		listBoxEducation.setCheckmark(true);
		listBoxEducation.setMultiple(true);
		listBoxEducation.setRows(15);
		listBoxEducation.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		educations = masterQualificationService.getAllMstEducation();
		educationListItemRenderer = new EducationListItemRenderer();
		
		listBoxEducation.setModel(new ListModelList<MstLicense>());
		listBoxEducation.setItemRenderer(educationListItemRenderer);
		
		doPrepareList();
	}

	/**
	 * 
	 */
	@Command
	public void doNew() {
		ListModelList listModelList = (ListModelList) listBoxEducation.getModel();
		listModelList.add(0, new MstEducation());
	}

	@GlobalCommand
	@NotifyChange("educations")
	public void refreshAfterSaveOrUpdate(){
		educations = masterQualificationService.getAllMstEducation();
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstEducation> listModelListEducations = (ListModelList) listBoxEducation.getModel();
		
		if(listBoxEducation.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstEducation education: listModelListEducations){
			 				if(listModelListEducations.isSelected(education)){
			 					masterQualificationService.delete(education);
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
