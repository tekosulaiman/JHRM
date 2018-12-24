package org.app.portofolio.webui.hr.transaction.attendance.projectinfo.project;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.transaction.attendance.projectinfo.project.model.ProjectListItemRenderer;
import org.module.hr.model.MstProject;
import org.module.hr.service.AttendanceService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.event.PagingEvent;

public class ProjectListVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxProject")
	private Listbox listboxProject;
	
	@Wire("#pagingProject")
	private Paging pagingProject; 
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstProject mstProject;
	private List<MstProject> mstProjects;
	@WireVariable
	private AttendanceService attendanceService;
	private ListitemRenderer<MstProject> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstProject;
	
	private int startPageNumber = 0;
	private int pageSize = 10; 
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxProject.setCheckmark(true);
		listboxProject.setMultiple(true);
		listboxProject.setStyle("border-style: none;");
		listboxProject.setMold("paging");
		
		int count = attendanceService.getCountMstProjects();

		pagingProject.setTotalSize(count);
		pagingProject.setDetailed(true);
		pagingProject.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingProject.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstProject = new HashMap<String, Object>();
		hashMapMstProject.put("firstResult", refreshActivePage);
		hashMapMstProject.put("maxResults", pagingProject.getPageSize());
		
		mstProjects = attendanceService.getMstProjectPaging(hashMapMstProject);
		listitemRenderer = new ProjectListItemRenderer();
	} 
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, 
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		doPrepareList();
		refreshPageList(startPageNumber);
	}	
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Command
	@NotifyChange("mstProjects")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}		
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstProject getMstProject() {
		return mstProject;
	}

	public void setMstProject(MstProject mstProject) {
		this.mstProject = mstProject;
	}

	public List<MstProject> getMstProjects() {
		return mstProjects;
	}

	public void setMstProjects(List<MstProject> mstProjects) {
		this.mstProjects = mstProjects;
	}

	public ListitemRenderer<MstProject> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstProject> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}	
}