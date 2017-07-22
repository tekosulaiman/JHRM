/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "mst_paygrade_currency", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstPaygradeCurrency.findAll", query = "SELECT m FROM MstPaygradeCurrency m"),
    @NamedQuery(name = "MstPaygradeCurrency.findByIdPaygradeCurrency", query = "SELECT m FROM MstPaygradeCurrency m WHERE m.idPaygradeCurrency = :idPaygradeCurrency"),
    @NamedQuery(name = "MstPaygradeCurrency.findByMinSalary", query = "SELECT m FROM MstPaygradeCurrency m WHERE m.minSalary = :minSalary"),
    @NamedQuery(name = "MstPaygradeCurrency.findByMaxSalary", query = "SELECT m FROM MstPaygradeCurrency m WHERE m.maxSalary = :maxSalary")})
public class MstPaygradeCurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_paygrade_currency")
    private Integer idPaygradeCurrency;
    @Column(name = "min_salary")
    private BigInteger minSalary;
    @Column(name = "max_salary")
    private BigInteger maxSalary;
    @JoinColumn(name = "id_currency", referencedColumnName = "id_currency")
    @ManyToOne
    private MstCurrency idCurrency;
    @JoinColumn(name = "id_paygrade", referencedColumnName = "id_paygrade")
    @ManyToOne
    private MstPaygrade idPaygrade;

    public MstPaygradeCurrency() {
    }

    public MstPaygradeCurrency(Integer idPaygradeCurrency) {
        this.idPaygradeCurrency = idPaygradeCurrency;
    }

    public Integer getIdPaygradeCurrency() {
        return idPaygradeCurrency;
    }

    public void setIdPaygradeCurrency(Integer idPaygradeCurrency) {
        this.idPaygradeCurrency = idPaygradeCurrency;
    }

    public BigInteger getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigInteger minSalary) {
        this.minSalary = minSalary;
    }

    public BigInteger getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigInteger maxSalary) {
        this.maxSalary = maxSalary;
    }

    public MstCurrency getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(MstCurrency idCurrency) {
        this.idCurrency = idCurrency;
    }

    public MstPaygrade getIdPaygrade() {
        return idPaygrade;
    }

    public void setIdPaygrade(MstPaygrade idPaygrade) {
        this.idPaygrade = idPaygrade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaygradeCurrency != null ? idPaygradeCurrency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstPaygradeCurrency)) {
            return false;
        }
        MstPaygradeCurrency other = (MstPaygradeCurrency) object;
        if ((this.idPaygradeCurrency == null && other.idPaygradeCurrency != null) || (this.idPaygradeCurrency != null && !this.idPaygradeCurrency.equals(other.idPaygradeCurrency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstPaygradeCurrency[ idPaygradeCurrency=" + idPaygradeCurrency + " ]";
    }
    
}
