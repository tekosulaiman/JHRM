package org.app.portofolio.webui.hr.master.qualification.language.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstLanguage;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class LanguageListItemRenderer extends InlineListItemRenderer<MstLanguage>{
	
	
	@Override
	public void renderListItem(Listitem item, MstLanguage value, int index) throws Exception {
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getNameLanguage());
		textboxName.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getNameLanguage());
		
		setEditingComponents(textboxName, textboxName);
		setLabelingComponents(labelName, labelName);
		
		if (value.getIdLanguage() == null) {
			textboxName.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		
		textboxName.setParent(listcell);
		labelName.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
