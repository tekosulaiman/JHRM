package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstEmployementStatus;
import org.module.hr.model.MstJobCategory;
import org.module.hr.model.MstJobtitle;
import org.module.hr.model.MstPaygrade;

public interface MasterJobService {

	/* ------------ JobTitle ----------*/
	public void save(MstJobtitle mstJobtitle);
    public void update(MstJobtitle mstJobtitle);
    public void saveOrUpdate(MstJobtitle mstJobtitle);
    public void delete(MstJobtitle mstJobtitle);
    public List<MstJobtitle> getAllMstJobtitles();
    public List<MstJobtitle> getByRequestMstJobtitles(HashMap<String, Object> hashMap);
    public Long getCountMsJobtitles();
    
    /* ----------- PayGrade -----------*/
    public void save(MstPaygrade mstPaygrade);
    public void update(MstPaygrade mstPaygrade);
    public void saveOrUpdate(MstPaygrade mstPaygrade);
    public void delete(MstPaygrade mstPaygrade);
    public List<MstPaygrade> getAllMstPaygrades();
    
    /* ------- Employment Status --------*/
    public void save(MstEmployementStatus mstEmployementStatus);
    public void update(MstEmployementStatus mstEmployementStatus);
    public void saveOrUpdate(MstEmployementStatus mstEmployementStatus);
    public void delete(MstEmployementStatus mstEmployementStatus);
    public List<MstEmployementStatus> getAllMstEmployementStatus();
    
    /* ---------- Job Category -----------*/
    public void save(MstJobCategory mstJobCategory);
    public void update(MstJobCategory mstJobCategory);
    public void saveOrUpdate(MstJobCategory mstJobCategory);
    public void delete(MstJobCategory mstJobCategory);
    public List<MstJobCategory> getAllMstJobCategories();
}
