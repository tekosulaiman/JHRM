package org.app.portofolio.webui.hr.master.job.jobcategory;

import java.util.List;

import org.app.portofolio.webui.hr.master.job.jobcategory.model.MstJobCategoryListItemRenderer;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstLicense;
import org.module.hr.service.MasterJobService;
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

public class JobCategoryVM {
	
	/* ------------ Zul -------------- */
	@Wire("#listBoxJobCategory")
	private Listbox listBoxJobCategory;

	/* ----------Services -------------*/
	@WireVariable
	private MasterJobService masterJobService;
	
	/* ------------ Beans -------------*/
	private MstJobCategory mstJobCategory;
	private List<MstJobCategory> mstJobCategories;
	private MstJobCategoryListItemRenderer mstJobCategoryListItemRenderer;

	public void doPrepareList(){
		listBoxJobCategory.setCheckmark(true);
		listBoxJobCategory.setMultiple(true);
		listBoxJobCategory.setRows(15);
		listBoxJobCategory.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		mstJobCategories = masterJobService.getAllMstJobCategories();
	
		mstJobCategoryListItemRenderer = new MstJobCategoryListItemRenderer();
		
		listBoxJobCategory.setModel(new ListModelList<MstLicense>());
		listBoxJobCategory.setItemRenderer(mstJobCategoryListItemRenderer);
		
		doPrepareList();
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxJobCategory.getModel();
		listModelList.add(0, new MstJobCategory());
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstJobCategory> listModelListLicenses = (ListModelList) listBoxJobCategory.getModel();
		
		if(listBoxJobCategory.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstJobCategory jobCategory: listModelListLicenses){
			 				if(listModelListLicenses.isSelected(jobCategory)){
			 					masterJobService.delete(jobCategory);
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
	
	@GlobalCommand
	@NotifyChange("mstJobCategories")
	public void refreshAfterSaveOrUpdate(){
		mstJobCategories = masterJobService.getAllMstJobCategories();
	}
	
	/*
	 * -------------- GETTER - SETTER -----------------
	 */
	
	public MstJobCategory getMstJobCategory() {
		return mstJobCategory;
	}

	public void setMstJobCategory(MstJobCategory mstJobCategory) {
		this.mstJobCategory = mstJobCategory;
	}

	public List<MstJobCategory> getMstJobCategories() {
		return mstJobCategories;
	}

	public void setMstJobCategories(List<MstJobCategory> mstJobCategories) {
		this.mstJobCategories = mstJobCategories;
	}

	public MasterJobService getMasterJobService() {
		return masterJobService;
	}
	
	public void setMasterJobService(MasterJobService masterJobService) {
		this.masterJobService = masterJobService;
	}

	public MstJobCategoryListItemRenderer getMstJobCategoryListItemRenderer() {
		return mstJobCategoryListItemRenderer;
	}

	public void setMstJobCategoryListItemRenderer(MstJobCategoryListItemRenderer mstJobCategoryListItemRenderer) {
		this.mstJobCategoryListItemRenderer = mstJobCategoryListItemRenderer;
	}
}