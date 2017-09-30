package org.module.hr.service.impl;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Around;
import org.module.hr.dao.TrsEmployeeDAO;
import org.module.hr.dao.TrsEmployeeDependentDAO;
import org.module.hr.dao.TrsEmployeeEmergencyContactDAO;
import org.module.hr.dao.TrsEmployeeLicenseDAO;
import org.module.hr.dao.TrsEmployeeMembershipDAO;
import org.module.hr.model.TrsEmployee;
import org.module.hr.model.TrsEmployeeDependent;
import org.module.hr.model.TrsEmployeeEmergencyContact;
import org.module.hr.model.TrsEmployeeLicense;
import org.module.hr.model.TrsEmployeeMembership;
import org.module.hr.model.dto.MaritalStatusType;
import org.module.hr.model.dto.RelationshipType;
import org.module.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private TrsEmployeeDAO trsEmployeeDAO;
	
	@Autowired
	private TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO;
	
	@Autowired
	private TrsEmployeeLicenseDAO trsEmployeeLicenseDAO ;
	
	@Autowired
	private TrsEmployeeDependentDAO trsEmployeeDependentDAO;
	
	@Autowired
	private TrsEmployeeMembershipDAO trsEmployeeMembershipDAO;
	
	/*---------- Employee Detail ----------*/
	@Override
	public void save(TrsEmployee trsEmployee) {
		trsEmployeeDAO.save(trsEmployee);
	}
	
	@Override
	public void update(TrsEmployee trsEmployee) {
		trsEmployeeDAO.update(trsEmployee);
	}
	
	@Override
	public void saveOrUpdate(TrsEmployee trsEmployee) {
		trsEmployeeDAO.saveOrUpdate(trsEmployee);
	}
	
	@Override
	public void delete(TrsEmployee trsEmployee) {
		trsEmployeeDAO.delete(trsEmployee);
	}

	@Override
	public List<TrsEmployee> getAllTrsEmployee() {
		return trsEmployeeDAO.getAllTrsEmployee();
	}

	@Override
	public List<TrsEmployee> getByTrsEmployeeRequestMap(Map<String, Object> requestMap) {
		return trsEmployeeDAO.getByMstTestRequestMap(requestMap);
	}
	
	/*---------- Employee Emergency Contact ----------*/

	@Override
	public void save(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.save(trsEmployeeEmergencyContact);
	}

	@Override
	public void update(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.update(trsEmployeeEmergencyContact);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.saveOrUpdate(trsEmployeeEmergencyContact);
	}

	@Override
	public void delete(TrsEmployeeEmergencyContact trsEmployeeEmergencyContact) {
		trsEmployeeEmergencyContactDAO.delete(trsEmployeeEmergencyContact);
	}

	@Override
	public List<TrsEmployeeEmergencyContact> getAllTrsEmployeeEmergencyContact() {
		return trsEmployeeEmergencyContactDAO.getAllTrsEmployeeEmergencyContact();
	}
	
	@Override
	public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(Map<String, Object> requestMap){
		return trsEmployeeEmergencyContactDAO.getTrsEmployeeEmergencyContactByTrsEmployeeEmergencyContactRequestMap(requestMap);
	}
	
	/*---------- Employee Emergency Contact ----------*/
	
	@Override
	public void save(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.save(trsEmployeeDependent);
	}

	@Override
	public void update(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.update(trsEmployeeDependent);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.saveOrUpdate(trsEmployeeDependent);
	}

	@Override
	public void delete(TrsEmployeeDependent trsEmployeeDependent) {
		trsEmployeeDependentDAO.delete(trsEmployeeDependent);
	}

	@Override
	public List<TrsEmployeeDependent> getAllTrsEmployeeDependent() {
		return trsEmployeeDependentDAO.getAllTrsEmployeeDependent();
	}
	
	@Override
	public List<TrsEmployeeDependent> getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(Map<String, Object> requestMap){
		return trsEmployeeDependentDAO.getTrsEmployeeDependentByTrsEmployeeDependentRequestMap(requestMap);
	}
	
	/*---------- Employee Membership ----------*/
	
	@Override
	public void save(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.save(trsEmployeeMembership);
	}

	@Override
	public void update(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.update(trsEmployeeMembership);
	}

	@Override
	public void saveOrUpdate(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.saveOrUpdate(trsEmployeeMembership);
	}

	@Override
	public void delete(TrsEmployeeMembership trsEmployeeMembership) {
		trsEmployeeMembershipDAO.delete(trsEmployeeMembership);
	}	

	@Override
	public List<TrsEmployeeMembership> getAllTrsEmployeeMembership() {
		return trsEmployeeMembershipDAO.getAllTrsEmployeeMembership();
	}
	
	@Override
	public List<TrsEmployeeMembership> getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(Map<String, Object> requestMap){
		return trsEmployeeMembershipDAO.getTrsEmployeeMembershipByTrsEmployeeMembershipRequestMap(requestMap);
	}
	
	/*---------- Employee License ----------*/
	
	@Override
	public void save(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.save(trsEmployeeLicense);
	}
	
	@Override
	public void update(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.update(trsEmployeeLicense);
	}
	
	@Override
	public void saveOrUpdate(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.saveOrUpdate(trsEmployeeLicense);
	}
	
	@Override
	public void delete(TrsEmployeeLicense trsEmployeeLicense){
		trsEmployeeLicenseDAO.delete(trsEmployeeLicense);
	}
	
	@Override
	public List<TrsEmployeeLicense> getAllTrsEmployeeLicense(){
		return trsEmployeeLicenseDAO.getAllTrsEmployeeLicense();
	}
	
	/*---------- Relationship Type ----------*/
	@Override
	public List<RelationshipType> getAllRelationshipType(){
		return RelationshipType.getAllTypes();
	}
	
	@Override
	public RelationshipType getRelationshipTypeById(int id){
		return RelationshipType.getTypById(id);
	}
	
	/*---------- MaritalStatus Type ----------*/
	@Override
	public List<MaritalStatusType> getAllMaritalStatusType(){
		return MaritalStatusType.getAllTypes();
	}
	
	@Override
	public MaritalStatusType getMaritalStatusTypeTypeById(int id){
		return MaritalStatusType.getTypById(id);
	}


	// setter DAO 
	public void setTrsEmployeeDAO(TrsEmployeeDAO trsEmployeeDAO) {
		this.trsEmployeeDAO = trsEmployeeDAO;
	}

	public void setTrsEmployeeEmergencyContactDAO(TrsEmployeeEmergencyContactDAO trsEmployeeEmergencyContactDAO) {
		this.trsEmployeeEmergencyContactDAO = trsEmployeeEmergencyContactDAO;
	}

	public void setTrsEmployeeLicenseDAO(TrsEmployeeLicenseDAO trsEmployeeLicenseDAO) {
		this.trsEmployeeLicenseDAO = trsEmployeeLicenseDAO;
	}

	public void setTrsEmployeeDependentDAO(TrsEmployeeDependentDAO trsEmployeeDependentDAO) {
		this.trsEmployeeDependentDAO = trsEmployeeDependentDAO;
	}

	public void setTrsEmployeeMembershipDAO(TrsEmployeeMembershipDAO trsEmployeeMembershipDAO) {
		this.trsEmployeeMembershipDAO = trsEmployeeMembershipDAO;
	}
}
