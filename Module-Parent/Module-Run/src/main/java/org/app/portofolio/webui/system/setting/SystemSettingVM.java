package org.app.portofolio.webui.system.setting;

import java.util.List;

import org.module.hr.model.SystemSetting;
import org.module.hr.service.SystemSettingService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class SystemSettingVM {
	
	@WireVariable
	private SystemSettingService systemSettingService;
	
	private List<SystemSetting> systemSettings;
	
	
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
	
		systemSettings = systemSettingService.getAllSettings();
	}
	
	@Command
	public void doSave() {
		systemSettingService.saveOrUpdateAll(systemSettings);
	}
	
	/*
	 * -------------- GETTER - SETTER -----------------
	 */
	public List<SystemSetting> getSystemSettings() {
		return systemSettings;
	}
	
	public void setSystemSettings(List<SystemSetting> systemSettings) {
		this.systemSettings = systemSettings;
	}
}
