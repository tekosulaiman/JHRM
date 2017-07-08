package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmployee.findAll", query = "SELECT h FROM HsHrEmployee h"),
    @NamedQuery(name = "HsHrEmployee.findByEmpNumber", query = "SELECT h FROM HsHrEmployee h WHERE h.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmployee.findByEmployeeId", query = "SELECT h FROM HsHrEmployee h WHERE h.employeeId = :employeeId"),
    @NamedQuery(name = "HsHrEmployee.findByEmpLastname", query = "SELECT h FROM HsHrEmployee h WHERE h.empLastname = :empLastname"),
    @NamedQuery(name = "HsHrEmployee.findByEmpFirstname", query = "SELECT h FROM HsHrEmployee h WHERE h.empFirstname = :empFirstname"),
    @NamedQuery(name = "HsHrEmployee.findByEmpMiddleName", query = "SELECT h FROM HsHrEmployee h WHERE h.empMiddleName = :empMiddleName"),
    @NamedQuery(name = "HsHrEmployee.findByEmpNickName", query = "SELECT h FROM HsHrEmployee h WHERE h.empNickName = :empNickName"),
    @NamedQuery(name = "HsHrEmployee.findByEmpSmoker", query = "SELECT h FROM HsHrEmployee h WHERE h.empSmoker = :empSmoker"),
    @NamedQuery(name = "HsHrEmployee.findByEthnicRaceCode", query = "SELECT h FROM HsHrEmployee h WHERE h.ethnicRaceCode = :ethnicRaceCode"),
    @NamedQuery(name = "HsHrEmployee.findByEmpBirthday", query = "SELECT h FROM HsHrEmployee h WHERE h.empBirthday = :empBirthday"),
    @NamedQuery(name = "HsHrEmployee.findByEmpGender", query = "SELECT h FROM HsHrEmployee h WHERE h.empGender = :empGender"),
    @NamedQuery(name = "HsHrEmployee.findByEmpMaritalStatus", query = "SELECT h FROM HsHrEmployee h WHERE h.empMaritalStatus = :empMaritalStatus"),
    @NamedQuery(name = "HsHrEmployee.findByEmpSsnNum", query = "SELECT h FROM HsHrEmployee h WHERE h.empSsnNum = :empSsnNum"),
    @NamedQuery(name = "HsHrEmployee.findByEmpSinNum", query = "SELECT h FROM HsHrEmployee h WHERE h.empSinNum = :empSinNum"),
    @NamedQuery(name = "HsHrEmployee.findByEmpOtherId", query = "SELECT h FROM HsHrEmployee h WHERE h.empOtherId = :empOtherId"),
    @NamedQuery(name = "HsHrEmployee.findByEmpDriLiceNum", query = "SELECT h FROM HsHrEmployee h WHERE h.empDriLiceNum = :empDriLiceNum"),
    @NamedQuery(name = "HsHrEmployee.findByEmpDriLiceExpDate", query = "SELECT h FROM HsHrEmployee h WHERE h.empDriLiceExpDate = :empDriLiceExpDate"),
    @NamedQuery(name = "HsHrEmployee.findByEmpMilitaryService", query = "SELECT h FROM HsHrEmployee h WHERE h.empMilitaryService = :empMilitaryService"),
    @NamedQuery(name = "HsHrEmployee.findByEmpStreet1", query = "SELECT h FROM HsHrEmployee h WHERE h.empStreet1 = :empStreet1"),
    @NamedQuery(name = "HsHrEmployee.findByEmpStreet2", query = "SELECT h FROM HsHrEmployee h WHERE h.empStreet2 = :empStreet2"),
    @NamedQuery(name = "HsHrEmployee.findByCityCode", query = "SELECT h FROM HsHrEmployee h WHERE h.cityCode = :cityCode"),
    @NamedQuery(name = "HsHrEmployee.findByCounCode", query = "SELECT h FROM HsHrEmployee h WHERE h.counCode = :counCode"),
    @NamedQuery(name = "HsHrEmployee.findByProvinCode", query = "SELECT h FROM HsHrEmployee h WHERE h.provinCode = :provinCode"),
    @NamedQuery(name = "HsHrEmployee.findByEmpZipcode", query = "SELECT h FROM HsHrEmployee h WHERE h.empZipcode = :empZipcode"),
    @NamedQuery(name = "HsHrEmployee.findByEmpHmTelephone", query = "SELECT h FROM HsHrEmployee h WHERE h.empHmTelephone = :empHmTelephone"),
    @NamedQuery(name = "HsHrEmployee.findByEmpMobile", query = "SELECT h FROM HsHrEmployee h WHERE h.empMobile = :empMobile"),
    @NamedQuery(name = "HsHrEmployee.findByEmpWorkTelephone", query = "SELECT h FROM HsHrEmployee h WHERE h.empWorkTelephone = :empWorkTelephone"),
    @NamedQuery(name = "HsHrEmployee.findByEmpWorkEmail", query = "SELECT h FROM HsHrEmployee h WHERE h.empWorkEmail = :empWorkEmail"),
    @NamedQuery(name = "HsHrEmployee.findBySalGrdCode", query = "SELECT h FROM HsHrEmployee h WHERE h.salGrdCode = :salGrdCode"),
    @NamedQuery(name = "HsHrEmployee.findByJoinedDate", query = "SELECT h FROM HsHrEmployee h WHERE h.joinedDate = :joinedDate"),
    @NamedQuery(name = "HsHrEmployee.findByEmpOthEmail", query = "SELECT h FROM HsHrEmployee h WHERE h.empOthEmail = :empOthEmail"),
    @NamedQuery(name = "HsHrEmployee.findByCustom1", query = "SELECT h FROM HsHrEmployee h WHERE h.custom1 = :custom1"),
    @NamedQuery(name = "HsHrEmployee.findByCustom2", query = "SELECT h FROM HsHrEmployee h WHERE h.custom2 = :custom2"),
    @NamedQuery(name = "HsHrEmployee.findByCustom3", query = "SELECT h FROM HsHrEmployee h WHERE h.custom3 = :custom3"),
    @NamedQuery(name = "HsHrEmployee.findByCustom4", query = "SELECT h FROM HsHrEmployee h WHERE h.custom4 = :custom4"),
    @NamedQuery(name = "HsHrEmployee.findByCustom5", query = "SELECT h FROM HsHrEmployee h WHERE h.custom5 = :custom5"),
    @NamedQuery(name = "HsHrEmployee.findByCustom6", query = "SELECT h FROM HsHrEmployee h WHERE h.custom6 = :custom6"),
    @NamedQuery(name = "HsHrEmployee.findByCustom7", query = "SELECT h FROM HsHrEmployee h WHERE h.custom7 = :custom7"),
    @NamedQuery(name = "HsHrEmployee.findByCustom8", query = "SELECT h FROM HsHrEmployee h WHERE h.custom8 = :custom8"),
    @NamedQuery(name = "HsHrEmployee.findByCustom9", query = "SELECT h FROM HsHrEmployee h WHERE h.custom9 = :custom9"),
    @NamedQuery(name = "HsHrEmployee.findByCustom10", query = "SELECT h FROM HsHrEmployee h WHERE h.custom10 = :custom10")})
