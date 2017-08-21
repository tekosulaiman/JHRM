package org.app.portofolio.webui.hr.master.job.jobtitle.model;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.module.hr.model.MstJobtitle;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;

public class MstJobtitleListItemRenderer extends InlineListItemRenderer<MstJobtitle>{
	
	@Override
	public void renderListItem(Listitem item, MstJobtitle value, int index) throws Exception {	
		Textbox textboxJobTitle = new Textbox();
		textboxJobTitle.setValue(value.getJobName());
		textboxJobTitle.setVisible(false);
		
		Textbox textboxJobDescription = new Textbox();
		textboxJobDescription.setValue(value.getJobDescription());
		textboxJobDescription.setVisible(false);
		
		Label labelJobTitle = new Label();
		labelJobTitle.setValue(value.getJobName());
		
		Label labelJobDescription = new Label();
		labelJobDescription.setValue(value.getJobDescription());
		
		setEditingComponents(textboxJobTitle, textboxJobDescription);
		setLabelingComponents(labelJobTitle, labelJobDescription);
		
		if (value.getIdJobTitle() == null) {
			textboxJobTitle.setVisible(true);
			textboxJobDescription.setVisible(true);
			onAdding(true);
		}
		
		super.renderListItem(item, value, index);
		
		Listcell listcell = new Listcell();
			textboxJobTitle.setParent(listcell);
			labelJobTitle.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxJobDescription.setParent(listcell);	
			labelJobDescription.setParent(listcell);
		listcell.setParent(item);
		
		item.setValue(value);
	}
}