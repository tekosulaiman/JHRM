/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "hs_hr_currency_type", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrCurrencyType.findAll", query = "SELECT h FROM HsHrCurrencyType h"),
    @NamedQuery(name = "HsHrCurrencyType.findByCode", query = "SELECT h FROM HsHrCurrencyType h WHERE h.code = :code"),
    @NamedQuery(name = "HsHrCurrencyType.findByCurrencyId", query = "SELECT h FROM HsHrCurrencyType h WHERE h.currencyId = :currencyId"),
    @NamedQuery(name = "HsHrCurrencyType.findByCurrencyName", query = "SELECT h FROM HsHrCurrencyType h WHERE h.currencyName = :currencyName")})
public class HsHrCurrencyType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "code")
    private int code;
    @Id
    @Basic(optional = false)
    @Column(name = "currency_id")
    private String currencyId;
    @Basic(optional = false)
    @Column(name = "currency_name")
    private String currencyName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private List<HsHrEmpBasicsalary> hsHrEmpBasicsalaryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hsHrCurrencyType")
    private List<OhrmPayGradeCurrency> ohrmPayGradeCurrencyList;

    public HsHrCurrencyType() {
    }

    public HsHrCurrencyType(String currencyId) {
        this.currencyId = currencyId;
    }

    public HsHrCurrencyType(String currencyId, int code, String currencyName) {
        this.currencyId = currencyId;
        this.code = code;
        this.currencyName = currencyName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @XmlTransient
    public List<HsHrEmpBasicsalary> getHsHrEmpBasicsalaryList() {
        return hsHrEmpBasicsalaryList;
    }

    public void setHsHrEmpBasicsalaryList(List<HsHrEmpBasicsalary> hsHrEmpBasicsalaryList) {
        this.hsHrEmpBasicsalaryList = hsHrEmpBasicsalaryList;
    }

    @XmlTransient
    public List<OhrmPayGradeCurrency> getOhrmPayGradeCurrencyList() {
        return ohrmPayGradeCurrencyList;
    }

    public void setOhrmPayGradeCurrencyList(List<OhrmPayGradeCurrency> ohrmPayGradeCurrencyList) {
        this.ohrmPayGradeCurrencyList = ohrmPayGradeCurrencyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyId != null ? currencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrCurrencyType)) {
            return false;
        }
        HsHrCurrencyType other = (HsHrCurrencyType) object;
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrCurrencyType[ currencyId=" + currencyId + " ]";
    }
    
}
