package org.app.portofolio.webui.hr.master.qualification.memberships;

import java.util.ArrayList;
import java.util.List;

import org.app.portofolio.webui.hr.master.qualification.memberships.model.MembershipListItemRenderer;
import org.module.hr.model.MstMembership;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class MasterQualificationMemberships {

	@Wire("#listBoxMembership")
	private Listbox listBoxMembership;

	private MembershipListItemRenderer membershipItemRenderer;
	private List<MstMembership> memberships;
	private MstMembership selectedmembership;
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		// dummy
		memberships = new ArrayList<MstMembership>();
		for(int i = 1; i < 5; i++) {
			MstMembership mstMembership = new MstMembership();
			mstMembership.setIdMembership(i);
			mstMembership.setNameMembership("Membership " + i);
			memberships.add(mstMembership);
		}
		
		
		this.membershipItemRenderer = new MembershipListItemRenderer();
	}
	
	/**
	 * 
	 */
	@Command
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxMembership.getModel();
		listModelList.add(0, new MstMembership());
	}
	
	/**
	 * 
	 */
	@Command
	public void doDetail(){
		//TODO ganti dengan action row editing
	}

	/*
	 * -------------- GETTER - SETTER -----------------
	 */
	
	public MembershipListItemRenderer getMembershipItemRenderer() {
		return membershipItemRenderer;
	}

	public void setMembershipItemRenderer(MembershipListItemRenderer membershipItemRenderer) {
		this.membershipItemRenderer = membershipItemRenderer;
	}

	public List<MstMembership> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<MstMembership> memberships) {
		this.memberships = memberships;
	}

	public MstMembership getSelectedmembership() {
		return selectedmembership;
	}

	public void setSelectedmembership(MstMembership selectedmembership) {
		this.selectedmembership = selectedmembership;
	}
}
