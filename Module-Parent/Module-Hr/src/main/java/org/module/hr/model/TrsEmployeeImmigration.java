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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "trs_employee_immigration", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeImmigration.findAll", query = "SELECT t FROM TrsEmployeeImmigration t"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByIdImmigration", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.idImmigration = :idImmigration"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByDocument", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.document = :document"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByNumber", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.number = :number"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByIssuedDate", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.issuedDate = :issuedDate"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByExpiredDate", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.expiredDate = :expiredDate"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByEligibleStatus", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.eligibleStatus = :eligibleStatus"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByIdCountry", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.idCountry = :idCountry"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByEligibleReview", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.eligibleReview = :eligibleReview"),
    @NamedQuery(name = "TrsEmployeeImmigration.findByComment", query = "SELECT t FROM TrsEmployeeImmigration t WHERE t.comment = :comment")})
public class TrsEmployeeImmigration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_immigration")
    private Integer idImmigration;
    @Column(name = "document")
    private String document;
    @Column(name = "number")
    private Integer number;
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Column(name = "expired_date")
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    @Column(name = "eligible_status")
    private String eligibleStatus;
    @Column(name = "id_country")
    private String idCountry;
    @Column(name = "eligible_review")
    @Temporal(TemporalType.DATE)
    private Date eligibleReview;
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeImmigration() {
    }

    public TrsEmployeeImmigration(Integer idImmigration) {
        this.idImmigration = idImmigration;
    }

    public Integer getIdImmigration() {
        return idImmigration;
    }

    public void setIdImmigration(Integer idImmigration) {
        this.idImmigration = idImmigration;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getEligibleStatus() {
        return eligibleStatus;
    }

    public void setEligibleStatus(String eligibleStatus) {
        this.eligibleStatus = eligibleStatus;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }

    public Date getEligibleReview() {
        return eligibleReview;
    }

    public void setEligibleReview(Date eligibleReview) {
        this.eligibleReview = eligibleReview;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImmigration != null ? idImmigration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeImmigration)) {
            return false;
        }
        TrsEmployeeImmigration other = (TrsEmployeeImmigration) object;
        if ((this.idImmigration == null && other.idImmigration != null) || (this.idImmigration != null && !this.idImmigration.equals(other.idImmigration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeImmigration[ idImmigration=" + idImmigration + " ]";
    }
    
}
