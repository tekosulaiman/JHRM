package org.app.portofolio.webui.hr.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.app.portofolio.webui.hr.common.utilities.ComponentConditionUtil;
import org.app.portofolio.webui.hr.employee.model.DummyNationalityItemRender;
import org.app.portofolio.webui.hr.employee.model.EmployeeStatusListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.JobCategoryListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.JobTitleListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.LocationListItemRenderer;
import org.app.portofolio.webui.hr.employee.model.SubUnitListItemRenderer;
import org.app.portofolio.webui.hr.employee.validator.TrsEmployeeJobFormValidator;
import org.module.hr.model.MstEmployementStatus;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.MstLocation;
import org.module.hr.model.MstNationality;
import org.module.hr.model.MstSubUnit;
import org.module.hr.model.TrsEmployee;
import org.module.hr.service.EmployeeService;
import org.module.hr.service.JobService;
import org.module.sysadmin.model.SecRight;
import org.springframework.beans.factory.parsing.Location;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Window;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Job {
	
	@Wire("#windowJob")
	private Window windowJob;
	
	@Wire("#bandBoxJobTitle")
	private Bandbox bandBoxJobTitle;
	
	@Wire("#listBoxJobTitle")
	private Listbox listBoxJobTitle;
	
	@Wire("#bandBoxEmploymentStatus")
	private Bandbox bandBoxEmploymentStatus;
	
	@Wire("#listBoxEmploymentStatus")
	private Listbox listBoxEmploymentStatus;
	
	@Wire("#bandBoxJobCategory")
	private Bandbox bandBoxJobCategory;
	
	@Wire("#listBoxJobCategory")
	private Listbox listBoxJobCategory;
	
	@Wire("#bandBoxSubUnit")
	private Bandbox bandBoxSubUnit;
	
	@Wire("#listBoxSubUnit")
	private Listbox listBoxSubUnit;
	
	@Wire("#bandBoxLocation")
	private Bandbox bandBoxLocation;
	
	@Wire("#listBoxLocation")
	private Listbox listBoxLocation;
	
	@Wire("#buttonEdit")
	private Button buttonEdit;
	
	@Wire("#buttonSave")
	private Button buttonSave;
	
	@Wire("#buttonTerminateEmployment")
	private Button buttonTerminateEmployment;
	
	@Wire("#dateBoxJoinedDate")
	private Datebox dateBoxJoinedDate;
	
	/*---------- service ----------*/
	@WireVariable
	private EmployeeService employeeService;
	
	@WireVariable
	private JobService masterJobService;
	
	/*---------- bean ---------*/
	private TrsEmployee trsEmployee;
	private TrsEmployeeJobFormValidator formValidator = new TrsEmployeeJobFormValidator();

	private ListitemRenderer<MstJobtitle> listitemRendererJobTitle;
	private String jobTitleKeySearch;
	private List<MstJobtitle> mstJobtitles;
	private MstJobtitle selectedMstJobtitle;
	
	private ListitemRenderer<MstEmployementStatus> listitemRendererEmploymentStatus;
	private String employmentStatusKeySearch;
	private List<MstEmployementStatus> listMstEmployementStatus;
	private MstEmployementStatus selectedMstEmployementStatus;
	
	private ListitemRenderer<MstJobCategory> listitemRendererJobCategory;
	private String jobCategoryKeySearch;
	private List<MstJobCategory> mstJobCategories;
	private MstJobCategory selectedMstJobCategory;
	
	private ListitemRenderer<MstSubUnit> listitemRendererSubUnit;
	private String subUnitKeySearch;
	private List<MstSubUnit> mstSubUnits;
	private MstSubUnit selectedMstSubUnit;
	
	private ListitemRenderer<MstLocation> listitemRendererLocation;
	private String locationKeySearch;
	private List<MstLocation> mstLocations;
	private MstLocation selectedMstLocation;

	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
			@ExecutionArgParam("object") Object object, @ExecutionArgParam("type") TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
		formDetailCondition();
	}
	
	@Command
	private void searchJobTitle() {
		mstJobtitles.clear();
		List<MstJobtitle> cacheMstJobtitles = masterJobService.getAllMstJobtitles();
		if (jobTitleKeySearch == null || "".equals(jobTitleKeySearch)){
			mstJobtitles.addAll(cacheMstJobtitles);
		} else {
			for (MstJobtitle mstJobtitle : cacheMstJobtitles) {
				if (mstJobtitle.getJobName().contains(jobTitleKeySearch)) {
					mstJobtitles.clear();
					mstJobtitles.add(mstJobtitle);
					break;
				}
			}
		}
		listBoxJobTitle.setModel(new ListModelList<MstJobtitle>(mstJobtitles));
	}
	
	@Command
	private void openBandBoxJobTitle(){
		mstJobtitles = masterJobService.getAllMstJobtitles();
		
		listitemRendererJobTitle = new JobTitleListItemRenderer();
		
		listBoxJobTitle.setModel(new ListModelList<MstJobtitle>(mstJobtitles));
		listBoxJobTitle.setItemRenderer(listitemRendererJobTitle);
	}
	
	@Command
	private void searchEmploymentStatus() {
		listMstEmployementStatus.clear();
		List<MstEmployementStatus> cacheListMstEmployementStatus = masterJobService.getAllMstEmployementStatus();
		if (employmentStatusKeySearch == null || "".equals(employmentStatusKeySearch)){
			listMstEmployementStatus.addAll(cacheListMstEmployementStatus);
		} else {
			for (MstEmployementStatus mstEmployementStatus : cacheListMstEmployementStatus) {
				if (mstEmployementStatus.getEmployementStatusName().contains(employmentStatusKeySearch)) {
					listMstEmployementStatus.clear();
					listMstEmployementStatus.add(mstEmployementStatus);
					break;
				}
			}
		}
		listBoxEmploymentStatus.setModel(new ListModelList<MstEmployementStatus>(listMstEmployementStatus));
	}
	
	@Command
	private void openBandBoxEmploymentStatus(){
		listMstEmployementStatus = masterJobService.getAllMstEmployementStatus();
		
		listitemRendererEmploymentStatus = new EmployeeStatusListItemRenderer();
		
		listBoxEmploymentStatus.setModel(new ListModelList<MstEmployementStatus>(listMstEmployementStatus));
		listBoxEmploymentStatus.setItemRenderer(listitemRendererEmploymentStatus);
	}
	
	@Command
	private void searchJobCategory() {
		mstJobCategories.clear();
		List<MstJobCategory> cacheMstJobCategories = masterJobService.getAllMstJobCategories();
		if (jobCategoryKeySearch == null || "".equals(jobCategoryKeySearch)){
			mstJobCategories.addAll(cacheMstJobCategories);
		} else {
			for (MstJobCategory mstJobCategory: cacheMstJobCategories) {
				if (mstJobCategory.getJobCategoryName().contains(jobCategoryKeySearch)) {
					mstJobCategories.clear();
					mstJobCategories.add(mstJobCategory);
					break;
				}
			}
		}
		listBoxJobCategory.setModel(new ListModelList<MstJobCategory>(mstJobCategories));
	}
	
	@Command
	private void openBandBoxJobCategory(){
		mstJobCategories = masterJobService.getAllMstJobCategories();
		
		listitemRendererJobCategory = new JobCategoryListItemRenderer();
		
		listBoxJobCategory.setModel(new ListModelList<MstJobCategory>(mstJobCategories));
		listBoxJobCategory.setItemRenderer(listitemRendererJobCategory);
	}
	
	@Command
	private void searchSubUnit() {
		mstSubUnits.clear();
		
		// get all sub unit by service
		List<MstSubUnit> cacheMstSubUnits = new ArrayList<>();
		
		if (subUnitKeySearch == null || "".equals(subUnitKeySearch)){
			mstSubUnits.addAll(cacheMstSubUnits);
		} else {
			for (MstSubUnit mstSubUnit: cacheMstSubUnits) {
				if (mstSubUnit.getNameSubUnit().contains(subUnitKeySearch)) {
					mstSubUnits.clear();
					mstSubUnits.add(mstSubUnit);
					break;
				}
			}
		}
		listBoxSubUnit.setModel(new ListModelList<MstSubUnit>(mstSubUnits));
	}
	
	@Command
	private void openBandBoxSubUnit(){
		
		// get all sub unit by service
		
		listitemRendererSubUnit= new SubUnitListItemRenderer();
		
		listBoxSubUnit.setModel(new ListModelList<MstSubUnit>(mstSubUnits));
		listBoxSubUnit.setItemRenderer(listitemRendererSubUnit);
	}
	
	@Command
	private void searchLocation() {
		mstLocations.clear();
		
		// get all location by service
		List<MstLocation> cacheMstLocations = new ArrayList<>();
		
		if (locationKeySearch == null || "".equals(locationKeySearch)){
			mstLocations.addAll(cacheMstLocations);
		} else {
			for (MstLocation mstLocation: cacheMstLocations) {
				if (mstLocation.getName().contains(locationKeySearch)) {
					mstLocations.clear();
					mstLocations.add(mstLocation);
					break;
				}
			}
		}
		listBoxLocation.setModel(new ListModelList<MstLocation>(mstLocations));
	}
	
	@Command
	private void openBandBoxLocation(){
		
		// get all location by service
		
		listitemRendererLocation= new LocationListItemRenderer(); 
		
		listBoxLocation.setModel(new ListModelList<MstLocation>(mstLocations));
		listBoxLocation.setItemRenderer(listitemRendererLocation);
	}
	
	/**
	 * 
	 */
	private void formEditCondition() {
		ComponentConditionUtil.visibleButton(buttonSave, buttonTerminateEmployment);
		ComponentConditionUtil.invisibleButton(buttonEdit);
		ComponentConditionUtil.enableBandBox(bandBoxEmploymentStatus, bandBoxJobCategory, bandBoxJobTitle, bandBoxLocation, bandBoxSubUnit);
		ComponentConditionUtil.enableDateBox(dateBoxJoinedDate);
	}
	
	/**
	 * 
	 */
	private void formDetailCondition() {
		ComponentConditionUtil.invisibleButton(buttonSave);
		ComponentConditionUtil.visibleButton(buttonEdit, buttonTerminateEmployment);
		ComponentConditionUtil.disableBandBox(bandBoxEmploymentStatus, bandBoxJobCategory, bandBoxJobTitle, bandBoxLocation, bandBoxSubUnit);
		ComponentConditionUtil.disableDateBox(dateBoxJoinedDate);
	}

	public TrsEmployee getTrsEmployee() {
		return trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}
	
}
