/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ohrm_emp_license", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmpLicense.findAll", query = "SELECT o FROM OhrmEmpLicense o"),
    @NamedQuery(name = "OhrmEmpLicense.findByEmpNumber", query = "SELECT o FROM OhrmEmpLicense o WHERE o.ohrmEmpLicensePK.empNumber = :empNumber"),
    @NamedQuery(name = "OhrmEmpLicense.findByLicenseId", query = "SELECT o FROM OhrmEmpLicense o WHERE o.ohrmEmpLicensePK.licenseId = :licenseId"),
    @NamedQuery(name = "OhrmEmpLicense.findByLicenseNo", query = "SELECT o FROM OhrmEmpLicense o WHERE o.licenseNo = :licenseNo"),
    @NamedQuery(name = "OhrmEmpLicense.findByLicenseIssuedDate", query = "SELECT o FROM OhrmEmpLicense o WHERE o.licenseIssuedDate = :licenseIssuedDate"),
    @NamedQuery(name = "OhrmEmpLicense.findByLicenseExpiryDate", query = "SELECT o FROM OhrmEmpLicense o WHERE o.licenseExpiryDate = :licenseExpiryDate")})
public class OhrmEmpLicense implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmEmpLicensePK ohrmEmpLicensePK;
    @Column(name = "license_no")
    private String licenseNo;
    @Column(name = "license_issued_date")
    @Temporal(TemporalType.DATE)
    private Date licenseIssuedDate;
    @Column(name = "license_expiry_date")
    @Temporal(TemporalType.DATE)
    private Date licenseExpiryDate;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;
    @JoinColumn(name = "license_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmLicense ohrmLicense;

    public OhrmEmpLicense() {
    }

    public OhrmEmpLicense(OhrmEmpLicensePK ohrmEmpLicensePK) {
        this.ohrmEmpLicensePK = ohrmEmpLicensePK;
    }

    public OhrmEmpLicense(int empNumber, int licenseId) {
        this.ohrmEmpLicensePK = new OhrmEmpLicensePK(empNumber, licenseId);
    }

    public OhrmEmpLicensePK getOhrmEmpLicensePK() {
        return ohrmEmpLicensePK;
    }

    public void setOhrmEmpLicensePK(OhrmEmpLicensePK ohrmEmpLicensePK) {
        this.ohrmEmpLicensePK = ohrmEmpLicensePK;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public Date getLicenseIssuedDate() {
        return licenseIssuedDate;
    }

    public void setLicenseIssuedDate(Date licenseIssuedDate) {
        this.licenseIssuedDate = licenseIssuedDate;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    public OhrmLicense getOhrmLicense() {
        return ohrmLicense;
    }

    public void setOhrmLicense(OhrmLicense ohrmLicense) {
        this.ohrmLicense = ohrmLicense;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmEmpLicensePK != null ? ohrmEmpLicensePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmEmpLicense)) {
            return false;
        }
        OhrmEmpLicense other = (OhrmEmpLicense) object;
        if ((this.ohrmEmpLicensePK == null && other.ohrmEmpLicensePK != null) || (this.ohrmEmpLicensePK != null && !this.ohrmEmpLicensePK.equals(other.ohrmEmpLicensePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmpLicense[ ohrmEmpLicensePK=" + ohrmEmpLicensePK + " ]";
    }
    
}
