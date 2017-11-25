package org.app.portofolio.webui.hr.master.job.paygrade;

import java.util.List;

import org.app.portofolio.webui.hr.master.job.paygrade.model.MstPaygradeListItemRenderer;
import org.module.hr.model.MstPaygrade;
import org.module.hr.service.MasterJobService;
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

public class PayGradeVM {
	
	@Wire("#listBoxPayGrade")
	private Listbox listBoxPayGrade;

	private MstPaygrade mstPaygrade;
	private List<MstPaygrade> mstPaygrades;
	@WireVariable
	private MasterJobService masterJobService;
	private MstPaygradeListItemRenderer mstPaygradeListItemRenderer;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		mstPaygrades = masterJobService.getAllMstPaygrades();

		this.mstPaygradeListItemRenderer = new MstPaygradeListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
			}
		};
		
		listBoxPayGrade.setModel(new ListModelList<MstPaygrade>(mstPaygrades));
	}

	public MstPaygrade getMstPaygrade() {
		return mstPaygrade;
	}

	public void setMstPaygrade(MstPaygrade mstPaygrade) {
		this.mstPaygrade = mstPaygrade;
	}

	public List<MstPaygrade> getMstPaygrades() {
		return mstPaygrades;
	}

	public void setMstPaygrades(List<MstPaygrade> mstPaygrades) {
		this.mstPaygrades = mstPaygrades;
	}

	public MasterJobService getMasterJobService() {
		return masterJobService;
	}

	public void setMasterJobService(MasterJobService masterJobService) {
		this.masterJobService = masterJobService;
	}

	public MstPaygradeListItemRenderer getMstPaygradeListItemRenderer() {
		return mstPaygradeListItemRenderer;
	}

	public void setMstPaygradeListItemRenderer(MstPaygradeListItemRenderer mstPaygradeListItemRenderer) {
		this.mstPaygradeListItemRenderer = mstPaygradeListItemRenderer;
	}
}