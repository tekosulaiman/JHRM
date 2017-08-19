package org.app.portofolio.webui.hr.test;

import java.util.List;

import org.app.portofolio.webui.hr.test.model.TestListItemRenderer;
import org.module.hr.model.MstTest;
import org.module.hr.service.MstTestService;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class TestInlineVM {
	
	@Wire("#listBoxTest")
	private Listbox listBoxTest;

	private MstTest mstTest;
	private List<MstTest> mstTests;
	@WireVariable
	private MstTestService mstTestService;
	private TestListItemRenderer testListItemRenderer;

	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Inisialize Methode MVVM yang pertama kali dijalankan
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	@AfterCompose
	public void setupComponents(@ContextParam(ContextType.VIEW) Component component,
		@ExecutionArgParam("object") Object object) {
		
		Selectors.wireComponents(component, this, false);
		
		mstTests = mstTestService.getAllMstTests();
		System.out.println("List >>>"+mstTests.size());

		this.testListItemRenderer = new TestListItemRenderer() {
			@Override
			protected void buttonSaveActionListener() {
				super.buttonSaveActionListener();
			}
		};
		
		listBoxTest.setModel(new ListModelList<MstTest>(mstTests));
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * Function CRUD Event
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

	@Command
	public void doInline(){
		Executions.createComponents("/WEB-INF/pages/module_hr/test/testInline.zul", null, null);
	}
	
	@Command
	public void doDialog(){
		Executions.createComponents("/WEB-INF/pages/module_hr/test/testDialog.zul", null, null);
	}

	public MstTest getMstTest() {
		return mstTest;
	}

	public void setMstTest(MstTest mstTest) {
		this.mstTest = mstTest;
	}

	public List<MstTest> getMstTests() {
		return mstTests;
	}

	public void setMstTests(List<MstTest> mstTests) {
		this.mstTests = mstTests;
	}

	public MstTestService getMstTestService() {
		return mstTestService;
	}

	public void setMstTestService(MstTestService mstTestService) {
		this.mstTestService = mstTestService;
	}

	public TestListItemRenderer getTestListItemRenderer() {
		return testListItemRenderer;
	}

	public void setTestListItemRenderer(TestListItemRenderer testListItemRenderer) {
		this.testListItemRenderer = testListItemRenderer;
	}
}