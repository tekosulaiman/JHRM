package org.app.portofolio.webui.hr.test.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstTest;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class TestListItemRenderer extends InlineListItemRenderer<MstTest>{
	
	
	@Override
	public void renderListItem(Listitem item, MstTest value, int index) throws Exception {	
		Textbox textboxID = new Textbox();
		textboxID.setValue(value.getId().toString());
		textboxID.setVisible(false);
		
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getName());
		textboxName.setVisible(false);
		
		Datebox dateboxDOB = new Datebox();
		
		Combobox comboboxSex = new Combobox();
		
		Textbox textboxAddress = new Textbox();
		
		Label labelID = new Label();
		labelID.setValue(value.getId().toString());
		
		Label labelName = new Label();
		labelName.setValue(value.getName());
		
		setEditingComponents(textboxID, textboxName);
		setLabelingComponents(labelID, labelName);
		
		if (value.getId() == null) {
			textboxID.setVisible(true);
			textboxName.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
			textboxName.setParent(listcell);
			labelName.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxName.setParent(listcell);	
			labelName.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
