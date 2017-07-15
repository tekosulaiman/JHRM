/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ohrm_pay_grade_currency", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmPayGradeCurrency.findAll", query = "SELECT o FROM OhrmPayGradeCurrency o"),
    @NamedQuery(name = "OhrmPayGradeCurrency.findByPayGradeId", query = "SELECT o FROM OhrmPayGradeCurrency o WHERE o.ohrmPayGradeCurrencyPK.payGradeId = :payGradeId"),
    @NamedQuery(name = "OhrmPayGradeCurrency.findByCurrencyId", query = "SELECT o FROM OhrmPayGradeCurrency o WHERE o.ohrmPayGradeCurrencyPK.currencyId = :currencyId"),
    @NamedQuery(name = "OhrmPayGradeCurrency.findByMinSalary", query = "SELECT o FROM OhrmPayGradeCurrency o WHERE o.minSalary = :minSalary"),
    @NamedQuery(name = "OhrmPayGradeCurrency.findByMaxSalary", query = "SELECT o FROM OhrmPayGradeCurrency o WHERE o.maxSalary = :maxSalary")})
public class OhrmPayGradeCurrency implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmPayGradeCurrencyPK ohrmPayGradeCurrencyPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "min_salary")
    private Double minSalary;
    @Column(name = "max_salary")
    private Double maxSalary;
    @JoinColumn(name = "currency_id", referencedColumnName = "currency_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrCurrencyType hsHrCurrencyType;
    @JoinColumn(name = "pay_grade_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmPayGrade ohrmPayGrade;

    public OhrmPayGradeCurrency() {
    }

    public OhrmPayGradeCurrency(OhrmPayGradeCurrencyPK ohrmPayGradeCurrencyPK) {
        this.ohrmPayGradeCurrencyPK = ohrmPayGradeCurrencyPK;
    }

    public OhrmPayGradeCurrency(int payGradeId, String currencyId) {
        this.ohrmPayGradeCurrencyPK = new OhrmPayGradeCurrencyPK(payGradeId, currencyId);
    }

    public OhrmPayGradeCurrencyPK getOhrmPayGradeCurrencyPK() {
        return ohrmPayGradeCurrencyPK;
    }

    public void setOhrmPayGradeCurrencyPK(OhrmPayGradeCurrencyPK ohrmPayGradeCurrencyPK) {
        this.ohrmPayGradeCurrencyPK = ohrmPayGradeCurrencyPK;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public HsHrCurrencyType getHsHrCurrencyType() {
        return hsHrCurrencyType;
    }

    public void setHsHrCurrencyType(HsHrCurrencyType hsHrCurrencyType) {
        this.hsHrCurrencyType = hsHrCurrencyType;
    }

    public OhrmPayGrade getOhrmPayGrade() {
        return ohrmPayGrade;
    }

    public void setOhrmPayGrade(OhrmPayGrade ohrmPayGrade) {
        this.ohrmPayGrade = ohrmPayGrade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmPayGradeCurrencyPK != null ? ohrmPayGradeCurrencyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmPayGradeCurrency)) {
            return false;
        }
        OhrmPayGradeCurrency other = (OhrmPayGradeCurrency) object;
        if ((this.ohrmPayGradeCurrencyPK == null && other.ohrmPayGradeCurrencyPK != null) || (this.ohrmPayGradeCurrencyPK != null && !this.ohrmPayGradeCurrencyPK.equals(other.ohrmPayGradeCurrencyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmPayGradeCurrency[ ohrmPayGradeCurrencyPK=" + ohrmPayGradeCurrencyPK + " ]";
    }
    
}
