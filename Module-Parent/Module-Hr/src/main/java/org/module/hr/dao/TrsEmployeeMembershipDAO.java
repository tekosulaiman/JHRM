package org.module.hr.dao;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployeeMembership;

public interface TrsEmployeeMembershipDAO {
	public void save(TrsEmployeeMembership trsEmployeeMembership);
	public void update(TrsEmployeeMembership trsEmployeeMembership);
	public void saveOrUpdate(TrsEmployeeMembership trsEmployeeMembership);
	public void delete(TrsEmployeeMembership trsEmployeeMembership);
	public List<TrsEmployeeMembership> getAllTrsEmployeeMembership();
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap (Map<String, Object> requestMap);
}