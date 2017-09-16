package org.app.portofolio.webui.hr.master.job.employementstatus;

import java.util.List;

import org.app.portofolio.webui.hr.master.job.employementstatus.model.MstEmployementStatusListItemRenderer;
import org.module.hr.model.MstEmployementStatus;
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

public class EmployementStatusVM {
	
	/* ------------ Zul -------------- */
	@Wire("#listBoxEmployementStatus")
	private Listbox listBoxEmployementStatus;

	/* ----------Services -------------*/
	@WireVariable
	private MasterJobService masterJobService;
	
	/* ------------ Beans -------------*/
	private MstEmployementStatus mstEmployementStatus;
	private List<MstEmployementStatus> mstEmployementStatusList;
	private MstEmployementStatusListItemRenderer mstEmployementStatusListItemRenderer;

	public void doPrepareList(){
		listBoxEmployementStatus.setCheckmark(true);
		listBoxEmployementStatus.setMultiple(true);
		listBoxEmployementStatus.setRows(15);
		listBoxEmployementStatus.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		mstEmployementStatusList = masterJobService.getAllMstEmployementStatus();
		mstEmployementStatusListItemRenderer = new MstEmployementStatusListItemRenderer();
		
		listBoxEmployementStatus.setModel(new ListModelList<MstEmployementStatus>());
		listBoxEmployementStatus.setItemRenderer(mstEmployementStatusListItemRenderer);
		
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxEmployementStatus.getModel();
		listModelList.add(0,  new MstEmployementStatus());
	}

	@GlobalCommand
	@NotifyChange("mstEmployementStatusList")
	public void refreshAfterSaveOrUpdate(){
		mstEmployementStatusList = masterJobService.getAllMstEmployementStatus();
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstEmployementStatus> listModelListEmploymentStatus = (ListModelList) listBoxEmployementStatus.getModel();
		
		if(listBoxEmployementStatus.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstEmployementStatus employmentStatus: listModelListEmploymentStatus){
			 				if(listModelListEmploymentStatus.isSelected(employmentStatus)){
			 					masterJobService.delete(employmentStatus);
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
	 * -------------- GETTER - SETTER -----------------
	 */
	
	public MstEmployementStatus getMstEmployementStatus() {
		return mstEmployementStatus;
	}

	public void setMstEmployementStatus(MstEmployementStatus mstEmployementStatus) {
		this.mstEmployementStatus = mstEmployementStatus;
	}

	public List<MstEmployementStatus> getMstEmployementStatusList() {
		return mstEmployementStatusList;
	}
	
	public void setMstEmployementStatusList(List<MstEmployementStatus> mstEmployementStatusList) {
		this.mstEmployementStatusList = mstEmployementStatusList;
	}
	
	public MasterJobService getMasterJobService() {
		return masterJobService;
	}
	
	public void setMasterJobService(MasterJobService masterJobService) {
		this.masterJobService = masterJobService;
	}

	public MstEmployementStatusListItemRenderer getMstEmployementStatusListItemRenderer() {
		return mstEmployementStatusListItemRenderer;
	}

	public void setMstEmployementStatusListItemRenderer(MstEmployementStatusListItemRenderer mstEmployementStatusListItemRenderer) {
		this.mstEmployementStatusListItemRenderer = mstEmployementStatusListItemRenderer;
	}
}