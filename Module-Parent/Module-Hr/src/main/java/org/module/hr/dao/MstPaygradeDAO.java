package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstPaygrade;

public interface MstPaygradeDAO {
	public void save(MstPaygrade mstPaygrade);
    public void update(MstPaygrade mstPaygrade);
    public void saveOrUpdate(MstPaygrade mstPaygrade);
    public void delete(MstPaygrade mstPaygrade);
    public List<MstPaygrade> getAllMstPaygrades();
}
