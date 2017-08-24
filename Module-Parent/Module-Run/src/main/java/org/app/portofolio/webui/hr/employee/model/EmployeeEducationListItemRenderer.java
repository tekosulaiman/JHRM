package org.app.portofolio.webui.hr.employee.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeEducation;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

import net.sf.jasperreports.components.barbecue.BarcodeProviders.NW7Provider;

public class EmployeeEducationListItemRenderer extends InlineListItemRenderer<TrsEmployeeEducation>{
	
	// temp variable
	static final String NOT_SET = "NOT_SET";
	
	@Override
	public void renderListItem(Listitem item, TrsEmployeeEducation value, int index) throws Exception{
		Textbox textboxLevel = new Textbox();
		textboxLevel.setValue(NOT_SET);
		textboxLevel.setVisible(false);
		
		Textbox textboxYear = new Textbox();
		textboxYear.setValue(NOT_SET);
		textboxYear.setVisible(false);
		
		Textbox textboxGPA = new Textbox();
		textboxGPA.setValue(NOT_SET);
		textboxGPA.setVisible(false);
		
		Label labelLevel = new Label();
		labelLevel.setValue(NOT_SET);
		
		Label labelYear = new Label();
		labelYear.setValue(NOT_SET);
		
		Label labelGPA = new Label();
		labelGPA.setValue(NOT_SET);
		
		setEditingComponents(textboxLevel, textboxYear, textboxGPA);
		setLabelingComponents(labelLevel, labelYear, labelGPA);
		
		if (value.getIdEducation() == null){
			textboxLevel.setVisible(true);
			textboxYear.setVisible(true);
			textboxGPA.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		textboxLevel.setParent(listcell);
		labelLevel.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxYear.setParent(listcell);
		labelYear.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxGPA.setParent(listcell);
		labelGPA.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
