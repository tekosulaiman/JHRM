package org.app.portofolio.webui.administration;

import java.util.List;

import org.module.hr.model.MstSetting;
import org.module.hr.service.AdministrationService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class SettingVM {
	
	/*--------- Services ---------*/
	@WireVariable
	private AdministrationService administrationService;
	
	/*--------- Beans ---------*/
	private List<MstSetting> listSetting;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		this.listSetting = administrationService.getAllSettings();
	}
	
	@Command
	public void doSave() throws Exception {
		administrationService.saveAll(listSetting);
	}
	
	/* ----------- GETTER - SETTER -----------*/
	public List<MstSetting> getListSetting() {
		return listSetting;
	}
	
	public void setListSetting(List<MstSetting> listSetting) {
		this.listSetting = listSetting;
	}
}
