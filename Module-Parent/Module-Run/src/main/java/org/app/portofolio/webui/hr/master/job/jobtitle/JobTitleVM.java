package org.app.portofolio.webui.hr.master.job.jobtitle;

import java.util.HashMap;
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
import org.zkoss.zul.Paging;
import org.zkoss.zul.event.PagingEvent;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class JobTitleVM {
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#listBoxJobTitle")
	private Listbox listBoxJobTitle;
	
	@Wire("#pagingJobTitle")
	private Paging pagingJobTitle;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@WireVariable
	private MasterJobService masterJobService;
	private List<MstJobtitle> mstJobtitles;
	private MstJobtitle mstJobtitle;
	private MstJobtitleListItemRenderer mstJobtitleListItemRenderer;
	private JobTitleListModel jobTitleListModel;
	
	private HashMap<String, Object> hashMapJobTitle;
	
	private int startPageNumber = 0;
	private int pageSize = 10;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listBoxJobTitle.setCheckmark(true);
		listBoxJobTitle.setMultiple(true);
		//listBoxJobTitle.setRows(10);
		listBoxJobTitle.setStyle("border-style: none;");
		/*listBoxJobTitle.setMold("paging");
		listBoxJobTitle.setPaginal(pagingJobTitle);
		
		long count = masterJobService.getCountMsJobtitles();
		int i = (int) count;
		
		pagingJobTitle.setTotalSize(i);
		pagingJobTitle.setDetailed(true);
		pagingJobTitle.setPageSize(pageSize);*/
	}
	
	private void refreshPageList(int refreshActivePage) {
		/*if (refreshActivePage == 0) {
			pagingJobTitle.setActivePage(0);
		}*/
		
		refreshActivePage += 1;
		
		hashMapJobTitle = new HashMap<String, Object>();
		hashMapJobTitle.put("firstResult", refreshActivePage);
		hashMapJobTitle.put("maxResult", listBoxJobTitle.getPageSize()/*pagingJobTitle.getPageSize()*/);
		
		mstJobtitles = masterJobService.getByRequestMstJobtitles(hashMapJobTitle);
		mstJobtitleListItemRenderer = new MstJobtitleListItemRenderer();
	}

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object,
		@ExecutionArgParam("mstJobtitle") MstJobtitle mstJobtitle) {
		
		Selectors.wireComponents(component, this, false);

		refreshPageList(startPageNumber);
		doPrepareList();
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage();
		refreshPageList(startPageNumber);
	}

	@Command
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
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
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

	public JobTitleListModel getJobTitleListModel() {
		return jobTitleListModel;
	}

	public void setJobTitleListModel(JobTitleListModel jobTitleListModel) {
		this.jobTitleListModel = jobTitleListModel;
	}
}