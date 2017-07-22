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
@Table(name = "mst_paygrade", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstPaygrade.findAll", query = "SELECT m FROM MstPaygrade m"),
    @NamedQuery(name = "MstPaygrade.findByIdPaygrade", query = "SELECT m FROM MstPaygrade m WHERE m.idPaygrade = :idPaygrade"),
    @NamedQuery(name = "MstPaygrade.findByPaygradeName", query = "SELECT m FROM MstPaygrade m WHERE m.paygradeName = :paygradeName")})
public class MstPaygrade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_paygrade")
    private Integer idPaygrade;
    @Column(name = "paygrade_name")
    private String paygradeName;
    @OneToMany(mappedBy = "idPaygrade")
    private List<MstPaygradeCurrency> mstPaygradeCurrencyList;

    public MstPaygrade() {
    }

    public MstPaygrade(Integer idPaygrade) {
        this.idPaygrade = idPaygrade;
    }

    public Integer getIdPaygrade() {
        return idPaygrade;
    }

    public void setIdPaygrade(Integer idPaygrade) {
        this.idPaygrade = idPaygrade;
    }

    public String getPaygradeName() {
        return paygradeName;
    }

    public void setPaygradeName(String paygradeName) {
        this.paygradeName = paygradeName;
    }

    @XmlTransient
    public List<MstPaygradeCurrency> getMstPaygradeCurrencyList() {
        return mstPaygradeCurrencyList;
    }

    public void setMstPaygradeCurrencyList(List<MstPaygradeCurrency> mstPaygradeCurrencyList) {
        this.mstPaygradeCurrencyList = mstPaygradeCurrencyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaygrade != null ? idPaygrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstPaygrade)) {
            return false;
        }
        MstPaygrade other = (MstPaygrade) object;
        if ((this.idPaygrade == null && other.idPaygrade != null) || (this.idPaygrade != null && !this.idPaygrade.equals(other.idPaygrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstPaygrade[ idPaygrade=" + idPaygrade + " ]";
    }
    
}
