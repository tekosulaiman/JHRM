package org.app.portofolio.webui.hr.master.job.jobcategory.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstTest;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class MstJobCategoryListItemRenderer extends InlineListItemRenderer<MstJobCategory>{
	
	@Override
	public void renderListItem(Listitem item, MstJobCategory value, int index) throws Exception {	
		Textbox textboxJobCategory = new Textbox();
		textboxJobCategory.setValue(value.getJobCategoryName());
		textboxJobCategory.setVisible(false);
		
		Label labelJobCategory = new Label();
		labelJobCategory.setValue(value.getJobCategoryName());
		
		setEditingComponents(textboxJobCategory);
		setLabelingComponents(labelJobCategory);
		
		if (value.getIdJobCategory() == null) {
			textboxJobCategory.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
			textboxJobCategory.setParent(listcell);
			labelJobCategory.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}