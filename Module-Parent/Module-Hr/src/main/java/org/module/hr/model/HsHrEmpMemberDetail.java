/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_member_detail", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpMemberDetail.findAll", query = "SELECT h FROM HsHrEmpMemberDetail h"),
    @NamedQuery(name = "HsHrEmpMemberDetail.findByEmpNumber", query = "SELECT h FROM HsHrEmpMemberDetail h WHERE h.hsHrEmpMemberDetailPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpMemberDetail.findByMembshipCode", query = "SELECT h FROM HsHrEmpMemberDetail h WHERE h.hsHrEmpMemberDetailPK.membshipCode = :membshipCode"),
    @NamedQuery(name = "HsHrEmpMemberDetail.findByEmembSubscriptOwnership", query = "SELECT h FROM HsHrEmpMemberDetail h WHERE h.emembSubscriptOwnership = :emembSubscriptOwnership"),
    @NamedQuery(name = "HsHrEmpMemberDetail.findByEmembSubscriptAmount", query = "SELECT h FROM HsHrEmpMemberDetail h WHERE h.emembSubscriptAmount = :emembSubscriptAmount"),
    @NamedQuery(name = "HsHrEmpMemberDetail.findByEmembSubsCurrency", query = "SELECT h FROM HsHrEmpMemberDetail h WHERE h.emembSubsCurrency = :emembSubsCurrency"),
    @NamedQuery(name = "HsHrEmpMemberDetail.findByEmembCommenceDate", query = "SELECT h FROM HsHrEmpMemberDetail h WHERE h.emembCommenceDate = :emembCommenceDate"),
    @NamedQuery(name = "HsHrEmpMemberDetail.findByEmembRenewalDate", query = "SELECT h FROM HsHrEmpMemberDetail h WHERE h.emembRenewalDate = :emembRenewalDate")})
public class HsHrEmpMemberDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpMemberDetailPK hsHrEmpMemberDetailPK;
    @Column(name = "ememb_subscript_ownership")
    private String emembSubscriptOwnership;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ememb_subscript_amount")
    private BigDecimal emembSubscriptAmount;
    @Column(name = "ememb_subs_currency")
    private String emembSubsCurrency;
    @Column(name = "ememb_commence_date")
    @Temporal(TemporalType.DATE)
    private Date emembCommenceDate;
    @Column(name = "ememb_renewal_date")
    @Temporal(TemporalType.DATE)
    private Date emembRenewalDate;
    @JoinColumn(name = "membship_code", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmMembership ohrmMembership;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpMemberDetail() {
    }

    public HsHrEmpMemberDetail(HsHrEmpMemberDetailPK hsHrEmpMemberDetailPK) {
        this.hsHrEmpMemberDetailPK = hsHrEmpMemberDetailPK;
    }

    public HsHrEmpMemberDetail(int empNumber, int membshipCode) {
        this.hsHrEmpMemberDetailPK = new HsHrEmpMemberDetailPK(empNumber, membshipCode);
    }

    public HsHrEmpMemberDetailPK getHsHrEmpMemberDetailPK() {
        return hsHrEmpMemberDetailPK;
    }

    public void setHsHrEmpMemberDetailPK(HsHrEmpMemberDetailPK hsHrEmpMemberDetailPK) {
        this.hsHrEmpMemberDetailPK = hsHrEmpMemberDetailPK;
    }

    public String getEmembSubscriptOwnership() {
        return emembSubscriptOwnership;
    }

    public void setEmembSubscriptOwnership(String emembSubscriptOwnership) {
        this.emembSubscriptOwnership = emembSubscriptOwnership;
    }

    public BigDecimal getEmembSubscriptAmount() {
        return emembSubscriptAmount;
    }

    public void setEmembSubscriptAmount(BigDecimal emembSubscriptAmount) {
        this.emembSubscriptAmount = emembSubscriptAmount;
    }

    public String getEmembSubsCurrency() {
        return emembSubsCurrency;
    }

    public void setEmembSubsCurrency(String emembSubsCurrency) {
        this.emembSubsCurrency = emembSubsCurrency;
    }

    public Date getEmembCommenceDate() {
        return emembCommenceDate;
    }

    public void setEmembCommenceDate(Date emembCommenceDate) {
        this.emembCommenceDate = emembCommenceDate;
    }

    public Date getEmembRenewalDate() {
        return emembRenewalDate;
    }

    public void setEmembRenewalDate(Date emembRenewalDate) {
        this.emembRenewalDate = emembRenewalDate;
    }

    public OhrmMembership getOhrmMembership() {
        return ohrmMembership;
    }

    public void setOhrmMembership(OhrmMembership ohrmMembership) {
        this.ohrmMembership = ohrmMembership;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsHrEmpMemberDetailPK != null ? hsHrEmpMemberDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpMemberDetail)) {
            return false;
        }
        HsHrEmpMemberDetail other = (HsHrEmpMemberDetail) object;
        if ((this.hsHrEmpMemberDetailPK == null && other.hsHrEmpMemberDetailPK != null) || (this.hsHrEmpMemberDetailPK != null && !this.hsHrEmpMemberDetailPK.equals(other.hsHrEmpMemberDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpMemberDetail[ hsHrEmpMemberDetailPK=" + hsHrEmpMemberDetailPK + " ]";
    }
    
}
