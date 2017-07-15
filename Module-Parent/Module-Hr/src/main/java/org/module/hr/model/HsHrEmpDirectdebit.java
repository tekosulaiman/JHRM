/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "hs_hr_emp_directdebit", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpDirectdebit.findAll", query = "SELECT h FROM HsHrEmpDirectdebit h"),
    @NamedQuery(name = "HsHrEmpDirectdebit.findById", query = "SELECT h FROM HsHrEmpDirectdebit h WHERE h.id = :id"),
    @NamedQuery(name = "HsHrEmpDirectdebit.findByDdRoutingNum", query = "SELECT h FROM HsHrEmpDirectdebit h WHERE h.ddRoutingNum = :ddRoutingNum"),
    @NamedQuery(name = "HsHrEmpDirectdebit.findByDdAccount", query = "SELECT h FROM HsHrEmpDirectdebit h WHERE h.ddAccount = :ddAccount"),
    @NamedQuery(name = "HsHrEmpDirectdebit.findByDdAmount", query = "SELECT h FROM HsHrEmpDirectdebit h WHERE h.ddAmount = :ddAmount"),
    @NamedQuery(name = "HsHrEmpDirectdebit.findByDdAccountType", query = "SELECT h FROM HsHrEmpDirectdebit h WHERE h.ddAccountType = :ddAccountType"),
    @NamedQuery(name = "HsHrEmpDirectdebit.findByDdTransactionType", query = "SELECT h FROM HsHrEmpDirectdebit h WHERE h.ddTransactionType = :ddTransactionType")})
public class HsHrEmpDirectdebit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dd_routing_num")
    private int ddRoutingNum;
    @Basic(optional = false)
    @Column(name = "dd_account")
    private String ddAccount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "dd_amount")
    private BigDecimal ddAmount;
    @Basic(optional = false)
    @Column(name = "dd_account_type")
    private String ddAccountType;
    @Basic(optional = false)
    @Column(name = "dd_transaction_type")
    private String ddTransactionType;
    @JoinColumn(name = "salary_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HsHrEmpBasicsalary salaryId;

    public HsHrEmpDirectdebit() {
    }

    public HsHrEmpDirectdebit(Integer id) {
        this.id = id;
    }

    public HsHrEmpDirectdebit(Integer id, int ddRoutingNum, String ddAccount, BigDecimal ddAmount, String ddAccountType, String ddTransactionType) {
        this.id = id;
        this.ddRoutingNum = ddRoutingNum;
        this.ddAccount = ddAccount;
        this.ddAmount = ddAmount;
        this.ddAccountType = ddAccountType;
        this.ddTransactionType = ddTransactionType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDdRoutingNum() {
        return ddRoutingNum;
    }

    public void setDdRoutingNum(int ddRoutingNum) {
        this.ddRoutingNum = ddRoutingNum;
    }

    public String getDdAccount() {
        return ddAccount;
    }

    public void setDdAccount(String ddAccount) {
        this.ddAccount = ddAccount;
    }

    public BigDecimal getDdAmount() {
        return ddAmount;
    }

    public void setDdAmount(BigDecimal ddAmount) {
        this.ddAmount = ddAmount;
    }

    public String getDdAccountType() {
        return ddAccountType;
    }

    public void setDdAccountType(String ddAccountType) {
        this.ddAccountType = ddAccountType;
    }

    public String getDdTransactionType() {
        return ddTransactionType;
    }

    public void setDdTransactionType(String ddTransactionType) {
        this.ddTransactionType = ddTransactionType;
    }

    public HsHrEmpBasicsalary getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(HsHrEmpBasicsalary salaryId) {
        this.salaryId = salaryId;
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
        if (!(object instanceof HsHrEmpDirectdebit)) {
            return false;
        }
        HsHrEmpDirectdebit other = (HsHrEmpDirectdebit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpDirectdebit[ id=" + id + " ]";
    }
    
}
