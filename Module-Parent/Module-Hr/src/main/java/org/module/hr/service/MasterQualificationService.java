package org.module.hr.service;

import java.util.List;

import org.module.hr.model.MstSkill;

public interface MasterQualificationService {

	/* ------- Skill --------*/
	public void save(MstSkill mstSkill);
    public void update(MstSkill mstSkill);
    public void saveOrUpdate(MstSkill mstSkill);
    public void delete(MstSkill mstSkill);
    public List<MstSkill> getAllMstSkill();
}
