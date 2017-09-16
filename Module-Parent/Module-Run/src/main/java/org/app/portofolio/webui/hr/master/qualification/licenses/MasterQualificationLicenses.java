package org.app.portofolio.webui.hr.master.qualification.licenses;

import java.util.List;

import org.app.portofolio.webui.hr.master.qualification.licenses.model.LicenseListItemRenderer;
import org.module.hr.model.MstLicense;
import org.module.hr.service.MasterQualificationService;
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

public class MasterQualificationLicenses {

	/* ------------ Zul -------------- */
	@Wire("#listBoxLicenses")
	private Listbox listBoxLicenses;

	/* ----------Services -------------*/
	@WireVariable
	private MasterQualificationService masterQualificationService;
	
	/* ------------ Beans -------------*/
	private LicenseListItemRenderer licenseItemRenderer;
	private List<MstLicense> licenses;
	private MstLicense selectedLicenses;
	
	public void doPrepareList(){
		listBoxLicenses.setCheckmark(true);
		listBoxLicenses.setMultiple(true);
		listBoxLicenses.setRows(15);
		listBoxLicenses.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		licenses = masterQualificationService.getAllMstLicense();
		licenseItemRenderer = new LicenseListItemRenderer();
		
		listBoxLicenses.setModel(new ListModelList<MstLicense>());
		listBoxLicenses.setItemRenderer(licenseItemRenderer);
		
		doPrepareList();
	}
	
	/**
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxLicenses.getModel();
		listModelList.add(0, new MstLicense());
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstLicense> listModelListLicenses = (ListModelList) listBoxLicenses.getModel();
		
		if(listBoxLicenses.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstLicense license : listModelListLicenses){
			 				if(listModelListLicenses.isSelected(license)){
			 					masterQualificationService.delete(license);
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
	
	@GlobalCommand
	@NotifyChange("licenses")
	public void refreshAfterSaveOrUpdate(){
		licenses = masterQualificationService.getAllMstLicense();
	}

	/*
	 * -------------- GETTER - SETTER -----------------
	 */
	
	public LicenseListItemRenderer getLicenseItemRenderer() {
		return licenseItemRenderer;
	}

	public void setLicenseItemRenderer(LicenseListItemRenderer licenseItemRenderer) {
		this.licenseItemRenderer = licenseItemRenderer;
	}

	public List<MstLicense> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<MstLicense> licenses) {
		this.licenses = licenses;
	}

	public MstLicense getSelectedLicenses() {
		return selectedLicenses;
	}

	public void setSelectedLicenses(MstLicense selectedLicenses) {
		this.selectedLicenses = selectedLicenses;
	}
	
}
