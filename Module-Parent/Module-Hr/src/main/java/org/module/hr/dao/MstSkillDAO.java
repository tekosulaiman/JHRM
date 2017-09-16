package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstSkill;

public interface MstSkillDAO {
	public void save(MstSkill mstSkill);
    public void update(MstSkill mstSkill);
    public void saveOrUpdate(MstSkill mstSkill);
    public void delete(MstSkill mstSkill);
    public List<MstSkill> getAllMstSkill();
    public MstSkill getMstSkillById(Integer id);
}
