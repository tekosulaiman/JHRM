package org.app.portofolio.webui.employee.model;

import java.util.Date;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeImmigration;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class ImmigrationListItemRenderer extends InlineListItemRenderer<TrsEmployeeImmigration>{
	@Override
	public void renderListItem(Listitem item, TrsEmployeeImmigration value, int index) throws Exception{
		Textbox textboxDocument = new Textbox();
		textboxDocument.setValue(value.getDocument());
		textboxDocument.setVisible(false);
		
		Textbox textboxNumber = new Textbox();
		textboxNumber.setValue("not set");
		textboxNumber.setVisible(false);
		
		Textbox textboxIssuedBy = new Textbox();
		textboxIssuedBy.setValue("not set");
		textboxIssuedBy.setVisible(false);
		
		Datebox dateboxIssuedDate = new Datebox();
		dateboxIssuedDate.setValue(new Date());
		dateboxIssuedDate.setVisible(false);
		
		Datebox dateboxExpiryDate = new Datebox();
		dateboxExpiryDate.setValue(new Date());
		dateboxExpiryDate.setVisible(false);
		
		Label labelDocument = new Label();
		labelDocument.setValue(value.getDocument());
		
		Label labelNumber = new Label();
		labelNumber.setValue(value.getNumber().toString());
		
		Label labelIssuedBy = new Label();
		labelIssuedBy.setValue("not set");
		
		Label labelIssuedDate = new Label();
		labelIssuedDate.setValue(value.getIssuedDate().toString());
		
		Label labelExpiryDate = new Label();
		labelExpiryDate.setValue(value.getExpiredDate().toString());
		
		
		setEditingComponents(textboxDocument, textboxNumber, textboxIssuedBy, dateboxIssuedDate, dateboxExpiryDate);
		setLabelingComponents(labelDocument, labelNumber, labelIssuedBy, labelIssuedDate, labelExpiryDate);
		
		if (value.getIdImmigration() == null){
			textboxDocument.setVisible(true);
			textboxNumber.setVisible(true);
			textboxIssuedBy.setVisible(true);
			dateboxIssuedDate.setVisible(true);
			dateboxExpiryDate.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		
		textboxDocument.setParent(listcell);
		labelDocument.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxNumber.setParent(listcell);
		labelNumber.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxIssuedBy.setParent(listcell);
		labelIssuedBy.setParent(listcell);
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
