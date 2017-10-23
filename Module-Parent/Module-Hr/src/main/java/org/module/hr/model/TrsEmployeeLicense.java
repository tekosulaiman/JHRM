/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "trs_employee_license", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeLicense.findAll", query = "SELECT t FROM TrsEmployeeLicense t"),
    @NamedQuery(name = "TrsEmployeeLicense.findByIdEmployeeLicense", query = "SELECT t FROM TrsEmployeeLicense t WHERE t.idEmployeeLicense = :idEmployeeLicense")})
public class TrsEmployeeLicense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeLicense_idEmployeeLicense_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeLicense_idEmployeeLicense_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeLicense_idEmployeeLicense_GENERATOR")
    @Column(name = "id_employee_license")
    private Integer idEmployeeLicense;
    @JoinColumn(name = "id_license", referencedColumnName = "id_license")
    @ManyToOne
    private MstLicense idLicense;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    @Column(name = "license_number")
    private String licenseNumber;
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    

    public TrsEmployeeLicense() {
    }

    public TrsEmployeeLicense(Integer idEmployeeLicense) {
        this.idEmployeeLicense = idEmployeeLicense;
    }

    public Integer getIdEmployeeLicense() {
        return idEmployeeLicense;
    }

    public void setIdEmployeeLicense(Integer idEmployeeLicense) {
        this.idEmployeeLicense = idEmployeeLicense;
    }

    public MstLicense getIdLicense() {
        return idLicense;
    }

    public void setIdLicense(MstLicense idLicense) {
        this.idLicense = idLicense;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployeeLicense != null ? idEmployeeLicense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeLicense)) {
            return false;
        }
        TrsEmployeeLicense other = (TrsEmployeeLicense) object;
        if ((this.idEmployeeLicense == null && other.idEmployeeLicense != null) || (this.idEmployeeLicense != null && !this.idEmployeeLicense.equals(other.idEmployeeLicense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeLicense[ idEmployeeLicense=" + idEmployeeLicense + " ]";
    }
    
}
