package org.app.portofolio.webui.hr.employee.model;

import java.util.List;

import org.module.hr.model.MstMembership;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.model.TrsEmployeeMembership;
import org.module.hr.service.MasterQualificationService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Bandpopup;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class MembershipListItemRenderer implements ListitemRenderer<TrsEmployeeMembership>{
	
	@Wire("#listBoxMembership")
	private Listbox listBoxMembership;
	
	@WireVariable
	private MasterQualificationService masterQualificationService;
	
	private MstMembership mstMembership;
	private List<MstMembership> mstMemberships;
	private MstMembership selectedMstMembership;
	
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object) {
		mstMemberships = masterQualificationService.getAllMstMembership();
	}

	@Override
	public void render(Listitem item, TrsEmployeeMembership trsEmployeeMembership, int index) throws Exception {
		Listcell listcell;
		
		final Button buttonSave = new Button();
		buttonSave.setImage("/images/icons/btn_save.gif");

		final Button buttonEdit = new Button();
		buttonEdit.setImage("/images/icons/btn_edit.gif");

		final Button buttonDelete = new Button();
		buttonDelete.setImage("/images/icons/btn_delete.gif");

		final Button buttonCancel = new Button();
		buttonCancel.setImage("/images/icons/btn_cancel.gif");
		
		Include include = new Include();
		include.setSrc("/WEB-INF/pages/module_hr/employee/bandBoxPopupMembership.zul");
		
		Bandbox bandbox = new Bandbox();
		Bandpopup bandpopup = new Bandpopup();
		bandbox.appendChild(bandpopup);
		bandpopup.appendChild(include);
		
		listcell = new Listcell();
		bandbox.setParent(listcell);
		listcell.setParent(item);
		
		if (trsEmployeeMembership.getIdEmployeeMembership() == null){
			buttonEdit.setVisible(false);
			buttonSave.setVisible(false);
		} else {
			buttonSave.setVisible(false);
			buttonCancel.setVisible(false);
			buttonDelete.setVisible(false);
		}
	}

	public MasterQualificationService getMasterQualificationService() {
		return masterQualificationService;
	}

	public void setMasterQualificationService(MasterQualificationService masterQualificationService) {
		this.masterQualificationService = masterQualificationService;
	}

	public MstMembership getMstMembership() {
		return mstMembership;
	}

	public void setMstMembership(MstMembership mstMembership) {
		this.mstMembership = mstMembership;
	}

	public List<MstMembership> getMstMemberships() {
		return mstMemberships;
	}

	public void setMstMemberships(List<MstMembership> mstMemberships) {
		this.mstMemberships = mstMemberships;
	}

	public MstMembership getSelectedMstMembership() {
		return selectedMstMembership;
	}

	public void setSelectedMstMembership(MstMembership selectedMstMembership) {
		this.selectedMstMembership = selectedMstMembership;
	}
	
	

}
