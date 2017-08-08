package org.app.portofolio.webui.hr.master.qualification.licenses.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstLicense;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class LicenseListItemRenderer extends InlineListItemRenderer<MstLicense>{

	@Override
	public void renderListItem(Listitem item, MstLicense value, int index) throws Exception {
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getNameLicense());
		textboxName.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getNameLicense());
		
		super.setEditingComponents(textboxName);
		super.setLabelingComponents(labelName);
		
		if (value.getIdLicense() == null) {
			textboxName.setVisible(true);
			super.onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		
		textboxName.setParent(listcell);
		labelName.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
