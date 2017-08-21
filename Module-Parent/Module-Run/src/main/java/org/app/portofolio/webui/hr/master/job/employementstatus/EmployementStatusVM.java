package org.app.portofolio.webui.hr.master.job.employementstatus;

import java.util.List;

import org.app.portofolio.webui.hr.master.job.employementstatus.model.MstEmployementStatusListItemRenderer;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.service.MstEmployementStatusService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class EmployementStatusVM {
	
	@Wire("#listBoxEmployementStatus")
	private Listbox listBoxEmployementStatus;

	private MstEmployementStatus mstEmployementStatus;
	private List<MstEmployementStatus> employementStatus;
	@WireVariable
	private MstEmployementStatusService mstEmployementStatusService;
	private MstEmployementStatusListItemRenderer mstEmployementStatusListItemRenderer;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		employementStatus = mstEmployementStatusService.getAllMstEmployementStatus();

		this.mstEmployementStatusListItemRenderer = new MstEmployementStatusListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
			}
		};
		
		listBoxEmployementStatus.setModel(new ListModelList<MstEmployementStatus>(employementStatus));
	}

	public MstEmployementStatus getMstEmployementStatus() {
		return mstEmployementStatus;
	}

	public void setMstEmployementStatus(MstEmployementStatus mstEmployementStatus) {
		this.mstEmployementStatus = mstEmployementStatus;
	}

	public List<MstEmployementStatus> getEmployementStatus() {
		return employementStatus;
	}

	public void setEmployementStatus(List<MstEmployementStatus> employementStatus) {
		this.employementStatus = employementStatus;
	}

	public MstEmployementStatusService getMstEmployementStatusService() {
		return mstEmployementStatusService;
	}

	public void setMstEmployementStatusService(MstEmployementStatusService mstEmployementStatusService) {
		this.mstEmployementStatusService = mstEmployementStatusService;
	}

	public MstEmployementStatusListItemRenderer getMstEmployementStatusListItemRenderer() {
		return mstEmployementStatusListItemRenderer;
	}

	public void setMstEmployementStatusListItemRenderer(MstEmployementStatusListItemRenderer mstEmployementStatusListItemRenderer) {
		this.mstEmployementStatusListItemRenderer = mstEmployementStatusListItemRenderer;
	}
}