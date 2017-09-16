package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstEducationDAO;
import org.module.hr.dao.MstLanguageDAO;
import org.module.hr.dao.MstLicenseDAO;
import org.module.hr.dao.MstMembershipDAO;
import org.module.hr.dao.MstSkillDAO;
import org.module.hr.model.MstEducation;
import org.module.hr.model.MstLanguage;
import org.module.hr.model.MstLicense;
import org.module.hr.model.MstMembership;
import org.module.hr.model.MstSkill;
import org.module.hr.service.MasterQualificationService;

public class MasterQualificationServiceImpl implements MasterQualificationService {

	private MstSkillDAO mstSkillDAO; 
	private MstLanguageDAO mstLanguageDAO;
	private MstEducationDAO mstEducationDAO;
	private MstLicenseDAO mstLicenseDAO;
	private MstMembershipDAO mstMembershipDAO;

	/* ---------- Skill -------------- */
	@Override
	public void save(MstSkill mstSkill) {
		mstSkillDAO.save(mstSkill);
	}

	@Override
	public void update(MstSkill mstSkill) {
		mstSkillDAO.update(mstSkill);
	}

	@Override
	public void saveOrUpdate(MstSkill mstSkill) {
		mstSkillDAO.saveOrUpdate(mstSkill);
	}

	@Override
	public void delete(MstSkill mstSkill) {
		mstSkillDAO.delete(mstSkill);
	}

	@Override
	public List<MstSkill> getAllMstSkill() {
		List<MstSkill> list = mstSkillDAO.getAllMstSkill();
		return list;
	}

	@Override
	public MstSkill getMstSkillById(Integer id) {
		return mstSkillDAO.getMstSkillById(id);
	}
	
	public void setMstSkillDAO(MstSkillDAO mstSkillDAO) {
		this.mstSkillDAO = mstSkillDAO;
	}

	/* ---------- Language -------------- */
	@Override
	public void save(MstLanguage mstLanguage) {
		mstLanguageDAO.save(mstLanguage);
	}

	@Override
	public void update(MstLanguage mstLanguage) {
		mstLanguageDAO.update(mstLanguage);
	}

	@Override
	public void saveOrUpdate(MstLanguage mstLanguage) {
		mstLanguageDAO.saveOrUpdate(mstLanguage);
	}

	@Override
	public void delete(MstLanguage mstLanguage) {
		mstLanguageDAO.delete(mstLanguage);
	}

	@Override
	public List<MstLanguage> getAllMstLanguage() {
		return mstLanguageDAO.getAllMstLanguage();
	}
	
	public void setMstLanguageDAO(MstLanguageDAO mstLanguageDAO) {
		this.mstLanguageDAO = mstLanguageDAO;
	}

	/* ---------- Language -------------- */
	@Override
	public void save(MstEducation mstEducation) {
		mstEducationDAO.save(mstEducation);
	}

	@Override
	public void update(MstEducation mstEducation) {
		mstEducationDAO.update(mstEducation);
	}

	@Override
	public void saveOrUpdate(MstEducation mstEducation) {
		mstEducationDAO.saveOrUpdate(mstEducation);
	}

	@Override
	public void delete(MstEducation mstEducation) {
		mstEducationDAO.delete(mstEducation);
	}

	@Override
	public List<MstEducation> getAllMstEducation() {
		return mstEducationDAO.getAllMstEducation();
	}
	
	public void setMstEducationDAO(MstEducationDAO mstEducationDAO) {
		this.mstEducationDAO = mstEducationDAO;
	}

	
	/* ---------- License --------------- */
	@Override
	public void save(MstLicense mstLicense) {
		mstLicenseDAO.save(mstLicense);
	}

	@Override
	public void update(MstLicense mstLicense) {
		mstLicenseDAO.update(mstLicense);
	}

	@Override
	public void saveOrUpdate(MstLicense mstLicense) {
		mstLicenseDAO.saveOrUpdate(mstLicense);
	}

	@Override
	public void delete(MstLicense mstLicense) {
		mstLicenseDAO.delete(mstLicense);
	}

	@Override
	public List<MstLicense> getAllMstLicense() {
		return mstLicenseDAO.getAllMstLicense();
	}
	
	public void setMstLicenseDAO(MstLicenseDAO mstLicenseDAO) {
		this.mstLicenseDAO = mstLicenseDAO;
	}

	/* ---------- License --------------- */
	@Override
	public void save(MstMembership mstMembership) {
		mstMembershipDAO.save(mstMembership);
	}

	@Override
	public void update(MstMembership mstMembership) {
		mstMembershipDAO.update(mstMembership);
	}

	@Override
	public void saveOrUpdate(MstMembership mstMembership) {
		mstMembershipDAO.saveOrUpdate(mstMembership);
	}

	@Override
	public void delete(MstMembership mstMembership) {
		mstMembershipDAO.delete(mstMembership);
	}

	@Override
	public List<MstMembership> getAllMstMembership() {
		return mstMembershipDAO.getAllMstMembership();
	}
	
	public void setMstMembershipDAO(MstMembershipDAO mstMembershipDAO) {
		this.mstMembershipDAO = mstMembershipDAO;
	}
}
