/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_us_tax", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpUsTax.findAll", query = "SELECT h FROM HsHrEmpUsTax h"),
    @NamedQuery(name = "HsHrEmpUsTax.findByEmpNumber", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpUsTax.findByTaxFederalStatus", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.taxFederalStatus = :taxFederalStatus"),
    @NamedQuery(name = "HsHrEmpUsTax.findByTaxFederalExceptions", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.taxFederalExceptions = :taxFederalExceptions"),
    @NamedQuery(name = "HsHrEmpUsTax.findByTaxState", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.taxState = :taxState"),
    @NamedQuery(name = "HsHrEmpUsTax.findByTaxStateStatus", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.taxStateStatus = :taxStateStatus"),
    @NamedQuery(name = "HsHrEmpUsTax.findByTaxStateExceptions", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.taxStateExceptions = :taxStateExceptions"),
    @NamedQuery(name = "HsHrEmpUsTax.findByTaxUnempState", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.taxUnempState = :taxUnempState"),
    @NamedQuery(name = "HsHrEmpUsTax.findByTaxWorkState", query = "SELECT h FROM HsHrEmpUsTax h WHERE h.taxWorkState = :taxWorkState")})
public class HsHrEmpUsTax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emp_number")
    private Integer empNumber;
    @Column(name = "tax_federal_status")
    private String taxFederalStatus;
    @Column(name = "tax_federal_exceptions")
    private Integer taxFederalExceptions;
    @Column(name = "tax_state")
    private String taxState;
    @Column(name = "tax_state_status")
    private String taxStateStatus;
    @Column(name = "tax_state_exceptions")
    private Integer taxStateExceptions;
    @Column(name = "tax_unemp_state")
    private String taxUnempState;
    @Column(name = "tax_work_state")
    private String taxWorkState;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpUsTax() {
    }

    public HsHrEmpUsTax(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public String getTaxFederalStatus() {
        return taxFederalStatus;
    }

    public void setTaxFederalStatus(String taxFederalStatus) {
        this.taxFederalStatus = taxFederalStatus;
    }

    public Integer getTaxFederalExceptions() {
        return taxFederalExceptions;
    }

    public void setTaxFederalExceptions(Integer taxFederalExceptions) {
        this.taxFederalExceptions = taxFederalExceptions;
    }

    public String getTaxState() {
        return taxState;
    }

    public void setTaxState(String taxState) {
        this.taxState = taxState;
    }

    public String getTaxStateStatus() {
        return taxStateStatus;
    }

    public void setTaxStateStatus(String taxStateStatus) {
        this.taxStateStatus = taxStateStatus;
    }

    public Integer getTaxStateExceptions() {
        return taxStateExceptions;
    }

    public void setTaxStateExceptions(Integer taxStateExceptions) {
        this.taxStateExceptions = taxStateExceptions;
    }

    public String getTaxUnempState() {
        return taxUnempState;
    }

    public void setTaxUnempState(String taxUnempState) {
        this.taxUnempState = taxUnempState;
    }

    public String getTaxWorkState() {
        return taxWorkState;
    }

    public void setTaxWorkState(String taxWorkState) {
        this.taxWorkState = taxWorkState;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empNumber != null ? empNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpUsTax)) {
            return false;
        }
        HsHrEmpUsTax other = (HsHrEmpUsTax) object;
        if ((this.empNumber == null && other.empNumber != null) || (this.empNumber != null && !this.empNumber.equals(other.empNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpUsTax[ empNumber=" + empNumber + " ]";
    }
    
}
