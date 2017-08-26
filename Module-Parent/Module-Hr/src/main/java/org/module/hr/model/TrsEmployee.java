/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "trs_employee", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployee.findAll", query = "SELECT t FROM TrsEmployee t"),
    @NamedQuery(name = "TrsEmployee.findByIdEmployee", query = "SELECT t FROM TrsEmployee t WHERE t.idEmployee = :idEmployee")})
public class TrsEmployee implements Serializable {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsJobVacancy> trsJobVacancyList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_employee")
    private String idEmployee;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeMembership> trsEmployeeMembershipList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeDependent> trsEmployeeDependentList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeExprience> trsEmployeeExprienceList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeLanguage> trsEmployeeLanguageList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeEducation> trsEmployeeEducationList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeLicense> trsEmployeeLicenseList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeEmergencyContact> trsEmployeeEmergencyContactList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeSkill> trsEmployeeSkillList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeImmigration> trsEmployeeImmigrationList;
    @OneToMany(mappedBy = "idEmployee")
    private List<TrsEmployeeSalary> trsEmployeeSalaryList;

    public TrsEmployee() {
    }

    public TrsEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @XmlTransient
    public List<TrsEmployeeMembership> getTrsEmployeeMembershipList() {
        return trsEmployeeMembershipList;
    }

    public void setTrsEmployeeMembershipList(List<TrsEmployeeMembership> trsEmployeeMembershipList) {
        this.trsEmployeeMembershipList = trsEmployeeMembershipList;
    }

    @XmlTransient
    public List<TrsEmployeeDependent> getTrsEmployeeDependentList() {
        return trsEmployeeDependentList;
    }

    public void setTrsEmployeeDependentList(List<TrsEmployeeDependent> trsEmployeeDependentList) {
        this.trsEmployeeDependentList = trsEmployeeDependentList;
    }

    @XmlTransient
    public List<TrsEmployeeExprience> getTrsEmployeeExprienceList() {
        return trsEmployeeExprienceList;
    }

    public void setTrsEmployeeExprienceList(List<TrsEmployeeExprience> trsEmployeeExprienceList) {
        this.trsEmployeeExprienceList = trsEmployeeExprienceList;
    }

    @XmlTransient
    public List<TrsEmployeeLanguage> getTrsEmployeeLanguageList() {
        return trsEmployeeLanguageList;
    }

    public void setTrsEmployeeLanguageList(List<TrsEmployeeLanguage> trsEmployeeLanguageList) {
        this.trsEmployeeLanguageList = trsEmployeeLanguageList;
    }

    @XmlTransient
    public List<TrsEmployeeEducation> getTrsEmployeeEducationList() {
        return trsEmployeeEducationList;
    }

    public void setTrsEmployeeEducationList(List<TrsEmployeeEducation> trsEmployeeEducationList) {
        this.trsEmployeeEducationList = trsEmployeeEducationList;
    }

    @XmlTransient
    public List<TrsEmployeeLicense> getTrsEmployeeLicenseList() {
        return trsEmployeeLicenseList;
    }

    public void setTrsEmployeeLicenseList(List<TrsEmployeeLicense> trsEmployeeLicenseList) {
        this.trsEmployeeLicenseList = trsEmployeeLicenseList;
    }

    @XmlTransient
    public List<TrsEmployeeEmergencyContact> getTrsEmployeeEmergencyContactList() {
        return trsEmployeeEmergencyContactList;
    }

    public void setTrsEmployeeEmergencyContactList(List<TrsEmployeeEmergencyContact> trsEmployeeEmergencyContactList) {
        this.trsEmployeeEmergencyContactList = trsEmployeeEmergencyContactList;
    }

    @XmlTransient
    public List<TrsEmployeeSkill> getTrsEmployeeSkillList() {
        return trsEmployeeSkillList;
    }

    public void setTrsEmployeeSkillList(List<TrsEmployeeSkill> trsEmployeeSkillList) {
        this.trsEmployeeSkillList = trsEmployeeSkillList;
    }

    @XmlTransient
    public List<TrsEmployeeImmigration> getTrsEmployeeImmigrationList() {
        return trsEmployeeImmigrationList;
    }

    public void setTrsEmployeeImmigrationList(List<TrsEmployeeImmigration> trsEmployeeImmigrationList) {
        this.trsEmployeeImmigrationList = trsEmployeeImmigrationList;
    }

    @XmlTransient
    public List<TrsEmployeeSalary> getTrsEmployeeSalaryList() {
        return trsEmployeeSalaryList;
    }

    public void setTrsEmployeeSalaryList(List<TrsEmployeeSalary> trsEmployeeSalaryList) {
        this.trsEmployeeSalaryList = trsEmployeeSalaryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployee != null ? idEmployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployee)) {
            return false;
        }
        TrsEmployee other = (TrsEmployee) object;
        if ((this.idEmployee == null && other.idEmployee != null) || (this.idEmployee != null && !this.idEmployee.equals(other.idEmployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployee[ idEmployee=" + idEmployee + " ]";
    }

    @XmlTransient
    public List<TrsJobVacancy> getTrsJobVacancyList() {
        return trsJobVacancyList;
    }

    public void setTrsJobVacancyList(List<TrsJobVacancy> trsJobVacancyList) {
        this.trsJobVacancyList = trsJobVacancyList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
