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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_district", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrDistrict.findAll", query = "SELECT h FROM HsHrDistrict h"),
    @NamedQuery(name = "HsHrDistrict.findByDistrictCode", query = "SELECT h FROM HsHrDistrict h WHERE h.districtCode = :districtCode"),
    @NamedQuery(name = "HsHrDistrict.findByDistrictName", query = "SELECT h FROM HsHrDistrict h WHERE h.districtName = :districtName"),
    @NamedQuery(name = "HsHrDistrict.findByProvinceCode", query = "SELECT h FROM HsHrDistrict h WHERE h.provinceCode = :provinceCode")})
public class HsHrDistrict implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "district_code")
    private String districtCode;
    @Column(name = "district_name")
    private String districtName;
    @Column(name = "province_code")
    private String provinceCode;

    public HsHrDistrict() {
    }

    public HsHrDistrict(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtCode != null ? districtCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrDistrict)) {
            return false;
        }
        HsHrDistrict other = (HsHrDistrict) object;
        if ((this.districtCode == null && other.districtCode != null) || (this.districtCode != null && !this.districtCode.equals(other.districtCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrDistrict[ districtCode=" + districtCode + " ]";
    }
    
}
