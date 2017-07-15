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
@Table(name = "ohrm_attendance_record", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmAttendanceRecord.findAll", query = "SELECT o FROM OhrmAttendanceRecord o"),
    @NamedQuery(name = "OhrmAttendanceRecord.findById", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByEmployeeId", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.employeeId = :employeeId"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchInUtcTime", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchInUtcTime = :punchInUtcTime"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchInNote", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchInNote = :punchInNote"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchInTimeOffset", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchInTimeOffset = :punchInTimeOffset"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchInUserTime", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchInUserTime = :punchInUserTime"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchOutUtcTime", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchOutUtcTime = :punchOutUtcTime"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchOutNote", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchOutNote = :punchOutNote"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchOutTimeOffset", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchOutTimeOffset = :punchOutTimeOffset"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByPunchOutUserTime", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.punchOutUserTime = :punchOutUserTime"),
    @NamedQuery(name = "OhrmAttendanceRecord.findByState", query = "SELECT o FROM OhrmAttendanceRecord o WHERE o.state = :state")})
public class OhrmAttendanceRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "employee_id")
    private long employeeId;
    @Column(name = "punch_in_utc_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchInUtcTime;
    @Column(name = "punch_in_note")
    private String punchInNote;
    @Column(name = "punch_in_time_offset")
    private String punchInTimeOffset;
    @Column(name = "punch_in_user_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchInUserTime;
    @Column(name = "punch_out_utc_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchOutUtcTime;
    @Column(name = "punch_out_note")
    private String punchOutNote;
    @Column(name = "punch_out_time_offset")
    private String punchOutTimeOffset;
    @Column(name = "punch_out_user_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date punchOutUserTime;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;

    public OhrmAttendanceRecord() {
    }

    public OhrmAttendanceRecord(Long id) {
        this.id = id;
    }

    public OhrmAttendanceRecord(Long id, long employeeId, String state) {
        this.id = id;
        this.employeeId = employeeId;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getPunchInUtcTime() {
        return punchInUtcTime;
    }

    public void setPunchInUtcTime(Date punchInUtcTime) {
        this.punchInUtcTime = punchInUtcTime;
    }

    public String getPunchInNote() {
        return punchInNote;
    }

    public void setPunchInNote(String punchInNote) {
        this.punchInNote = punchInNote;
    }

    public String getPunchInTimeOffset() {
        return punchInTimeOffset;
    }

    public void setPunchInTimeOffset(String punchInTimeOffset) {
        this.punchInTimeOffset = punchInTimeOffset;
    }

    public Date getPunchInUserTime() {
        return punchInUserTime;
    }

    public void setPunchInUserTime(Date punchInUserTime) {
        this.punchInUserTime = punchInUserTime;
    }

    public Date getPunchOutUtcTime() {
        return punchOutUtcTime;
    }

    public void setPunchOutUtcTime(Date punchOutUtcTime) {
        this.punchOutUtcTime = punchOutUtcTime;
    }

    public String getPunchOutNote() {
        return punchOutNote;
    }

    public void setPunchOutNote(String punchOutNote) {
        this.punchOutNote = punchOutNote;
    }

    public String getPunchOutTimeOffset() {
        return punchOutTimeOffset;
    }

    public void setPunchOutTimeOffset(String punchOutTimeOffset) {
        this.punchOutTimeOffset = punchOutTimeOffset;
    }

    public Date getPunchOutUserTime() {
        return punchOutUserTime;
    }

    public void setPunchOutUserTime(Date punchOutUserTime) {
        this.punchOutUserTime = punchOutUserTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        if (!(object instanceof OhrmAttendanceRecord)) {
            return false;
        }
        OhrmAttendanceRecord other = (OhrmAttendanceRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmAttendanceRecord[ id=" + id + " ]";
    }
    
}
