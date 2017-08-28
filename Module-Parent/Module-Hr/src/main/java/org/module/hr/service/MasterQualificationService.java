package org.module.hr.service;

import java.util.List;

import org.module.hr.model.MstEducation;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstMembership;
import org.module.hr.model.MstSkill;

public interface MasterQualificationService {

	/* ------- Skill --------*/
	public void save(MstSkill mstSkill);
    public void update(MstSkill mstSkill);
    public void saveOrUpdate(MstSkill mstSkill);
    public void delete(MstSkill mstSkill);
    public List<MstSkill> getAllMstSkill();
    
    /* -------- Language ------*/
    public void save(MstLanguage mstLanguage);
    public void update(MstLanguage mstLanguage);
    public void saveOrUpdate(MstLanguage mstLanguage);
    public void delete(MstLanguage mstLanguage);
    public List<MstLanguage> getAllMstLanguage();
    
    /* -------- Education ------*/
    public void save(MstEducation mstEducation);
    public void update(MstEducation mstEducation);
    public void saveOrUpdate(MstEducation mstEducation);
    public void delete(MstEducation mstEducation);
    public List<MstEducation> getAllMstEducation();
    
    /* -------- License-- ------*/
    public void save(MstLicense mstLicense);
    public void update(MstLicense mstLicense);
    public void saveOrUpdate(MstLicense mstLicense);
    public void delete(MstLicense mstLicense);
    public List<MstLicense> getAllMstLicense();
    
    /* -------- Membership ------*/
    public void save(MstMembership mstMembership);
    public void update(MstMembership mstMembership);
    public void saveOrUpdate(MstMembership mstMembership);
    public void delete(MstMembership mstMembership);
    public List<MstMembership> getAllMstMembership();
}
