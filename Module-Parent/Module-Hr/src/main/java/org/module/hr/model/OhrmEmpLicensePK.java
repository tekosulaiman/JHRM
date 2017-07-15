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
public class OhrmEmpLicensePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "license_id")
    private int licenseId;

    public OhrmEmpLicensePK() {
    }

    public OhrmEmpLicensePK(int empNumber, int licenseId) {
        this.empNumber = empNumber;
        this.licenseId = licenseId;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public int getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(int licenseId) {
        this.licenseId = licenseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) licenseId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmEmpLicensePK)) {
            return false;
        }
        OhrmEmpLicensePK other = (OhrmEmpLicensePK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.licenseId != other.licenseId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmpLicensePK[ empNumber=" + empNumber + ", licenseId=" + licenseId + " ]";
    }
    
}
