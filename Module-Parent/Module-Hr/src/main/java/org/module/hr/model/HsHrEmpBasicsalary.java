/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "hs_hr_emp_basicsalary", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpBasicsalary.findAll", query = "SELECT h FROM HsHrEmpBasicsalary h"),
    @NamedQuery(name = "HsHrEmpBasicsalary.findById", query = "SELECT h FROM HsHrEmpBasicsalary h WHERE h.id = :id"),
    @NamedQuery(name = "HsHrEmpBasicsalary.findByEbsalBasicSalary", query = "SELECT h FROM HsHrEmpBasicsalary h WHERE h.ebsalBasicSalary = :ebsalBasicSalary"),
    @NamedQuery(name = "HsHrEmpBasicsalary.findBySalaryComponent", query = "SELECT h FROM HsHrEmpBasicsalary h WHERE h.salaryComponent = :salaryComponent"),
    @NamedQuery(name = "HsHrEmpBasicsalary.findByComments", query = "SELECT h FROM HsHrEmpBasicsalary h WHERE h.comments = :comments")})
public class HsHrEmpBasicsalary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ebsal_basic_salary")
    private String ebsalBasicSalary;
    @Column(name = "salary_component")
    private String salaryComponent;
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "sal_grd_code", referencedColumnName = "id")
    @ManyToOne
    private OhrmPayGrade salGrdCode;
    @JoinColumn(name = "currency_id", referencedColumnName = "currency_id")
    @ManyToOne(optional = false)
    private HsHrCurrencyType currencyId;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")
    @ManyToOne(optional = false)
    private HsHrEmployee empNumber;
    @JoinColumn(name = "payperiod_code", referencedColumnName = "payperiod_code")
    @ManyToOne
    private HsHrPayperiod_1 payperiodCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaryId")
    private List<HsHrEmpDirectdebit> hsHrEmpDirectdebitList;

    public HsHrEmpBasicsalary() {
    }

    public HsHrEmpBasicsalary(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEbsalBasicSalary() {
        return ebsalBasicSalary;
    }

    public void setEbsalBasicSalary(String ebsalBasicSalary) {
        this.ebsalBasicSalary = ebsalBasicSalary;
    }

    public String getSalaryComponent() {
        return salaryComponent;
    }

    public void setSalaryComponent(String salaryComponent) {
        this.salaryComponent = salaryComponent;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public OhrmPayGrade getSalGrdCode() {
        return salGrdCode;
    }

    public void setSalGrdCode(OhrmPayGrade salGrdCode) {
        this.salGrdCode = salGrdCode;
    }

    public HsHrCurrencyType getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(HsHrCurrencyType currencyId) {
        this.currencyId = currencyId;
    }

    public HsHrEmployee getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(HsHrEmployee empNumber) {
        this.empNumber = empNumber;
    }

    public HsHrPayperiod_1 getPayperiodCode() {
        return payperiodCode;
    }

    public void setPayperiodCode(HsHrPayperiod_1 payperiodCode) {
        this.payperiodCode = payperiodCode;
    }

    @XmlTransient
    public List<HsHrEmpDirectdebit> getHsHrEmpDirectdebitList() {
        return hsHrEmpDirectdebitList;
    }

    public void setHsHrEmpDirectdebitList(List<HsHrEmpDirectdebit> hsHrEmpDirectdebitList) {
        this.hsHrEmpDirectdebitList = hsHrEmpDirectdebitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpBasicsalary)) {
            return false;
        }
        HsHrEmpBasicsalary other = (HsHrEmpBasicsalary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpBasicsalary[ id=" + id + " ]";
    }
    
}
