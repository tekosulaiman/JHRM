package org.app.portofolio.webui.hr.employee.model;

import java.util.Date;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeLicense;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class EmployeeLicenseListItemRenderer extends InlineListItemRenderer<TrsEmployeeLicense>{

	static final String NOT_SET = "NOT_SET";
	
	@Override
	public void renderListItem(Listitem item, TrsEmployeeLicense value, int index) throws Exception{
		Textbox textboxLicenseType = new Textbox();
		textboxLicenseType.setValue(value.getIdLicense().getNameLicense());
		textboxLicenseType.setVisible(false);
		
		Datebox dateboxIssuedDate = new Datebox();
		dateboxIssuedDate.setValue(new Date());
		dateboxIssuedDate.setVisible(false);
		
		Datebox dateboxExpiryDate = new Datebox();
		dateboxExpiryDate.setValue(new Date());
		dateboxExpiryDate.setVisible(false);
		
		Label labelLicenseType = new Label();
		labelLicenseType.setValue(value.getIdLicense().getNameLicense());
		
		Label labelIssuedDate = new Label();
		labelIssuedDate.setValue(new Date().toString());
		
		Label labelExpiryDate = new Label();
		labelExpiryDate.setValue(new Date().toString());
		
		setEditingComponents(textboxLicenseType, dateboxIssuedDate, dateboxExpiryDate);
		setLabelingComponents(labelLicenseType, labelIssuedDate, labelExpiryDate);
		
		if (value.getIdEmployeeLicense() == null){
			textboxLicenseType.setVisible(true);
			dateboxIssuedDate.setVisible(true);
			dateboxExpiryDate.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		textboxLicenseType.setParent(listcell);
		labelLicenseType.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		dateboxIssuedDate.setParent(listcell);
		labelIssuedDate.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		dateboxExpiryDate.setParent(listcell);
		labelExpiryDate.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
