package org.app.portofolio.webui.hr.master.qualification.memberships;

import java.util.List;

import org.app.portofolio.webui.hr.master.qualification.memberships.model.MembershipListItemRenderer;
import org.module.hr.model.MstMembership;
import org.module.hr.service.MasterQualificationService;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

public class MasterQualificationMemberships {

	/* ------------ Zul -------------- */
	@Wire("#listBoxMembership")
	private Listbox listBoxMembership;

	/* ----------Services -------------*/
	@WireVariable
	private MasterQualificationService masterQualificationService;
	
	/* ------------ Beans -------------*/
	private MembershipListItemRenderer membershipItemRenderer;
	private List<MstMembership> memberships;
	private MstMembership selectedmembership;
	
	public void doPrepareList(){
		listBoxMembership.setCheckmark(true);
		listBoxMembership.setMultiple(true);
		listBoxMembership.setRows(15);
		listBoxMembership.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		memberships = masterQualificationService.getAllMstMembership();
		membershipItemRenderer = new MembershipListItemRenderer();
		
		listBoxMembership.setModel(new ListModelList<MstMembership>());
		listBoxMembership.setItemRenderer(membershipItemRenderer);
		
		doPrepareList();
	}
	
	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxMembership.getModel();
		listModelList.add(0, new MstMembership());
	}
	
	@GlobalCommand
	@NotifyChange("memberships")
	public void refreshAfterSaveOrUpdate(){
		memberships = masterQualificationService.getAllMstMembership();
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstMembership> listModelListMemberships = (ListModelList) listBoxMembership.getModel();
		
		if(listBoxMembership.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstMembership membership : listModelListMemberships){
			 				if(listModelListMemberships.isSelected(membership)){
			 					masterQualificationService.delete(membership);
			 				}
			 			}
			 			
			 			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
			 		}else{
			 			return;
			 		}
			 	}
			});
		}
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
