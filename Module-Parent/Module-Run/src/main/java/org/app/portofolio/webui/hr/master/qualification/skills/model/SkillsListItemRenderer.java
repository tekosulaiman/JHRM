package org.app.portofolio.webui.hr.master.qualification.skills.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstSkill;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class SkillsListItemRenderer extends InlineListItemRenderer<MstSkill>{

	private MstSkill value = new MstSkill();
	private Textbox textboxName;
	private Textbox textboxDescription;
	
	@Override
	public void renderListItem(Listitem item, MstSkill value, int index) throws Exception {
		this.value = value;
		textboxName = new Textbox();
		textboxName.setValue(value.getNameSkill());
		textboxName.setVisible(false);
		
		textboxDescription = new Textbox();
		textboxDescription.setValue(value.getDescriptionSkill());
		textboxDescription.setVisible(false);
		
		Label labelName = new Label();
		labelName.setValue(value.getNameSkill());
		
		Label labelDescription = new Label();
		labelDescription.setValue(value.getDescriptionSkill());
		
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
		
		item.setValue(this.value);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public MstSkill getTransactionValue() {
		System.out.println(textboxName.getValue());
		value.setNameSkill(textboxName.getValue());
		value.setDescriptionSkill(textboxDescription.getValue());
		return value;
	}
	
	/**
	 * 
	 * @param mstSkill
	 */
	public void setTransactionValue(MstSkill mstSkill) {
		this.value = mstSkill;
		textboxName = new Textbox();
		textboxDescription = new Textbox();
		
		textboxName.setValue(value.getNameSkill());
		textboxDescription.setValue(value.getDescriptionSkill());
	}
}
