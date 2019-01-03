package org.module.hr.service;

import java.util.HashMap;
import java.util.List;

import org.module.hr.model.MstLocation;

public interface OrganizationService {
	/*- Location +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public void save(MstLocation mstLocation);
    public void update(MstLocation mstLocation);
    public void saveOrUpdate(MstLocation mstLocation);
    public void delete(MstLocation mstLocation);
    public List<MstLocation> getAllMstLocation();
    public List<MstLocation> getOrganizationByRequestMap(HashMap<String, Object> hashMap);
    public List<MstLocation> getMstLocationPaging(HashMap<String, Object> hashMap);
    public int getCountMstLocations();
}