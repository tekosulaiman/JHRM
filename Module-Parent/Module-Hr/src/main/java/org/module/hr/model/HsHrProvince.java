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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_province", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrProvince.findAll", query = "SELECT h FROM HsHrProvince h"),
    @NamedQuery(name = "HsHrProvince.findById", query = "SELECT h FROM HsHrProvince h WHERE h.id = :id"),
    @NamedQuery(name = "HsHrProvince.findByProvinceName", query = "SELECT h FROM HsHrProvince h WHERE h.provinceName = :provinceName"),
    @NamedQuery(name = "HsHrProvince.findByProvinceCode", query = "SELECT h FROM HsHrProvince h WHERE h.provinceCode = :provinceCode"),
    @NamedQuery(name = "HsHrProvince.findByCouCode", query = "SELECT h FROM HsHrProvince h WHERE h.couCode = :couCode")})
public class HsHrProvince implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "province_name")
    private String provinceName;
    @Basic(optional = false)
    @Column(name = "province_code")
    private String provinceCode;
    @Basic(optional = false)
    @Column(name = "cou_code")
    private String couCode;

    public HsHrProvince() {
    }

    public HsHrProvince(Integer id) {
        this.id = id;
    }

    public HsHrProvince(Integer id, String provinceName, String provinceCode, String couCode) {
        this.id = id;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
        this.couCode = couCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCouCode() {
        return couCode;
    }

    public void setCouCode(String couCode) {
        this.couCode = couCode;
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
        if (!(object instanceof HsHrProvince)) {
            return false;
        }
        HsHrProvince other = (HsHrProvince) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrProvince[ id=" + id + " ]";
    }
    
}
