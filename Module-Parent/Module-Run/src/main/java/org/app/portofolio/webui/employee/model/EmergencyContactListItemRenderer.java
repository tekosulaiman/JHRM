package org.app.portofolio.webui.employee.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class EmergencyContactListItemRenderer extends InlineListItemRenderer<TrsEmployeeEmergencyContact>{

	@Override
	public void renderListItem(Listitem item, TrsEmployeeEmergencyContact value, int index) throws Exception{
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getName());
		textboxName.setVisible(false);
		
		Textbox textboxRelationship = new Textbox();
		textboxRelationship.setValue(value.getRelationship());
		textboxRelationship.setVisible(false);
		
		Textbox textboxHomeTelephone = new Textbox();
		textboxHomeTelephone.setValue(value.getHomeTelephone());
		textboxHomeTelephone.setVisible(false);
		
		Textbox textboxWorkTelephone = new Textbox();
		textboxWorkTelephone.setValue(value.getWorkTelephone());
		textboxWorkTelephone.setVisible(false);
		
		Textbox textboxMobile = new Textbox();
		textboxMobile.setValue(value.getMobile());
		textboxMobile.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getName());
		
		Label labelRelationship = new Label();
		labelRelationship.setValue(value.getRelationship());
		
		Label labelHomeTelephone = new Label();
		labelHomeTelephone.setValue(value.getHomeTelephone());
		
		Label labelMobile = new Label();
		labelMobile.setValue(value.getMobile());
		
		Label labelWorkTelephone = new Label();
		labelWorkTelephone.setValue(value.getWorkTelephone());
		
		setEditingComponents(textboxName, textboxRelationship, textboxMobile, textboxHomeTelephone, textboxWorkTelephone);
		setLabelingComponents(labelName, labelWorkTelephone, labelRelationship, labelHomeTelephone, labelMobile);
		
		if (value.getIdEmployeeEmergencyContact() == null){
			textboxName.setVisible(true);
			textboxRelationship.setVisible(true);
			textboxMobile.setVisible(true);
			textboxHomeTelephone.setVisible(true);
			textboxWorkTelephone.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		
		textboxName.setParent(listcell);
		labelName.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxRelationship.setParent(listcell);
		labelRelationship.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxHomeTelephone.setParent(listcell);
		labelHomeTelephone.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxMobile.setParent(listcell);
		labelMobile.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxWorkTelephone.setParent(listcell);
		labelWorkTelephone.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
		
	}
}
