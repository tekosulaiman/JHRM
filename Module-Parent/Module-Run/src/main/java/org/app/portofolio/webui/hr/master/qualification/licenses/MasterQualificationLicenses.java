package org.app.portofolio.webui.hr.master.qualification.licenses;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.common.menu.util.JHRMAdditionalZulPath;
import org.app.portofolio.webui.hr.master.qualification.licenses.model.LicenseListItemRenderer;
import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstSkill;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class MasterQualificationLicenses {

	@Wire("#listBoxLicenses")
	private Listbox listBoxLicenses;

	private LicenseListItemRenderer licenseItemRenderer;
	private List<MstLicense> licenses;
	private MstLicense selectedLicenses;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		// dummy
		licenses = new ArrayList<MstLicense>();
		for(int i = 1; i < 5; i++) {
			MstLicense mstLicense = new MstLicense();
			mstLicense.setIdLicense(i);
			mstLicense.setNameLicense("Skill " + i);
			licenses.add(mstLicense);
		}
		
		
		this.licenseItemRenderer = new LicenseListItemRenderer();
	}
	
	/**
	 * 
	 */
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxLicenses.getModel();
		listModelList.add(0, new MstLicense());
	}
	
	/**
	 * 
	 */
	@Command
	public void doDetail(){
		//TODO ganti dengan action row editing
	}

	
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
