package org.app.portofolio.webui.hr.employee.model;

import java.util.Date;

import org.app.portofolio.webui.hr.common.components.InlineListItemRenderer;
import org.app.portofolio.webui.hr.master.qualification.licenses.model.LicenseListItemRenderer;
import org.module.hr.model.TrsEmployeeImmigration;
import org.module.hr.service.EmployeeService;
import org.zkoss.zhtml.Textarea;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

public class ImmigrationListItemRenderer implements ListitemRenderer<TrsEmployeeImmigration>{
	
	private EmployeeService employeeService = (EmployeeService) SpringUtil
			.getBean("employeeService");

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void render(Listitem item, TrsEmployeeImmigration value, int index) throws Exception{
		Listcell listcell;

		final Button buttonSave = new Button();
		buttonSave.setImage("/images/icons/btn_save.gif");

		final Button buttonEdit = new Button();
		buttonEdit.setImage("/images/icons/btn_edit.gif");

		final Button buttonDelete = new Button();
		buttonDelete.setImage("/images/icons/btn_delete.gif");

		final Button buttonCancel = new Button();
		buttonCancel.setImage("/images/icons/btn_cancel.gif");
		
		final Label document = new Label();
		final Label number = new Label();
		final Label issuedDate = new Label();
		final Label expiredDate = new Label();
		final Label eligibleStatus = new Label();
		final Label country = new Label();
		final Label eligibleReviewDate = new Label();
		final Label comments = new Label();
		
		final Radiogroup radiogroupDocument = new Radiogroup();
		final Textbox textboxNumber = new Textbox();
		final Datebox dateboxIssuedDate = new Datebox();
		final Datebox dateboxExpiredDate = new Datebox();
		final Textbox textboxEligibleStatus = new Textbox();
		final Combobox comboboxCountry = new Combobox();
		final Datebox dateboxEligibleReviewDate = new Datebox();
		final Textarea textareaComments = new Textarea();
		
		listcell = new Listcell();
		buttonEdit.setParent(listcell);
		buttonSave.setParent(listcell);
		buttonCancel.setParent(listcell);
		buttonDelete.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
		textboxName.setParent(listcell);
		labelName.setParent(listcell);
		listcell.setParent(item);
	}

}