public class HsHrEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "emp_number")
    private Integer empNumber;
    
    @Column(name = "employee_id")
    private String employeeId;
    
    @Basic(optional = false)
    @Column(name = "emp_lastname")
    private String empLastname;
    
    @Basic(optional = false)
    @Column(name = "emp_firstname")
    private String empFirstname;
    
    @Basic(optional = false)
    @Column(name = "emp_middle_name")
    private String empMiddleName;
    
    @Column(name = "emp_nick_name")
    private String empNickName;
    
    @Column(name = "emp_smoker")
    private Short empSmoker;
    
    @Column(name = "ethnic_race_code")
    private String ethnicRaceCode;
    
    @Column(name = "emp_birthday")
    @Temporal(TemporalType.DATE)
    private Date empBirthday;
    
    @Column(name = "emp_gender")
    private Short empGender;
    
    @Column(name = "emp_marital_status")
    private String empMaritalStatus;
    
    @Column(name = "emp_ssn_num")
    private String empSsnNum;
    
    @Column(name = "emp_sin_num")
    private String empSinNum;
    
    @Column(name = "emp_other_id")
    private String empOtherId;
    
    @Column(name = "emp_dri_lice_num")
    private String empDriLiceNum;
    
    @Column(name = "emp_dri_lice_exp_date")
    @Temporal(TemporalType.DATE)
    private Date empDriLiceExpDate;
    
    @Column(name = "emp_military_service")
    private String empMilitaryService;
    
    @Column(name = "emp_street1")
    private String empStreet1;
    
    @Column(name = "emp_street2")
    private String empStreet2;
    
    @Column(name = "city_code")
    private String cityCode;
    
    @Column(name = "coun_code")
    private String counCode;
    
    @Column(name = "provin_code")
    private String provinCode;
    
    @Column(name = "emp_zipcode")
    private String empZipcode;
    
    @Column(name = "emp_hm_telephone")
    private String empHmTelephone;
    
    @Column(name = "emp_mobile")
    private String empMobile;
    
    @Column(name = "emp_work_telephone")
    private String empWorkTelephone;
    
    @Column(name = "emp_work_email")
    private String empWorkEmail;
    
    @Column(name = "sal_grd_code")
    private String salGrdCode;
    
    @Column(name = "joined_date")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    
    @Column(name = "emp_oth_email")
    private String empOthEmail;
    
    @Column(name = "custom1")
    private String custom1;
    
    @Column(name = "custom2")
    private String custom2;
    
    @Column(name = "custom3")
    private String custom3;
    
    @Column(name = "custom4")
    private String custom4;
    
    @Column(name = "custom5")
    private String custom5;
    
    @Column(name = "custom6")
    private String custom6;
    
    @Column(name = "custom7")
    private String custom7;
    
    @Column(name = "custom8")
    private String custom8;
    
    @Column(name = "custom9")
    private String custom9;
    
    @Column(name = "custom10")
    private String custom10;
    
    /*@OneToMany(mappedBy = "empNumber")
    private List<OhrmEmpTermination> ohrmEmpTerminationList;
    
    @JoinColumn(name = "work_station", referencedColumnName = "id")
    @ManyToOne
    private OhrmSubunit workStation;
    
    @JoinColumn(name = "nation_code", referencedColumnName = "id")
    @ManyToOne
    private OhrmNationality nationCode;
    
    @JoinColumn(name = "job_title_code", referencedColumnName = "id")
    @ManyToOne
    private OhrmJobTitle jobTitleCode;
    
    @JoinColumn(name = "emp_status", referencedColumnName = "id")
    @ManyToOne
    private OhrmEmploymentStatus empStatus;
    
    @JoinColumn(name = "eeo_cat_code", referencedColumnName = "id")
    @ManyToOne
    private OhrmJobCategory eeoCatCode;
    
    @JoinColumn(name = "termination_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmEmpTermination terminationId;*/

    public HsHrEmployee() {
    }

    public HsHrEmployee(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public HsHrEmployee(Integer empNumber, String empLastname, String empFirstname, String empMiddleName) {
        this.empNumber = empNumber;
        this.empLastname = empLastname;
        this.empFirstname = empFirstname;
        this.empMiddleName = empMiddleName;
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpLastname() {
        return empLastname;
    }

    public void setEmpLastname(String empLastname) {
        this.empLastname = empLastname;
    }

    public String getEmpFirstname() {
        return empFirstname;
    }

    public void setEmpFirstname(String empFirstname) {
        this.empFirstname = empFirstname;
    }

    public String getEmpMiddleName() {
        return empMiddleName;
    }

    public void setEmpMiddleName(String empMiddleName) {
        this.empMiddleName = empMiddleName;
    }

    public String getEmpNickName() {
        return empNickName;
    }

    public void setEmpNickName(String empNickName) {
        this.empNickName = empNickName;
    }

    public Short getEmpSmoker() {
        return empSmoker;
    }

    public void setEmpSmoker(Short empSmoker) {
        this.empSmoker = empSmoker;
    }

    public String getEthnicRaceCode() {
        return ethnicRaceCode;
    }

    public void setEthnicRaceCode(String ethnicRaceCode) {
        this.ethnicRaceCode = ethnicRaceCode;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public Short getEmpGender() {
        return empGender;
    }

    public void setEmpGender(Short empGender) {
        this.empGender = empGender;
    }

    public String getEmpMaritalStatus() {
        return empMaritalStatus;
    }

    public void setEmpMaritalStatus(String empMaritalStatus) {
        this.empMaritalStatus = empMaritalStatus;
    }

    public String getEmpSsnNum() {
        return empSsnNum;
    }

    public void setEmpSsnNum(String empSsnNum) {
        this.empSsnNum = empSsnNum;
    }

    public String getEmpSinNum() {
        return empSinNum;
    }

    public void setEmpSinNum(String empSinNum) {
        this.empSinNum = empSinNum;
    }

    public String getEmpOtherId() {
        return empOtherId;
    }

    public void setEmpOtherId(String empOtherId) {
        this.empOtherId = empOtherId;
    }

    public String getEmpDriLiceNum() {
        return empDriLiceNum;
    }

    public void setEmpDriLiceNum(String empDriLiceNum) {
        this.empDriLiceNum = empDriLiceNum;
    }

    public Date getEmpDriLiceExpDate() {
        return empDriLiceExpDate;
    }

    public void setEmpDriLiceExpDate(Date empDriLiceExpDate) {
        this.empDriLiceExpDate = empDriLiceExpDate;
    }

    public String getEmpMilitaryService() {
        return empMilitaryService;
    }

    public void setEmpMilitaryService(String empMilitaryService) {
        this.empMilitaryService = empMilitaryService;
    }

    public String getEmpStreet1() {
        return empStreet1;
    }

    public void setEmpStreet1(String empStreet1) {
        this.empStreet1 = empStreet1;
    }

    public String getEmpStreet2() {
        return empStreet2;
    }

    public void setEmpStreet2(String empStreet2) {
        this.empStreet2 = empStreet2;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCounCode() {
        return counCode;
    }

    public void setCounCode(String counCode) {
        this.counCode = counCode;
    }

    public String getProvinCode() {
        return provinCode;
    }

    public void setProvinCode(String provinCode) {
        this.provinCode = provinCode;
    }

    public String getEmpZipcode() {
        return empZipcode;
    }

    public void setEmpZipcode(String empZipcode) {
        this.empZipcode = empZipcode;
    }

    public String getEmpHmTelephone() {
        return empHmTelephone;
    }

    public void setEmpHmTelephone(String empHmTelephone) {
        this.empHmTelephone = empHmTelephone;
    }

    public String getEmpMobile() {
        return empMobile;
    }

    public void setEmpMobile(String empMobile) {
        this.empMobile = empMobile;
    }

    public String getEmpWorkTelephone() {
        return empWorkTelephone;
    }

    public void setEmpWorkTelephone(String empWorkTelephone) {
        this.empWorkTelephone = empWorkTelephone;
    }

    public String getEmpWorkEmail() {
        return empWorkEmail;
    }

    public void setEmpWorkEmail(String empWorkEmail) {
        this.empWorkEmail = empWorkEmail;
    }

    public String getSalGrdCode() {
        return salGrdCode;
    }

    public void setSalGrdCode(String salGrdCode) {
        this.salGrdCode = salGrdCode;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getEmpOthEmail() {
        return empOthEmail;
    }

    public void setEmpOthEmail(String empOthEmail) {
        this.empOthEmail = empOthEmail;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getCustom5() {
        return custom5;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    public String getCustom6() {
        return custom6;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public String getCustom7() {
        return custom7;
    }

    public void setCustom7(String custom7) {
        this.custom7 = custom7;
    }

    public String getCustom8() {
        return custom8;
    }

    public void setCustom8(String custom8) {
        this.custom8 = custom8;
    }

    public String getCustom9() {
        return custom9;
    }

    public void setCustom9(String custom9) {
        this.custom9 = custom9;
    }

    public String getCustom10() {
        return custom10;
    }

    public void setCustom10(String custom10) {
        this.custom10 = custom10;
    }

    /*@XmlTransient
    public List<OhrmEmpTermination> getOhrmEmpTerminationList() {
        return ohrmEmpTerminationList;
    }

    public void setOhrmEmpTerminationList(List<OhrmEmpTermination> ohrmEmpTerminationList) {
        this.ohrmEmpTerminationList = ohrmEmpTerminationList;
    }

    public OhrmSubunit getWorkStation() {
        return workStation;
    }

    public void setWorkStation(OhrmSubunit workStation) {
        this.workStation = workStation;
    }

    public OhrmNationality getNationCode() {
        return nationCode;
    }

    public void setNationCode(OhrmNationality nationCode) {
        this.nationCode = nationCode;
    }

    public OhrmJobTitle getJobTitleCode() {
        return jobTitleCode;
    }

    public void setJobTitleCode(OhrmJobTitle jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
    }

    public OhrmEmploymentStatus getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(OhrmEmploymentStatus empStatus) {
        this.empStatus = empStatus;
    }

    public OhrmJobCategory getEeoCatCode() {
        return eeoCatCode;
    }

    public void setEeoCatCode(OhrmJobCategory eeoCatCode) {
        this.eeoCatCode = eeoCatCode;
    }

    public OhrmEmpTermination getTerminationId() {
        return terminationId;
    }

    public void setTerminationId(OhrmEmpTermination terminationId) {
        this.terminationId = terminationId;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empNumber != null ? empNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmployee)) {
            return false;
        }
        
        HsHrEmployee other = (HsHrEmployee) object;
       
        if ((this.empNumber == null && other.empNumber != null) || (this.empNumber != null && !this.empNumber.equals(other.empNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.id.hr.HsHrEmployee[ empNumber=" + empNumber + " ]";
    }
}