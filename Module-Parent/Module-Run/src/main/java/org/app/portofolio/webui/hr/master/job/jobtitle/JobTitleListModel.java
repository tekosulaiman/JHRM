package org.app.portofolio.webui.hr.master.job.jobtitle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.module.hr.model.MstJobtitle;
import org.module.hr.service.MasterJobService;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.AbstractListModel;

public class JobTitleListModel extends AbstractListModel<MstJobtitle>{

	@WireVariable
	private MasterJobService masterJobService;
    private int pageSize = 10;
	private final static String CACHE_KEY= JobTitleListModel.class+"_cache";
   
   private HashMap<String, Object> hashMap = new HashMap<String, Object>();

   public JobTitleListModel(MasterJobService masterJobService){
	   this.masterJobService = masterJobService;
   }

   public MstJobtitle getElementAt(int index) {
	   Map<Integer, MstJobtitle> cache = getCache();
	   
	   MstJobtitle targetPerson = cache.get(index);
	   
	   if (targetPerson == null){
		   //if cache doesn't contain target object, query a page size of data starting from the index
		   
		   hashMap.put("firstResult", index);
		   hashMap.put("maxResult", pageSize);
		   
		   List<MstJobtitle> pageResult = masterJobService.getByRequestMstJobtitles(hashMap);
		   
		   int indexKey = index;
		   
		   for (MstJobtitle o : pageResult ){
			   cache.put(indexKey, o);
			   indexKey++;
		   }   
	   }else{
			return targetPerson;
	   }
	   
	   //get the target after query from database
	   targetPerson = cache.get(index);
	   
	   if (targetPerson == null){
		   //if we still cannot find the target object from database, there is inconsistency between memory and the database
		   throw new RuntimeException("Element at index "+index+" cannot be found in the database.");
	   }else{
		   return targetPerson;
	   }   
   }

   private Map<Integer, MstJobtitle> getCache(){
	   Execution execution = Executions.getCurrent();
	   //we only reuse this cache in one execution to avoid accessing detached objects.
	   //our filter opens a session during a HTTP request
	   Map<Integer, MstJobtitle> cache = (Map)execution.getAttribute(CACHE_KEY);
	   if (cache == null){
		   cache = new HashMap<Integer, MstJobtitle>();
		   execution.setAttribute(CACHE_KEY, cache);
	   }
	   
	   return cache;
   }

   public int getSize() {
		long count = masterJobService.getCountMsJobtitles();
		int i = (int) count;
	
		return i;
   }
}