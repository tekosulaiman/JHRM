package org.app.portofolio.webui.hr.master.job.jobcategory;

import java.util.List;

import org.app.portofolio.webui.hr.master.job.jobcategory.model.MstJobCategoryListItemRenderer;
import org.module.hr.model.MstJobCategory;
import org.module.hr.service.MstJobCategoryService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class JobCategoryVM {
	
	@Wire("#listBoxJobCategory")
	private Listbox listBoxJobCategory;

	private MstJobCategory mstJobCategory;
	private List<MstJobCategory> mstJobCategories;
	@WireVariable
	private MstJobCategoryService mstJobCategoryService;
	private MstJobCategoryListItemRenderer mstJobCategoryListItemRenderer;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		mstJobCategories = mstJobCategoryService.getAllMstJobCategories();

		this.mstJobCategoryListItemRenderer = new MstJobCategoryListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
			}
		};
		
		listBoxJobCategory.setModel(new ListModelList<MstJobCategory>(mstJobCategories));
	}

	public MstJobCategory getMstJobCategory() {
		return mstJobCategory;
	}

	public void setMstJobCategory(MstJobCategory mstJobCategory) {
		this.mstJobCategory = mstJobCategory;
	}

	public List<MstJobCategory> getMstJobCategories() {
		return mstJobCategories;
	}

	public void setMstJobCategories(List<MstJobCategory> mstJobCategories) {
		this.mstJobCategories = mstJobCategories;
	}

	public MstJobCategoryService getMstJobCategoryService() {
		return mstJobCategoryService;
	}

	public void setMstJobCategoryService(MstJobCategoryService mstJobCategoryService) {
		this.mstJobCategoryService = mstJobCategoryService;
	}

	public MstJobCategoryListItemRenderer getMstJobCategoryListItemRenderer() {
		return mstJobCategoryListItemRenderer;
	}

	public void setMstJobCategoryListItemRenderer(MstJobCategoryListItemRenderer mstJobCategoryListItemRenderer) {
		this.mstJobCategoryListItemRenderer = mstJobCategoryListItemRenderer;
	}
}