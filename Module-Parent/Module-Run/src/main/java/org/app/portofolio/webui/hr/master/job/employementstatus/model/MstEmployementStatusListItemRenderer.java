package org.app.portofolio.webui.hr.master.job.employementstatus.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.model.MstTest;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class MstEmployementStatusListItemRenderer extends InlineListItemRenderer<MstEmployementStatus>{
	
	@Override
	public void renderListItem(Listitem item, MstEmployementStatus value, int index) throws Exception {	
		Textbox textboxEmployementStatus = new Textbox();
		textboxEmployementStatus.setValue(value.getEmployementStatusName());
		textboxEmployementStatus.setVisible(false);
		
		Label labelEmployementStatus = new Label();
		labelEmployementStatus.setValue(value.getEmployementStatusName());
		
		setEditingComponents(textboxEmployementStatus);
		setLabelingComponents(labelEmployementStatus);
		
		if (value.getIdEmployementStatus() == null) {
			textboxEmployementStatus.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
			textboxEmployementStatus.setParent(listcell);
			labelEmployementStatus.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}