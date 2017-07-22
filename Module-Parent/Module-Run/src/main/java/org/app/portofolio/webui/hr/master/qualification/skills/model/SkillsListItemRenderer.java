package org.app.portofolio.webui.hr.master.qualification.skills.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.OhrmSkill;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class SkillsListItemRenderer extends InlineListItemRenderer<OhrmSkill>{
	
	
	@Override
	public void renderListItem(Listitem item, OhrmSkill value, int index) throws Exception {
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getName());
		textboxName.setVisible(false);
		
		Textbox textboxDescription = new Textbox();
		textboxDescription.setValue(value.getDescription());
		textboxDescription.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getName());
		
		Label labelDescription = new Label();
		labelDescription.setValue(value.getDescription());
		
		setEditingComponents(textboxName, textboxDescription);
		setLabelingComponents(labelName, labelDescription);
		
		if (value.getId() == null) {
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
