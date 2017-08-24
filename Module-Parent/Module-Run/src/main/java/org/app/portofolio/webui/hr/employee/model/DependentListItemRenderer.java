package org.app.portofolio.webui.hr.employee.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeDependent;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class DependentListItemRenderer extends InlineListItemRenderer<TrsEmployeeDependent>{
	
	@Override
	public void renderListItem(Listitem item, TrsEmployeeDependent value, int index) throws Exception{
		Textbox textboxName = new Textbox();
		textboxName.setValue(value.getName());
		textboxName.setVisible(false);
		
		Textbox textboxRelationship = new Textbox();
		textboxRelationship.setValue(value.getName());
		textboxRelationship.setVisible(false);
		
		Datebox dateboxDateOfBirth = new Datebox();
		dateboxDateOfBirth.setValue(value.getDateOfBirth());
		dateboxDateOfBirth.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getName());
		
		Label labelRelationship = new Label();
		labelRelationship.setValue(value.getRelationship());
		
		Label labelDateOfBirth = new Label();
		labelDateOfBirth.setValue(value.getDateOfBirth().toString());
		
		setEditingComponents(textboxName, textboxRelationship, dateboxDateOfBirth);
		setLabelingComponents(labelName, labelRelationship, labelDateOfBirth);
		
		if (value.getIdDependent() == null){
			textboxName.setVisible(true);
			textboxRelationship.setVisible(true);
			dateboxDateOfBirth.setVisible(true);
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
		dateboxDateOfBirth.setParent(listcell);
		labelDateOfBirth.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}

}
