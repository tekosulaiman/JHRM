/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Tom
 */
@Embeddable
public class OhrmPayGradeCurrencyPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pay_grade_id")
    private int payGradeId;
    @Basic(optional = false)
    @Column(name = "currency_id")
    private String currencyId;

    public OhrmPayGradeCurrencyPK() {
    }

    public OhrmPayGradeCurrencyPK(int payGradeId, String currencyId) {
        this.payGradeId = payGradeId;
        this.currencyId = currencyId;
    }

    public int getPayGradeId() {
        return payGradeId;
    }

    public void setPayGradeId(int payGradeId) {
        this.payGradeId = payGradeId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) payGradeId;
        hash += (currencyId != null ? currencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmPayGradeCurrencyPK)) {
            return false;
        }
        OhrmPayGradeCurrencyPK other = (OhrmPayGradeCurrencyPK) object;
        if (this.payGradeId != other.payGradeId) {
            return false;
        }
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmPayGradeCurrencyPK[ payGradeId=" + payGradeId + ", currencyId=" + currencyId + " ]";
    }
    
}
