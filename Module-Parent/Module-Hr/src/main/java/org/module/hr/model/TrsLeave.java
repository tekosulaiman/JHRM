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
 * @author 10991044
 */
@Entity
@Table(name = "trs_leave", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsLeave.findAll", query = "SELECT t FROM TrsLeave t"),
    @NamedQuery(name = "TrsLeave.findByIdLeave", query = "SELECT t FROM TrsLeave t WHERE t.idLeave = :idLeave"),
    @NamedQuery(name = "TrsLeave.findByFromDate", query = "SELECT t FROM TrsLeave t WHERE t.fromDate = :fromDate"),
    @NamedQuery(name = "TrsLeave.findByToDate", query = "SELECT t FROM TrsLeave t WHERE t.toDate = :toDate"),
    @NamedQuery(name = "TrsLeave.findByDuration", query = "SELECT t FROM TrsLeave t WHERE t.duration = :duration"),
    @NamedQuery(name = "TrsLeave.findByComment", query = "SELECT t FROM TrsLeave t WHERE t.comment = :comment")})
public class TrsLeave implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave")
    private Integer idLeave;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "id_leave_type", referencedColumnName = "id_leave_type")
    @ManyToOne
    private MstLeaveType idLeaveType;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsLeave() {
    }

    public TrsLeave(Integer idLeave) {
        this.idLeave = idLeave;
    }

    public Integer getIdLeave() {
        return idLeave;
    }

    public void setIdLeave(Integer idLeave) {
        this.idLeave = idLeave;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public MstLeaveType getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(MstLeaveType idLeaveType) {
        this.idLeaveType = idLeaveType;
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
        hash += (idLeave != null ? idLeave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsLeave)) {
            return false;
        }
        TrsLeave other = (TrsLeave) object;
        if ((this.idLeave == null && other.idLeave != null) || (this.idLeave != null && !this.idLeave.equals(other.idLeave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsLeave[ idLeave=" + idLeave + " ]";
    }
    
}
