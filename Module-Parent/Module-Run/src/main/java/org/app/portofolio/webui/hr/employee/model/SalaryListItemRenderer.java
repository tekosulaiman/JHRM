package org.app.portofolio.webui.hr.employee.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeSalary;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class SalaryListItemRenderer extends InlineListItemRenderer<TrsEmployeeSalary>{
	@Override
	public void renderListItem(Listitem item, TrsEmployeeSalary value, int index) throws Exception{
		Textbox textboxSalaryComponent = new Textbox();
		
		Textbox textboxPayFrequency = new Textbox();
		
		Textbox textboxCurrency = new Textbox();
		
		Textbox textboxAmount = new Textbox();
		
		Textbox textboxComment = new Textbox();
		
		Textbox textboxShowDirectDepositDetails = new Textbox();
		
		Label labelSalaryComponent = new Label();
		
		Label labelPayFrequency = new Label();
		
		Label labelAmount = new Label();
		
		Label labelCurrency = new Label();
		
		Label labelComment = new Label();
		
		Label labelShowDirectDepositDetails = new Label();
	
	}
	
		
}
