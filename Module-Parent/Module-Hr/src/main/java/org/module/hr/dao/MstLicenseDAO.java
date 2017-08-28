package org.module.hr.dao;

import java.util.List;

import org.module.hr.model.MstLicense;

public interface MstLicenseDAO {
	public void save(MstLicense mstLicense);
    public void update(MstLicense mstLicense);
    public void saveOrUpdate(MstLicense mstLicense);
    public void delete(MstLicense mstLicense);
    public List<MstLicense> getAllMstLicense();
}
