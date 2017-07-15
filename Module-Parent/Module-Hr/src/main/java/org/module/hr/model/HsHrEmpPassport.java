/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "hs_hr_emp_passport", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpPassport.findAll", query = "SELECT h FROM HsHrEmpPassport h"),
    @NamedQuery(name = "HsHrEmpPassport.findByEmpNumber", query = "SELECT h FROM HsHrEmpPassport h WHERE h.hsHrEmpPassportPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpSeqno", query = "SELECT h FROM HsHrEmpPassport h WHERE h.hsHrEmpPassportPK.epSeqno = :epSeqno"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpPassportNum", query = "SELECT h FROM HsHrEmpPassport h WHERE h.epPassportNum = :epPassportNum"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpPassportissueddate", query = "SELECT h FROM HsHrEmpPassport h WHERE h.epPassportissueddate = :epPassportissueddate"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpPassportexpiredate", query = "SELECT h FROM HsHrEmpPassport h WHERE h.epPassportexpiredate = :epPassportexpiredate"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpComments", query = "SELECT h FROM HsHrEmpPassport h WHERE h.epComments = :epComments"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpPassportTypeFlg", query = "SELECT h FROM HsHrEmpPassport h WHERE h.epPassportTypeFlg = :epPassportTypeFlg"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpI9Status", query = "SELECT h FROM HsHrEmpPassport h WHERE h.epI9Status = :epI9Status"),
    @NamedQuery(name = "HsHrEmpPassport.findByEpI9ReviewDate", query = "SELECT h FROM HsHrEmpPassport h WHERE h.epI9ReviewDate = :epI9ReviewDate"),
    @NamedQuery(name = "HsHrEmpPassport.findByCouCode", query = "SELECT h FROM HsHrEmpPassport h WHERE h.couCode = :couCode")})
public class HsHrEmpPassport implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpPassportPK hsHrEmpPassportPK;
    @Basic(optional = false)
    @Column(name = "ep_passport_num")
    private String epPassportNum;
    @Column(name = "ep_passportissueddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date epPassportissueddate;
    @Column(name = "ep_passportexpiredate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date epPassportexpiredate;
    @Column(name = "ep_comments")
    private String epComments;
    @Column(name = "ep_passport_type_flg")
    private Short epPassportTypeFlg;
    @Column(name = "ep_i9_status")
    private String epI9Status;
    @Column(name = "ep_i9_review_date")
    @Temporal(TemporalType.DATE)
    private Date epI9ReviewDate;
    @Column(name = "cou_code")
    private String couCode;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpPassport() {
    }

    public HsHrEmpPassport(HsHrEmpPassportPK hsHrEmpPassportPK) {
        this.hsHrEmpPassportPK = hsHrEmpPassportPK;
    }

    public HsHrEmpPassport(HsHrEmpPassportPK hsHrEmpPassportPK, String epPassportNum) {
        this.hsHrEmpPassportPK = hsHrEmpPassportPK;
        this.epPassportNum = epPassportNum;
    }

    public HsHrEmpPassport(int empNumber, short epSeqno) {
        this.hsHrEmpPassportPK = new HsHrEmpPassportPK(empNumber, epSeqno);
    }

    public HsHrEmpPassportPK getHsHrEmpPassportPK() {
        return hsHrEmpPassportPK;
    }

    public void setHsHrEmpPassportPK(HsHrEmpPassportPK hsHrEmpPassportPK) {
        this.hsHrEmpPassportPK = hsHrEmpPassportPK;
    }

    public String getEpPassportNum() {
        return epPassportNum;
    }

    public void setEpPassportNum(String epPassportNum) {
        this.epPassportNum = epPassportNum;
    }

    public Date getEpPassportissueddate() {
        return epPassportissueddate;
    }

    public void setEpPassportissueddate(Date epPassportissueddate) {
        this.epPassportissueddate = epPassportissueddate;
    }

    public Date getEpPassportexpiredate() {
        return epPassportexpiredate;
    }

    public void setEpPassportexpiredate(Date epPassportexpiredate) {
        this.epPassportexpiredate = epPassportexpiredate;
    }

    public String getEpComments() {
        return epComments;
    }

    public void setEpComments(String epComments) {
        this.epComments = epComments;
    }

    public Short getEpPassportTypeFlg() {
        return epPassportTypeFlg;
    }

    public void setEpPassportTypeFlg(Short epPassportTypeFlg) {
        this.epPassportTypeFlg = epPassportTypeFlg;
    }

    public String getEpI9Status() {
        return epI9Status;
    }

    public void setEpI9Status(String epI9Status) {
        this.epI9Status = epI9Status;
    }

    public Date getEpI9ReviewDate() {
        return epI9ReviewDate;
    }

    public void setEpI9ReviewDate(Date epI9ReviewDate) {
        this.epI9ReviewDate = epI9ReviewDate;
    }

    public String getCouCode() {
        return couCode;
    }

    public void setCouCode(String couCode) {
        this.couCode = couCode;
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
        hash += (hsHrEmpPassportPK != null ? hsHrEmpPassportPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpPassport)) {
            return false;
        }
        HsHrEmpPassport other = (HsHrEmpPassport) object;
        if ((this.hsHrEmpPassportPK == null && other.hsHrEmpPassportPK != null) || (this.hsHrEmpPassportPK != null && !this.hsHrEmpPassportPK.equals(other.hsHrEmpPassportPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpPassport[ hsHrEmpPassportPK=" + hsHrEmpPassportPK + " ]";
    }
    
}
