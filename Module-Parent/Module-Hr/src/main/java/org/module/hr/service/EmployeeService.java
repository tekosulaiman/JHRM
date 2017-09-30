package org.module.hr.service;

import java.util.List;
import java.util.Map;

import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeDependent;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.model.TrsEmployeeLicense;
import org.module.hr.model.TrsEmployeeMembership;
import org.module.hr.model.dto.MaritalStatusType;
import org.module.hr.model.dto.RelationshipType;

public interface EmployeeService {
	
	/*Employee Detail*/
	public void save(TrsEmployee trsEmployee);
	public void update(TrsEmployee trsEmployee);
	public void saveOrUpdate(TrsEmployee trsEmployee);
	public void delete(TrsEmployee trsEmployee);
	public List<TrsEmployee> getAllTrsEmployee();
	public List<TrsEmployee> getByTrsEmployeeRequestMap(Map<String, Object> requestMap);
	
	/*Employee Emergency Contact*/
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact);
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact();
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(Map<String, Object> requestMap);
	
	/*Employee Dependent*/
	public void save(TrsEmployeeDependent trsEmployeeDependent);
	public void update(TrsEmployeeDependent trsEmployeeDependent);
	public void saveOrUpdate(TrsEmployeeDependent trsEmployeeDependent);
	public void delete(TrsEmployeeDependent trsEmployeeDependent);
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent();
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(Map<String, Object> requestMap);
	
	/*Employee Membership*/
	public void save(TrsEmployeeMembership trsEmployeeMembership);
	public void update(TrsEmployeeMembership trsEmployeeMembership);
	public void saveOrUpdate(TrsEmployeeMembership trsEmployeeMembership);
	public void delete(TrsEmployeeMembership trsEmployeeMembership);
	public List<TrsEmployeeMembership> getAllTrsEmployeeMembership();
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(Map<String, Object> requestMap);
	
	/*Employee License*/
	public void save(TrsEmployeeLicense trsEmployeeLicense);
	public void update(TrsEmployeeLicense trsEmployeeLicense);
	public void saveOrUpdate(TrsEmployeeLicense trsEmployeeLicense);
	public void delete(TrsEmployeeLicense trsEmployeeLicense);
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense();
	
	/*Relationship Type*/
	public List<RelationshipType> getAllRelationshipType();
	public RelationshipType getRelationshipTypeById(int id);

	/*MaritalStatus Type*/
	public List<MaritalStatusType> getAllMaritalStatusType();
	public MaritalStatusType getMaritalStatusTypeTypeById(int id);
	

}
