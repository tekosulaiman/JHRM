package org.app.portofolio.webui.hr.master.qualification.education.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstEducation;
import org.module.hr.model.MstSkill;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class EducationListItemRenderer extends InlineListItemRenderer<MstEducation>{
	
	
	@Override
	public void renderListItem(Listitem item, MstEducation value, int index) throws Exception {
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getEducationName());
		textboxName.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getEducationName());
		
		setEditingComponents(textboxName, textboxName);
		setLabelingComponents(labelName, labelName);
		
		if (value.getIdEducation() == null) {
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
