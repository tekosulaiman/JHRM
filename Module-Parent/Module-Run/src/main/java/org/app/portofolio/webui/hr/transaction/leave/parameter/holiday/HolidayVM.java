package org.app.portofolio.webui.hr.transaction.leave.parameter.holiday;

import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.transaction.leave.parameter.holiday.model.MstHolidayListItemRenderer;
import org.module.hr.model.MstHoliday;
import org.module.hr.service.LeaveService;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;

public class HolidayVM {
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Wire component
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@Wire("#textboxFilter")
	private Textbox textboxFilter;
	
	@Wire("#listboxHoliday")
	private Listbox listboxHoliday;
	
	@Wire("#pagingHoliday")
	private Paging pagingHoliday; 
	
	 /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Service yang dibutuhkan sesuai bisnis proses
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	private MstHoliday mstHoliday;
	private List<MstHoliday> mstHolidays;
	@WireVariable
	private LeaveService leaveService;
	private ListitemRenderer<MstHoliday> listitemRenderer;
	
	private HashMap<String, Object> hashMapHoliday;
	
	private int startPageNumber = 0;
	private int pageSize = 10; 
	
	 /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function Custom sesuai kebutuhan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void doPrepareList(){
		listboxHoliday.setCheckmark(true);
		listboxHoliday.setMultiple(true);
		listboxHoliday.setStyle("border-style: none;");
		listboxHoliday.setMold("paging");
		
		int count = leaveService.getCountAllMstHolidays();

		pagingHoliday.setTotalSize(count);
		pagingHoliday.setDetailed(true);
		pagingHoliday.setPageSize(pageSize);
	}
	
	private void refreshPageList(int refreshActivePage) {
		if (refreshActivePage == 0) {
			pagingHoliday.setActivePage(0);
		}
		
		refreshActivePage += 1;
		
		hashMapHoliday = new HashMap<String, Object>();
		hashMapHoliday.put("firstResult", refreshActivePage);
		hashMapHoliday.put("maxResults", pagingHoliday.getPageSize());
		
		mstHolidays = leaveService.getMstHolidayPaging(hashMapHoliday);
		listitemRenderer = new MstHolidayListItemRenderer();
	} 
	
	 /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Getter Setter
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
}