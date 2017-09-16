package org.app.portofolio.webui.hr.master.job.jobtitle;

import java.util.List;

import org.app.portofolio.webui.hr.master.job.jobtitle.model.MstJobtitleListItemRenderer;
import org.module.hr.model.MstJobtitle;
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

public class JobTitleVM {
	
	/* ------------ Zul -------------- */
	@Wire("#listBoxJobTitle")
	private Listbox listBoxJobTitle;

	/* ----------Services -------------*/
	@WireVariable
	private MasterJobService masterJobService;
	
	/* ------------ Beans -------------*/
	private List<MstJobtitle> mstJobtitles;
	private MstJobtitle mstJobtitle;
	private MstJobtitleListItemRenderer mstJobtitleListItemRenderer;

	public void doPrepareList(){
		listBoxJobTitle.setCheckmark(true);
		listBoxJobTitle.setMultiple(true);
		listBoxJobTitle.setRows(15);
		listBoxJobTitle.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		mstJobtitles = masterJobService.getAllMstJobtitles();
		mstJobtitleListItemRenderer = new MstJobtitleListItemRenderer();
		
		listBoxJobTitle.setModel(new ListModelList<MstJobtitle>());
		listBoxJobTitle.setItemRenderer(mstJobtitleListItemRenderer);
		
		doPrepareList();
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxJobTitle.getModel();
		listModelList.add(0,  new MstJobtitle());
	}

	@GlobalCommand
	@NotifyChange("mstJobtitles")
	public void refreshAfterSaveOrUpdate(){
		mstJobtitles = masterJobService.getAllMstJobtitles();
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstJobtitle> listModelListJobtitle= (ListModelList) listBoxJobTitle.getModel();
		
		if(listBoxJobTitle.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstJobtitle jobtitle: listModelListJobtitle){
			 				if(listModelListJobtitle.isSelected(jobtitle)){
			 					masterJobService.delete(jobtitle);
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
	
	public MstJobtitle getMstJobtitle() {
		return mstJobtitle;
	}

	public void setMstJobtitle(MstJobtitle mstJobtitle) {
		this.mstJobtitle = mstJobtitle;
	}

	public List<MstJobtitle> getMstJobtitles() {
		return mstJobtitles;
	}

	public void setMstJobtitles(List<MstJobtitle> mstJobtitles) {
		this.mstJobtitles = mstJobtitles;
	}

	public MasterJobService getMasterJobService() {
		return masterJobService;
	}
	
	public void setMasterJobService(MasterJobService masterJobService) {
		this.masterJobService = masterJobService;
	}

	public MstJobtitleListItemRenderer getMstJobtitleListItemRenderer() {
		return mstJobtitleListItemRenderer;
	}

	public void setMstJobtitleListItemRenderer(MstJobtitleListItemRenderer mstJobtitleListItemRenderer) {
		this.mstJobtitleListItemRenderer = mstJobtitleListItemRenderer;
	}
}