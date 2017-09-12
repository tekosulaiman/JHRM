package org.app.portofolio.webui.hr.employee.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeSkill;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class EmployeeSkillListItemRenderer extends InlineListItemRenderer<TrsEmployeeSkill>{

	// temp variable
		static final String NOT_SET = "NOT_SET";
		
	@Override
	public void renderListItem(Listitem item, TrsEmployeeSkill value, int index) throws Exception{
		Textbox textboxskill = new Textbox();
		textboxskill.setValue(value.getIdSkill().getNameSkill());
		textboxskill.setVisible(false);
		
		Textbox textboxYearOfExperience = new Textbox();
		textboxYearOfExperience.setValue(NOT_SET);
		textboxYearOfExperience.setVisible(false);
		
		Label labelSkill = new Label();
		labelSkill.setValue(value.getIdSkill().getNameSkill());;
		
		Label labelYearOfExperience = new Label();
		labelYearOfExperience.setValue(NOT_SET);;
		
		setEditingComponents(textboxskill, textboxYearOfExperience);
		setLabelingComponents(labelSkill, labelYearOfExperience);
		
		if (value.getIdEmployeeSkill() == null){
			textboxskill.setVisible(true);
			textboxYearOfExperience.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		
		textboxskill.setParent(listcell);
		labelSkill.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxYearOfExperience.setParent(listcell);
		labelYearOfExperience.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
