/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Tom
 */
@Embeddable
public class HsHrEmpReporttoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "erep_sup_emp_number")
    private int erepSupEmpNumber;
    @Basic(optional = false)
    @Column(name = "erep_sub_emp_number")
    private int erepSubEmpNumber;
    @Basic(optional = false)
    @Column(name = "erep_reporting_mode")
    private int erepReportingMode;

    public HsHrEmpReporttoPK() {
    }

    public HsHrEmpReporttoPK(int erepSupEmpNumber, int erepSubEmpNumber, int erepReportingMode) {
        this.erepSupEmpNumber = erepSupEmpNumber;
        this.erepSubEmpNumber = erepSubEmpNumber;
        this.erepReportingMode = erepReportingMode;
    }

    public int getErepSupEmpNumber() {
        return erepSupEmpNumber;
    }

    public void setErepSupEmpNumber(int erepSupEmpNumber) {
        this.erepSupEmpNumber = erepSupEmpNumber;
    }

    public int getErepSubEmpNumber() {
        return erepSubEmpNumber;
    }

    public void setErepSubEmpNumber(int erepSubEmpNumber) {
        this.erepSubEmpNumber = erepSubEmpNumber;
    }

    public int getErepReportingMode() {
        return erepReportingMode;
    }

    public void setErepReportingMode(int erepReportingMode) {
        this.erepReportingMode = erepReportingMode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) erepSupEmpNumber;
        hash += (int) erepSubEmpNumber;
        hash += (int) erepReportingMode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpReporttoPK)) {
            return false;
        }
        HsHrEmpReporttoPK other = (HsHrEmpReporttoPK) object;
        if (this.erepSupEmpNumber != other.erepSupEmpNumber) {
            return false;
        }
        if (this.erepSubEmpNumber != other.erepSubEmpNumber) {
            return false;
        }
        if (this.erepReportingMode != other.erepReportingMode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpReporttoPK[ erepSupEmpNumber=" + erepSupEmpNumber + ", erepSubEmpNumber=" + erepSubEmpNumber + ", erepReportingMode=" + erepReportingMode + " ]";
    }
    
}
