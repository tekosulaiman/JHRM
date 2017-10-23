package org.app.portofolio.webui.hr.employee.model;

import org.module.hr.model.TrsEmployeeImmigration;
import org.module.hr.model.dto.RelationshipType;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.BindUtils;
import org.zkoss.zhtml.Textarea;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class ImmigrationListItemRenderer implements ListitemRenderer<TrsEmployeeImmigration> {

	private EmployeeService employeeService = (EmployeeService) SpringUtil.getBean("employeeService");

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void render(Listitem item, final TrsEmployeeImmigration trsEmployeeImmigration, int index) throws Exception {
		Listcell listcell;

		final Button buttonSave = new Button();
		buttonSave.setImage("/images/icons/btn_save.gif");

		final Button buttonEdit = new Button();
		buttonEdit.setImage("/images/icons/btn_edit.gif");

		final Button buttonDelete = new Button();
		buttonDelete.setImage("/images/icons/btn_delete.gif");

		final Button buttonCancel = new Button();
		buttonCancel.setImage("/images/icons/btn_cancel.gif");

		final Label labelDocument = new Label();
		final Label labelNumber = new Label();
		final Label labelIssuedDate = new Label();
		final Label labelExpiredDate = new Label();
		final Label labelEligibleStatus = new Label();
		final Label labelCountry = new Label();
		final Label labelEligibleReviewDate = new Label();
		final Label labelComment = new Label();

		final Combobox comboboxDocument = new Combobox();
		final Textbox textboxNumber = new Textbox();
		final Datebox dateboxIssuedDate = new Datebox();
		final Datebox dateboxExpiredDate = new Datebox();
		final Textbox textboxEligibleStatus = new Textbox();
		final Combobox comboboxCountry = new Combobox();
		final Datebox dateboxEligibleReviewDate = new Datebox();
		final Textbox textboxComment = new Textbox();

		listcell = new Listcell();
		buttonEdit.setParent(listcell);
		buttonSave.setParent(listcell);
		buttonCancel.setParent(listcell);
		buttonDelete.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		comboboxDocument.setParent(listcell);
		comboboxDocument.setReadonly(true);
		labelDocument.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		textboxNumber.setParent(listcell);
		labelNumber.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		comboboxCountry.setParent(listcell);
		comboboxCountry.setReadonly(true);
		labelCountry.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		dateboxExpiredDate.setParent(listcell);
		labelExpiredDate.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		dateboxIssuedDate.setParent(listcell);
		labelIssuedDate.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		textboxEligibleStatus.setParent(listcell);
		labelEligibleStatus.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		dateboxEligibleReviewDate.setParent(listcell);
		labelEligibleReviewDate.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
		textboxComment.setParent(listcell);
		textboxComment.setMultiline(true);
		textboxComment.setHeight("75px");
		labelComment.setParent(listcell);
		listcell.setParent(item);

		if (trsEmployeeImmigration.getIdImmigration() == null) {
			buttonEdit.setVisible(false);
			buttonDelete.setVisible(false);

			comboboxDocument.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
			comboboxDocument.setItemRenderer(new RelationshipListItemRenderer());

			comboboxCountry.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
			comboboxCountry.setItemRenderer(new RelationshipListItemRenderer());

		} else {
			buttonSave.setVisible(false);
			buttonCancel.setVisible(false);
			buttonDelete.setVisible(false);

			RelationshipType dummyDocument = employeeService
					.getRelationshipTypeById(Integer.parseInt(trsEmployeeImmigration.getDocument()));
			RelationshipType dummycountry = employeeService
					.getRelationshipTypeById(Integer.parseInt(trsEmployeeImmigration.getIdCountry()));

			labelDocument.setValue(dummyDocument.getStpTypname());
			labelNumber.setValue(trsEmployeeImmigration.getNumber().toString());
			labelIssuedDate.setValue(trsEmployeeImmigration.getIssuedDate().toString());
			labelExpiredDate.setValue(trsEmployeeImmigration.getExpiredDate().toString());
			labelEligibleStatus.setValue(trsEmployeeImmigration.getEligibleStatus());
			labelCountry.setValue(dummycountry.getStpTypname());
			labelEligibleReviewDate.setValue(trsEmployeeImmigration.getEligibleReview().toString());
			labelComment.setValue(trsEmployeeImmigration.getComment());

			comboboxDocument.setVisible(false);
			textboxNumber.setVisible(false);
			dateboxIssuedDate.setVisible(false);
			dateboxExpiredDate.setVisible(false);
			textboxEligibleStatus.setVisible(false);
			comboboxCountry.setVisible(false);
			dateboxEligibleReviewDate.setVisible(false);
			textboxComment.setVisible(false);
		}

		/*
		 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++++++++++++++ Function CRUD Event
		 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++++++++++++++
		 */
		buttonSave.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				if (trsEmployeeImmigration.getIdImmigration() == null) {
					trsEmployeeImmigration.setDocument(String.valueOf(comboboxDocument.getSelectedIndex()));
					trsEmployeeImmigration.setNumber(textboxNumber.getValue());
					trsEmployeeImmigration.setIssuedDate(dateboxIssuedDate.getValue());
					trsEmployeeImmigration.setExpiredDate(dateboxExpiredDate.getValue());
					trsEmployeeImmigration.setEligibleStatus(textboxEligibleStatus.getValue());
					trsEmployeeImmigration.setIdCountry(String.valueOf(comboboxCountry.getSelectedIndex()));
					trsEmployeeImmigration.setEligibleReview(dateboxEligibleReviewDate.getValue());
					trsEmployeeImmigration.setComment(textboxComment.getValue());

					employeeService.save(trsEmployeeImmigration);

					BindUtils.postGlobalCommand(null, null, "trsEmployeeDependents", null);
				} else {
					trsEmployeeImmigration.setDocument(String.valueOf(comboboxDocument.getSelectedIndex()));
					trsEmployeeImmigration.setNumber(textboxNumber.getValue());
					trsEmployeeImmigration.setIssuedDate(dateboxIssuedDate.getValue());
					trsEmployeeImmigration.setExpiredDate(dateboxExpiredDate.getValue());
					trsEmployeeImmigration.setEligibleStatus(textboxEligibleStatus.getValue());
					trsEmployeeImmigration.setIdCountry(String.valueOf(comboboxCountry.getSelectedIndex()));
					trsEmployeeImmigration.setEligibleReview(dateboxEligibleReviewDate.getValue());
					trsEmployeeImmigration.setComment(textboxComment.getValue());

					employeeService.update(trsEmployeeImmigration);

					BindUtils.postGlobalCommand(null, null, "trsEmployeeDependents", null);
				}
			}
		});

		buttonEdit.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event event) throws Exception {
				buttonEdit.setVisible(false);
				buttonSave.setVisible(true);
				buttonDelete.setVisible(true);

				comboboxDocument.setVisible(true);
				textboxNumber.setVisible(true);
				dateboxIssuedDate.setVisible(true);
				dateboxExpiredDate.setVisible(true);
				textboxEligibleStatus.setVisible(true);
				comboboxCountry.setVisible(true);
				dateboxEligibleReviewDate.setVisible(true);
				textboxComment.setVisible(true);

				labelDocument.setVisible(false);
				labelNumber.setVisible(false);
				labelIssuedDate.setVisible(false);
				labelExpiredDate.setVisible(false);
				labelEligibleStatus.setVisible(false);
				labelCountry.setVisible(false);
				labelEligibleReviewDate.setVisible(false);
				labelComment.setVisible(false);

				RelationshipType dummyDocument = employeeService
						.getRelationshipTypeById(Integer.parseInt(trsEmployeeImmigration.getDocument()));
				RelationshipType dummycountry = employeeService
						.getRelationshipTypeById(Integer.parseInt(trsEmployeeImmigration.getIdCountry()));

				comboboxDocument
						.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
				comboboxDocument.setItemRenderer(new RelationshipListItemRenderer());

				comboboxCountry.setModel(new ListModelList<RelationshipType>(employeeService.getAllRelationshipType()));
				comboboxCountry.setItemRenderer(new RelationshipListItemRenderer());

				comboboxDocument.setValue(dummyDocument.getStpTypname());
				textboxNumber.setValue(trsEmployeeImmigration.getNumber());
				dateboxIssuedDate.setValue(trsEmployeeImmigration.getIssuedDate());
				dateboxExpiredDate.setValue(trsEmployeeImmigration.getExpiredDate());
				textboxEligibleStatus.setValue(trsEmployeeImmigration.getEligibleStatus());
				comboboxCountry.setValue(dummycountry.getStpTypname());
				dateboxEligibleReviewDate.setValue(trsEmployeeImmigration.getEligibleReview());
				textboxComment.setValue(trsEmployeeImmigration.getComment());

			}
		});

		buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL,
						Messagebox.EXCLAMATION, new EventListener() {
							public void onEvent(Event event) throws Exception {
								if (((Integer) event.getData()).intValue() == Messagebox.OK) {

									employeeService.delete(trsEmployeeImmigration);

									BindUtils.postGlobalCommand(null, null, "b", null);
								} else {
									return;
								}
							}
						});
			}
		});

		buttonCancel.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				BindUtils.postGlobalCommand(null, null, "b", null);
			}
		});
	}
}
