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
@Table(name = "hs_hr_payperiod", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrPayperiod_1.findAll", query = "SELECT h FROM HsHrPayperiod_1 h"),
    @NamedQuery(name = "HsHrPayperiod_1.findByPayperiodCode", query = "SELECT h FROM HsHrPayperiod_1 h WHERE h.payperiodCode = :payperiodCode"),
    @NamedQuery(name = "HsHrPayperiod_1.findByPayperiodName", query = "SELECT h FROM HsHrPayperiod_1 h WHERE h.payperiodName = :payperiodName")})
public class HsHrPayperiod_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "payperiod_code")
    private String payperiodCode;
    @Column(name = "payperiod_name")
    private String payperiodName;
    @OneToMany(mappedBy = "payperiodCode")
    private List<HsHrEmpBasicsalary> hsHrEmpBasicsalaryList;

    public HsHrPayperiod_1() {
    }

    public HsHrPayperiod_1(String payperiodCode) {
        this.payperiodCode = payperiodCode;
    }

    public String getPayperiodCode() {
        return payperiodCode;
    }

    public void setPayperiodCode(String payperiodCode) {
        this.payperiodCode = payperiodCode;
    }

    public String getPayperiodName() {
        return payperiodName;
    }

    public void setPayperiodName(String payperiodName) {
        this.payperiodName = payperiodName;
    }

    @XmlTransient
    public List<HsHrEmpBasicsalary> getHsHrEmpBasicsalaryList() {
        return hsHrEmpBasicsalaryList;
    }

    public void setHsHrEmpBasicsalaryList(List<HsHrEmpBasicsalary> hsHrEmpBasicsalaryList) {
        this.hsHrEmpBasicsalaryList = hsHrEmpBasicsalaryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payperiodCode != null ? payperiodCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrPayperiod_1)) {
            return false;
        }
        HsHrPayperiod_1 other = (HsHrPayperiod_1) object;
        if ((this.payperiodCode == null && other.payperiodCode != null) || (this.payperiodCode != null && !this.payperiodCode.equals(other.payperiodCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrPayperiod_1[ payperiodCode=" + payperiodCode + " ]";
    }
    
}
