package org.app.portofolio.webui.hr.transaction.attendance.projectinfo.customer;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.transaction.attendance.projectinfo.customer.model.CustomerListItemRenderer;
import org.module.hr.model.MstCustomer;
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
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.event.PagingEvent;

public class CustomerListVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxCustomer")
	private Listbox listboxCustomer;
	
	@Wire("#pagingCustomer")
	private Paging pagingCustomer; 
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstCustomer mstCustomer;
	private List<MstCustomer> mstCustomers;
	@WireVariable
	private AttendanceService attendanceService;
	private ListitemRenderer<MstCustomer> listitemRenderer;
	
	private HashMap<String, Object> hashMapMstCustomer;
	
	private int startPageNumber = 0;
	private int pageSize = 10; 
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxCustomer.setCheckmark(true);
		listboxCustomer.setMultiple(true);
		listboxCustomer.setStyle("border-style: none;");
		listboxCustomer.setMold("paging");
		
		int count = attendanceService.getCountMstCustomers();

		pagingCustomer.setTotalSize(count);
		pagingCustomer.setDetailed(true);
		pagingCustomer.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingCustomer.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapMstCustomer = new HashMap<String, Object>();
		hashMapMstCustomer.put("firstResult", refreshActivePage);
		hashMapMstCustomer.put("maxResults", pagingCustomer.getPageSize());
		
		mstCustomers = attendanceService.getMstCustomerPaging(hashMapMstCustomer);
		listitemRenderer = new CustomerListItemRenderer();
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
	@NotifyChange("mstCustomers")
	public void onPaging(@ContextParam(ContextType.TRIGGER_EVENT) PagingEvent pagingEvent){
		startPageNumber = pagingEvent.getActivePage() * pageSize;
		refreshPageList(startPageNumber);
	}		
	
	@Command
	public void doNew(){
		final ListModelList<MstCustomer> listModelListCustomer = (ListModelList) listboxCustomer.getModel();
		listModelListCustomer.add(0, new MstCustomer());
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public MstCustomer getMstCustomer() {
		return mstCustomer;
	}

	public void setMstCustomer(MstCustomer mstCustomer) {
		this.mstCustomer = mstCustomer;
	}

	public List<MstCustomer> getMstCustomers() {
		return mstCustomers;
	}

	public void setMstCustomers(List<MstCustomer> mstCustomers) {
		this.mstCustomers = mstCustomers;
	}

	public ListitemRenderer<MstCustomer> getListitemRenderer() {
		return listitemRenderer;
	}

	public void setListitemRenderer(ListitemRenderer<MstCustomer> listitemRenderer) {
		this.listitemRenderer = listitemRenderer;
	}	
}