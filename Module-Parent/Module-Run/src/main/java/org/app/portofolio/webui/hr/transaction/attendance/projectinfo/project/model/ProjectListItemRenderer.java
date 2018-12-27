package org.app.portofolio.webui.hr.transaction.attendance.projectinfo.project.model;

import org.module.hr.model.MstProject;
import org.module.hr.service.AttendanceService;
import org.zkoss.bind.BindUtils;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ProjectListItemRenderer implements ListitemRenderer<MstProject>{
	
	private AttendanceService attendanceService = (AttendanceService) SpringUtil.getBean("attendanceService");		
	
	@Override
	public void render(Listitem item, final MstProject mstProject, int index) throws Exception {
		Listcell listcell;
		
		final Button buttonSave = new Button();
    		buttonSave.setImage("/images/icons/btn_save.gif");
		
		final Button buttonEdit = new Button();
			buttonEdit.setImage("/images/icons/btn_edit.gif");
			
		final Button buttonDelete = new Button();
        	buttonDelete.setImage("/images/icons/btn_delete.gif");
        
        final Button buttonCancel = new Button();
        	buttonCancel.setImage("/images/icons/btn_cancel.gif");
        	
        final Label labelProjectName = new Label();
        final Label labelCustomerName = new Label();
        final Label labelPIC = new Label();
        final Label labelDescription = new Label();
        
        final Textbox textboxProjectName = new Textbox();
        final Textbox textboxCustomerName = new Textbox();
        final Textbox textboxPIC = new Textbox();
        final Textbox textboxDescription = new Textbox();
        	
        listcell = new Listcell();
        	buttonEdit.setParent(listcell); 
        	buttonSave.setParent(listcell); 
        	buttonCancel.setParent(listcell); 
        	buttonDelete.setParent(listcell); 
		listcell.setParent(item);
        
		listcell = new Listcell();
			textboxProjectName.setParent(listcell); 
			labelProjectName.setParent(listcell); 
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxCustomerName.setParent(listcell); 
			labelCustomerName.setParent(listcell);
		listcell.setParent(item);
		
		listcell = new Listcell();
			textboxPIC.setParent(listcell); 
			labelPIC.setParent(listcell);
		listcell.setParent(item);

		listcell = new Listcell();
			textboxDescription.setParent(listcell); 
			labelDescription.setParent(listcell);
		listcell.setParent(item);
		
		if(mstProject.getIdProject() == null){
			buttonEdit.setVisible(false);
			buttonDelete.setVisible(false);
		}else{
        	buttonSave.setVisible(false);
        	buttonCancel.setVisible(false);
        	buttonDelete.setVisible(false);
        	
        	labelCustomerName.setValue(mstProject.getIdCustomer().getCustomerName());
        	labelProjectName.setValue(mstProject.getProjectName());
        	labelPIC.setValue(null);
        	labelDescription.setValue(mstProject.getProjectDescription());
        	
        	textboxProjectName.setVisible(false);
        	textboxCustomerName.setVisible(false);
        	textboxPIC.setVisible(false);
        	textboxDescription.setVisible(false);
		}
		
		buttonSave.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				if(mstProject.getIdProject() == null){
					//MstCustomer mstCustomer = new MstCustomer();
				
					mstProject.setProjectName(textboxProjectName.getValue());
					mstProject.setProjectDescription(textboxDescription.getValue());

					attendanceService.save(mstProject);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				}else{
					//MstCustomer mstCustomer = new MstCustomer();
					
					mstProject.setProjectName(textboxDescription.getValue());
					mstProject.setProjectDescription(textboxDescription.getValue());
					
					attendanceService.update(mstProject);
					
					BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				}
			}
		});
		
		buttonEdit.addEventListener(Events.ON_CLICK, new EventListener() {
			public void onEvent(Event event) throws Exception {		
				buttonEdit.setVisible(false);
				buttonSave.setVisible(true);
				buttonDelete.setVisible(true);
				
				textboxProjectName.setVisible(true);
				textboxCustomerName.setVisible(true);
				textboxDescription.setVisible(true);
				textboxPIC.setVisible(true);
				
				labelProjectName.setVisible(false);
		        labelCustomerName.setVisible(false); 
		        labelPIC.setVisible(false); 
		        labelDescription.setVisible(false); 
				
				textboxProjectName.setValue(mstProject.getProjectName());
				textboxCustomerName.setValue(mstProject.getIdCustomer().getCustomerName());
				textboxDescription.setValue(mstProject.getProjectDescription());
			}					
		});
		
		buttonDelete.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				Messagebox.show("Do you really want to remove item?", "Confirm", Messagebox.OK | Messagebox.CANCEL, Messagebox.EXCLAMATION, new EventListener() {
				    public void onEvent(Event event) throws Exception {    	
				 		if (((Integer) event.getData()).intValue() == Messagebox.OK) {

				 			attendanceService.delete(mstProject);
				 			
				 			BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
				 		}else{
				 			return;
				 		}
				 	}
				});
			}
		});
		
		buttonCancel.addEventListener(Events.ON_CLICK, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				BindUtils.postGlobalCommand(null, null, "refreshAfterSaveOrUpdate", null);
			}
		});
	}
}