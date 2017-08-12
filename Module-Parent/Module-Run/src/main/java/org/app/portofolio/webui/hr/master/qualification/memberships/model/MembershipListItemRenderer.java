package org.app.portofolio.webui.hr.master.qualification.memberships.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstMembership;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class MembershipListItemRenderer extends InlineListItemRenderer<MstMembership>{
	
	
	@Override
	public void renderListItem(Listitem item, MstMembership value, int index) throws Exception {
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getNameMembership());
		textboxName.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getNameMembership());
		
		setEditingComponents(textboxName, textboxName);
		setLabelingComponents(labelName, labelName);
		
		if (value.getIdMembership() == null) {
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
