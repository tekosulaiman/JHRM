package org.app.portofolio.webui.hr.master.qualification.skills.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstSkill;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class SkillsListItemRenderer extends InlineListItemRenderer<MstSkill>{
	
	
	@Override
	public void renderListItem(Listitem item, MstSkill value, int index) throws Exception {
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getNameSkill());
		textboxName.setVisible(false);
		
		Textbox textboxDescription = new Textbox();
		textboxDescription.setValue(value.getDescpriptionSkill());
		textboxDescription.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getNameSkill());
		
		Label labelDescription = new Label();
		labelDescription.setValue(value.getDescpriptionSkill());
		
		setEditingComponents(textboxName, textboxDescription);
		setLabelingComponents(labelName, labelDescription);
		
		if (value.getIdSkill() == null) {
			textboxName.setVisible(true);
			textboxDescription.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		
		textboxName.setParent(listcell);
		labelName.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxDescription.setParent(listcell);
		
		labelDescription.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
