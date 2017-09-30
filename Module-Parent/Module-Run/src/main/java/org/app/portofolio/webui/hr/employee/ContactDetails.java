package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.webui.hr.employee.model.DummyNationalityItemRender;
import org.module.hr.model.MstNationality;
import org.module.hr.model.TrsEmployee;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class ContactDetails {

	private ListModelList<MstNationality> items;

	private TrsEmployee trsEmployee;
	private String countryKeySearch;

	@Wire("#listBoxCountry")
	private Listbox listBoxCountry;

	@Wire("#bandBoxNationality")
	private Bandbox bandBoxNationality;

	private DummyNationalityItemRender nationalityItemRender;
	private List<MstNationality> nationalities;
	private MstNationality selectedNationality;

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

	@NotifyChange("bandBoxNationality")
	public void setSelectedNationality(MstNationality selectedNationality) {
		this.selectedNationality = selectedNationality;
		bandBoxNationality.setValue(selectedNationality.getNameNationality());
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

}
