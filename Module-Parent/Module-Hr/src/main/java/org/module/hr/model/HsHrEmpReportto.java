/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_reportto", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpReportto.findAll", query = "SELECT h FROM HsHrEmpReportto h"),
    @NamedQuery(name = "HsHrEmpReportto.findByErepSupEmpNumber", query = "SELECT h FROM HsHrEmpReportto h WHERE h.hsHrEmpReporttoPK.erepSupEmpNumber = :erepSupEmpNumber"),
    @NamedQuery(name = "HsHrEmpReportto.findByErepSubEmpNumber", query = "SELECT h FROM HsHrEmpReportto h WHERE h.hsHrEmpReporttoPK.erepSubEmpNumber = :erepSubEmpNumber"),
    @NamedQuery(name = "HsHrEmpReportto.findByErepReportingMode", query = "SELECT h FROM HsHrEmpReportto h WHERE h.hsHrEmpReporttoPK.erepReportingMode = :erepReportingMode")})
public class HsHrEmpReportto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpReporttoPK hsHrEmpReporttoPK;
    @JoinColumn(name = "erep_sup_emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;
    @JoinColumn(name = "erep_sub_emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee1;
    @JoinColumn(name = "erep_reporting_mode", referencedColumnName = "reporting_method_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmEmpReportingMethod ohrmEmpReportingMethod;

    public HsHrEmpReportto() {
    }

    public HsHrEmpReportto(HsHrEmpReporttoPK hsHrEmpReporttoPK) {
        this.hsHrEmpReporttoPK = hsHrEmpReporttoPK;
    }

    public HsHrEmpReportto(int erepSupEmpNumber, int erepSubEmpNumber, int erepReportingMode) {
        this.hsHrEmpReporttoPK = new HsHrEmpReporttoPK(erepSupEmpNumber, erepSubEmpNumber, erepReportingMode);
    }

    public HsHrEmpReporttoPK getHsHrEmpReporttoPK() {
        return hsHrEmpReporttoPK;
    }

    public void setHsHrEmpReporttoPK(HsHrEmpReporttoPK hsHrEmpReporttoPK) {
        this.hsHrEmpReporttoPK = hsHrEmpReporttoPK;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    public HsHrEmployee getHsHrEmployee1() {
        return hsHrEmployee1;
    }

    public void setHsHrEmployee1(HsHrEmployee hsHrEmployee1) {
        this.hsHrEmployee1 = hsHrEmployee1;
    }

    public OhrmEmpReportingMethod getOhrmEmpReportingMethod() {
        return ohrmEmpReportingMethod;
    }

    public void setOhrmEmpReportingMethod(OhrmEmpReportingMethod ohrmEmpReportingMethod) {
        this.ohrmEmpReportingMethod = ohrmEmpReportingMethod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsHrEmpReporttoPK != null ? hsHrEmpReporttoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpReportto)) {
            return false;
        }
        HsHrEmpReportto other = (HsHrEmpReportto) object;
        if ((this.hsHrEmpReporttoPK == null && other.hsHrEmpReporttoPK != null) || (this.hsHrEmpReporttoPK != null && !this.hsHrEmpReporttoPK.equals(other.hsHrEmpReporttoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpReportto[ hsHrEmpReporttoPK=" + hsHrEmpReporttoPK + " ]";
    }
    
}
