package org.module.hr.service;

import java.util.List;

import org.module.hr.model.MstPaygrade;

public interface MstPaygradeService {
	public void save(MstPaygrade mstPaygrade);
    public void update(MstPaygrade mstPaygrade);
    public void saveOrUpdate(MstPaygrade mstPaygrade);
    public void delete(MstPaygrade mstPaygrade);
    public List<MstPaygrade> getAllMstPaygrades();
}
