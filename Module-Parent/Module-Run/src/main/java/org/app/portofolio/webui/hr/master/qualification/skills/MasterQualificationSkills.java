package org.app.portofolio.webui.hr.master.qualification.skills;

import java.util.List;

import org.app.portofolio.webui.hr.master.qualification.skills.model.SkillsListItemRenderer;
import org.module.hr.model.MstSkill;
import org.module.hr.service.MasterQualificationService;
import org.module.sysadmin.model.SecRight;
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

public class MasterQualificationSkills {

	/* ------------ Zul -------------- */
	@Wire("#listBoxSkills")
	private Listbox listBoxSkills;
	
	/* ----------Services -------------*/
	@WireVariable
	private MasterQualificationService masterQualificationService;
	
	/* ------------ Beans -------------*/
	private SkillsListItemRenderer skillItemRenderer;
	private List<MstSkill> skills;
	private MstSkill selectedSkills;
	
	public void doPrepareList(){
		listBoxSkills.setCheckmark(true);
		listBoxSkills.setMultiple(true);
		listBoxSkills.setRows(15);
		listBoxSkills.setStyle("border-style: none;");
	}
	
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component, @ExecutionArgParam("object") Object object) {
		Selectors.wireComponents(component, this, false);
		
		skills = masterQualificationService.getAllMstSkill();
		skillItemRenderer = new SkillsListItemRenderer();
		
		listBoxSkills.setModel(new ListModelList<MstSkill>());
		listBoxSkills.setItemRenderer(skillItemRenderer);
		
		doPrepareList();
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doNew(){
		ListModelList listModelList = (ListModelList) listBoxSkills.getModel();
		listModelList.add(0,  new MstSkill());
	}

	@Command
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void doDelete(){
		final ListModelList<MstSkill> listModelListSkills = (ListModelList) listBoxSkills.getModel();
		
		if(listBoxSkills.getSelectedIndex() == -1){
			Messagebox.show("There is no selected record?", "Confirm", Messagebox.OK, Messagebox.ERROR);
		}else{
			Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
			    public void onEvent(Event event) throws Exception {    	
			 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {
			 			for(MstSkill skill : listModelListSkills){
			 				if(listModelListSkills.isSelected(skill)){
			 					masterQualificationService.delete(skill);
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
	
	@GlobalCommand
	@NotifyChange("skills")
	public void refreshAfterSaveOrUpdate(){
		skills = masterQualificationService.getAllMstSkill();
	}

	
	/*
	 * -------------- GETTER - SETTER -----------------
	 */
	
	public SkillsListItemRenderer getSkillItemRenderer() {
		return skillItemRenderer;
	}

	public void setSkillItemRenderer(SkillsListItemRenderer skillItemRenderer) {
		this.skillItemRenderer = skillItemRenderer;
	}

	public List<MstSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<MstSkill> skills) {
		this.skills = skills;
	}

	public MstSkill getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(MstSkill selectedSkills) {
		this.selectedSkills = selectedSkills;
	}

}
