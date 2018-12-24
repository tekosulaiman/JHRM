package org.app.portofolio.webui.hr.transaction.attendance.projectinfo.customer;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.transaction.attendance.projectinfo.customer.model.CustomerListItemRenderer;
import org.module.hr.model.MstCustomer;
import org.module.hr.service.AttendanceService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;

public class CustomerListVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listBoxCustomer")
	private Listbox listBoxCustomer;
	
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
		listBoxCustomer.setCheckmark(true);
		listBoxCustomer.setMultiple(true);
		listBoxCustomer.setStyle("border-style: none;");
		listBoxCustomer.setMold("paging");
		
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
			
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}