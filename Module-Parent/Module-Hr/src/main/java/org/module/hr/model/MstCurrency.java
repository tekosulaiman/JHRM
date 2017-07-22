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
@Table(name = "mst_currency", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstCurrency.findAll", query = "SELECT m FROM MstCurrency m"),
    @NamedQuery(name = "MstCurrency.findByIdCurrency", query = "SELECT m FROM MstCurrency m WHERE m.idCurrency = :idCurrency"),
    @NamedQuery(name = "MstCurrency.findByCurrencyName", query = "SELECT m FROM MstCurrency m WHERE m.currencyName = :currencyName")})
public class MstCurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_currency")
    private String idCurrency;
    @Column(name = "currency_name")
    private String currencyName;
    @OneToMany(mappedBy = "idCurrency")
    private List<MstPaygradeCurrency> mstPaygradeCurrencyList;

    public MstCurrency() {
    }

    public MstCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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
        hash += (idCurrency != null ? idCurrency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstCurrency)) {
            return false;
        }
        MstCurrency other = (MstCurrency) object;
        if ((this.idCurrency == null && other.idCurrency != null) || (this.idCurrency != null && !this.idCurrency.equals(other.idCurrency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstCurrency[ idCurrency=" + idCurrency + " ]";
    }
    
}
