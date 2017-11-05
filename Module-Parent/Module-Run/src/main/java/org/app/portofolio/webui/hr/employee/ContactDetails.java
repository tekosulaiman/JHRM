package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.employee.model.DummyNationalityItemRender;
import org.app.portofolio.webui.hr.employee.validator.TrsEmployeeContactDetailsValidator;
import org.module.hr.model.MstNationality;
import org.module.hr.model.TrsEmployee;
import org.module.hr.service.EmployeeService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

public class ContactDetails {

	@Wire("#listBoxCountry")
	private Listbox listBoxCountry;

	@Wire("#bandBoxNationality")
	private Bandbox bandBoxNationality;
	
	@Wire("#textBoxAddressStreet1")
	private Textbox textBoxAddressStreet1;
	
	@Wire("#textBoxAddressStreet2")
	private Textbox textBoxAddressStreet2;
	
	@Wire("#textBoxCity")
	private Textbox textBoxCity;
	
	@Wire("#textBoxProvince")
	private Textbox textBoxProvince;
	
	@Wire("#textBoxZip")
	private Textbox textBoxZip;
	
	@Wire("#textBoxHomeTelephone")
	private Textbox textBoxHomeTelephone;
	
	@Wire("#textBoxMobile")
	private Textbox textBoxMobile;
	
	@Wire("#textBoxWorkTelephone")
	private Textbox textBoxWorkTelephone;
	
	@Wire("#textBoxWorkEmail")
	private Textbox textBoxWorkEmail;
	
	@Wire("#textBoxOtherEmail")
	private Textbox textBoxOtherEmail;
	
	@Wire("#buttonEdit")
	private Button buttonEdit;
	
	@Wire("#buttonSave")
	private Button buttonSave;
	
	@WireVariable
	private EmployeeService employeeService;

	private ListModelList<MstNationality> items;

	private TrsEmployee trsEmployee;
	private String countryKeySearch;

	
	/*---------- Bean ----------*/
	private TrsEmployeeContactDetailsValidator formValidator = new TrsEmployeeContactDetailsValidator();
	private DummyNationalityItemRender nationalityItemRender;
	private List<MstNationality> nationalities;
	private MstNationality selectedNationality;
	
	private Boolean isEdit;

	/*
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++ Inisialize Methode MVVM yang pertama kali dijalankan
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * ++++++
	 */
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("type") TrsEmployee trsEmployee) {
		Selectors.wireComponents(component, this, false);
		this.trsEmployee = trsEmployee;
		formDetailCondition();
	}

	@NotifyChange("items")
	@Command
	public void search() {
		for (MstNationality mstNationality : items) {
			if (mstNationality.getNameNationality().contains(countryKeySearch)) {
				items.clear();
				items.add(mstNationality);
				break;
			}
		}
	}
	
	@Command
	@NotifyChange("isEdit")
	public void doEdit(){
		isEdit = Boolean.TRUE;
	}
	
	@Command
	@NotifyChange("isEdit")
	public void doSave(){
		employeeService.update(trsEmployee);
		isEdit = Boolean.FALSE;
	}

	@Command
	public void openBandBoxNationality() {
		// dummy data Nasionality
		nationalities = new ArrayList<MstNationality>();
		MstNationality nationality;
		for (int i = 1; i < 5; i++) {
			nationality = new MstNationality();
			nationality.setIdNationality(i);
			nationality.setNameNationality("Nationality " + i);
			nationalities.add(nationality);
		}
		items = new ListModelList<MstNationality>();
		items.addAll(nationalities);
		listBoxCountry.setModel(items);
		listBoxCountry.setItemRenderer(new DummyNationalityItemRender());
	}
	
	/**
	 * 
	 */
	private void formEditCondition() {
		ComponentConditionUtil.visibleButton(buttonSave);
		ComponentConditionUtil.invisibleButton(buttonEdit);
		ComponentConditionUtil.enableBandBox(bandBoxNationality);
		ComponentConditionUtil.enableTextbox(textBoxAddressStreet1, textBoxAddressStreet2, textBoxCity, textBoxHomeTelephone, textBoxMobile, textBoxOtherEmail, textBoxProvince, textBoxWorkEmail, textBoxWorkTelephone, textBoxZip);
	}
	
	/**
	 * 
	 */
	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSave);
		ComponentConditionUtil.visibleButton(buttonEdit);
		ComponentConditionUtil.disableTextbox(textBoxAddressStreet1, textBoxAddressStreet2, textBoxCity, textBoxHomeTelephone, textBoxMobile, textBoxOtherEmail, textBoxProvince, textBoxWorkEmail, textBoxWorkTelephone, textBoxZip);
		ComponentConditionUtil.disableBandBox(bandBoxNationality);
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

	public String getCountryKeySearch() {
		return countryKeySearch;
	}

	public void setCountryKeySearch(String countryKeySearch) {
		this.countryKeySearch = countryKeySearch;
	}

	public Listbox getListBoxCountry() {
		return listBoxCountry;
	}

	public void setListBoxCountry(Listbox listBoxCountry) {
		this.listBoxCountry = listBoxCountry;
	}

	public DummyNationalityItemRender getNationalityItemRender() {
		return nationalityItemRender;
	}

	public void setNationalityItemRender(DummyNationalityItemRender nationalityItemRender) {
		this.nationalityItemRender = nationalityItemRender;
	}

	public List<MstNationality> getNationalities() {
		return nationalities;
	}

	public void setNationalities(List<MstNationality> nationalities) {
		this.nationalities = nationalities;
	}

	public MstNationality getSelectedNationality() {
		return selectedNationality;
	}

	
	public void setSelectedNationality(MstNationality selectedNationality) {
		this.selectedNationality = selectedNationality;
		trsEmployee.setCountry(selectedNationality.getNameNationality());
		bandBoxNationality.setValue(trsEmployee.getCountry());
		bandBoxNationality.close();
	}

	public ListModelList<MstNationality> getItems() {
		return items;
	}

	public void setItems(ListModelList<MstNationality> items) {
		this.items = items;
	}

	public Bandbox getBandBoxNationality() {
		return bandBoxNationality;
	}

	public void setBandBoxNationality(Bandbox bandBoxNationality) {
		this.bandBoxNationality = bandBoxNationality;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public TrsEmployeeContactDetailsValidator getFormValidator() {
		return formValidator;
	}

	public void setFormValidator(TrsEmployeeContactDetailsValidator formValidator) {
		this.formValidator = formValidator;
	}
	
}
