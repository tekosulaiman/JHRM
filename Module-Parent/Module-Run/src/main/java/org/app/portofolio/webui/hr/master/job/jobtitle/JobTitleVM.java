package org.app.portofolio.webui.hr.master.job.jobtitle;

import java.util.List;

import org.app.portofolio.webui.hr.master.job.jobtitle.model.MstJobtitleListItemRenderer;
import org.module.hr.model.MstJobtitle;
import org.module.hr.service.MstJobtitleService;
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

public class JobTitleVM {
	
	@Wire("#listBoxJobTitle")
	private Listbox listBoxJobTitle;

	private MstJobtitle mstJobtitle;
	private List<MstJobtitle> mstJobtitles;
	@WireVariable
	private MstJobtitleService mstJobtitleService;
	private MstJobtitleListItemRenderer mstJobtitleListItemRenderer;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		mstJobtitles = mstJobtitleService.getAllMstJobtitles();

		this.mstJobtitleListItemRenderer = new MstJobtitleListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
			}
		};
		
		listBoxJobTitle.setModel(new ListModelList<MstJobtitle>(mstJobtitles));
	}

	public MstJobtitle getMstJobtitle() {
		return mstJobtitle;
	}

	public void setMstJobtitle(MstJobtitle mstJobtitle) {
		this.mstJobtitle = mstJobtitle;
	}

	public List<MstJobtitle> getMstJobtitles() {
		return mstJobtitles;
	}

	public void setMstJobtitles(List<MstJobtitle> mstJobtitles) {
		this.mstJobtitles = mstJobtitles;
	}

	public MstJobtitleService getMstJobtitleService() {
		return mstJobtitleService;
	}

	public void setMstJobtitleService(MstJobtitleService mstJobtitleService) {
		this.mstJobtitleService = mstJobtitleService;
	}

	public MstJobtitleListItemRenderer getMstJobtitleListItemRenderer() {
		return mstJobtitleListItemRenderer;
	}

	public void setMstJobtitleListItemRenderer(MstJobtitleListItemRenderer mstJobtitleListItemRenderer) {
		this.mstJobtitleListItemRenderer = mstJobtitleListItemRenderer;
	}
}