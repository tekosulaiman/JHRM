package org.app.portofolio.webui.hr.employee.model;

import java.util.Date;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.TrsEmployeeExprience;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class EmployeeExperienceListItemRenderer extends InlineListItemRenderer<TrsEmployeeExprience>{
	
	// temp variable
	static final String NOT_SET = "NOT_SET";
	
	@Override
	public void renderListItem(Listitem item, TrsEmployeeExprience value, int index) throws Exception {
		Textbox textboxCompany = new Textbox();
		textboxCompany.setValue(NOT_SET);
		textboxCompany.setVisible(false);
		
		Textbox textboxJobTitle = new Textbox();
		textboxJobTitle.setValue(NOT_SET);
		textboxJobTitle.setVisible(false);
		
		Datebox dateboxFrom = new Datebox();
		dateboxFrom.setValue(new Date());
		dateboxFrom.setVisible(false);
		
		Datebox dateboxTo = new Datebox();
		dateboxTo.setValue(new Date());
		dateboxTo.setVisible(false);
		
		Textbox textboxComment = new Textbox();
		textboxComment.setValue(NOT_SET);
		textboxComment.setVisible(false);
		
		Label labelCompany = new Label();
		labelCompany.setValue(NOT_SET);
		
		Label labelJobTitle =  new Label();
		labelJobTitle.setValue(NOT_SET);
		
		Label labelFrom = new Label();
		labelFrom.setValue(NOT_SET);
		
		Label labelTo = new Label();
		labelTo.setValue(NOT_SET);
		
		Label labelComment = new Label();
		labelComment.setValue(NOT_SET);
		
		setEditingComponents(textboxComment, textboxCompany, textboxJobTitle, dateboxFrom, dateboxTo);
		setLabelingComponents(labelComment, labelCompany, labelJobTitle, labelFrom, labelTo);
		
		if (value.getIdEmployee() == null){
			textboxComment.setVisible(true);
			textboxCompany.setVisible(true);
			textboxJobTitle.setVisible(true);
			dateboxFrom.setVisible(true);
			dateboxTo.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
		
		textboxComment.setParent(listcell);
		labelComment.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxCompany.setParent(listcell);
		labelCompany.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxJobTitle.setParent(listcell);
		labelJobTitle.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		dateboxFrom.setParent(listcell);
		labelFrom.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		dateboxTo.setParent(listcell);
		labelTo.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}
