package org.app.portofolio.webui.hr.employee.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeLanguage;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class EmployeeLanguageListItemRenderer extends InlineListItemRenderer<TrsEmployeeLanguage> {
	
	// temp variable
	static final String NOT_SET = "NOT_SET";
	
	@Override
	public void renderListItem(Listitem item, TrsEmployeeLanguage value, int index) throws Exception{
		Textbox textboxLanguage = new Textbox();
		textboxLanguage.setValue(value.getIdLanguage().getNameLanguage());
		textboxLanguage.setVisible(false);
		
		Textbox textboxFluency = new Textbox();
		textboxFluency.setValue(NOT_SET);
		textboxFluency.setVisible(false);
		
		Textbox textboxCompetency = new Textbox();
		textboxCompetency.setValue(NOT_SET);
		textboxCompetency.setVisible(false);
		
		Textbox textboxComments = new Textbox();
		textboxComments.setValue(NOT_SET);
		textboxComments.setVisible(false);
		
		Label labelLanguage = new Label();
		labelLanguage.setValue(value.getIdLanguage().getNameLanguage());
		
		Label labelFluency = new Label();
		labelFluency.setValue(NOT_SET);
		
		Label labelCompetency = new Label();
		labelCompetency.setValue(NOT_SET);
		
		Label labelComments = new Label();
		labelComments.setValue(NOT_SET);
		
		setEditingComponents(textboxLanguage, textboxFluency, textboxCompetency, textboxComments);
		setLabelingComponents(labelLanguage, labelFluency, labelCompetency, labelComments);
		
		if (value.getIdEmployeeLanguage() == null){
			textboxLanguage.setVisible(true);
			textboxFluency.setVisible(true);
			textboxCompetency.setVisible(true);
			textboxComments.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		textboxLanguage.setParent(listcell);
		labelLanguage.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxFluency.setParent(listcell);
		labelFluency.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxCompetency.setParent(listcell);
		labelCompetency.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxComments.setParent(listcell);
		labelComments.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
