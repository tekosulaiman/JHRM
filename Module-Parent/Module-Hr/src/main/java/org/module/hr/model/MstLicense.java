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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "mst_license", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstLicense.findAll", query = "SELECT m FROM MstLicense m"),
    @NamedQuery(name = "MstLicense.findByIdLicense", query = "SELECT m FROM MstLicense m WHERE m.idLicense = :idLicense"),
    @NamedQuery(name = "MstLicense.findByNameLicense", query = "SELECT m FROM MstLicense m WHERE m.nameLicense = :nameLicense")})
public class MstLicense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstLicense_idLicense_GENERATOR", sequenceName="SCHEMA_HR.MstLicense_idLicense_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstLicense_idLicense_GENERATOR")
    @Column(name = "id_license")
    private Integer idLicense;
    @Column(name = "name_license")
    private String nameLicense;
    @OneToMany(mappedBy = "idLicense")
    private List<TrsEmployeeLicense> trsEmployeeLicenseList;

    public MstLicense() {
    }

    public MstLicense(Integer idLicense) {
        this.idLicense = idLicense;
    }

    public Integer getIdLicense() {
        return idLicense;
    }

    public void setIdLicense(Integer idLicense) {
        this.idLicense = idLicense;
    }

    public String getNameLicense() {
        return nameLicense;
    }

    public void setNameLicense(String nameLicense) {
        this.nameLicense = nameLicense;
    }

    @XmlTransient
    public List<TrsEmployeeLicense> getTrsEmployeeLicenseList() {
        return trsEmployeeLicenseList;
    }

    public void setTrsEmployeeLicenseList(List<TrsEmployeeLicense> trsEmployeeLicenseList) {
        this.trsEmployeeLicenseList = trsEmployeeLicenseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicense != null ? idLicense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstLicense)) {
            return false;
        }
        MstLicense other = (MstLicense) object;
        if ((this.idLicense == null && other.idLicense != null) || (this.idLicense != null && !this.idLicense.equals(other.idLicense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstLicense[ idLicense=" + idLicense + " ]";
    }
    
}
