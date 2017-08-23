package org.module.hr.service.impl;

import java.util.List;

import org.module.hr.dao.MstSkillDAO;
import org.module.hr.model.MstSkill;
import org.module.hr.service.MasterQualificationService;

public class MasterQualificationServiceImpl implements MasterQualificationService {

	/* ---------- Skill -------------- */
	private MstSkillDAO mstSkillDAO; 
	
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

	public void setmstSkillDAO(MstSkillDAO mstSkillDAO) {
		this.mstSkillDAO = mstSkillDAO;
	}
}
