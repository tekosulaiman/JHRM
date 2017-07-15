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
import javax.persistence.Lob;
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
@Table(name = "hs_hr_emp_attachment", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpAttachment.findAll", query = "SELECT h FROM HsHrEmpAttachment h"),
    @NamedQuery(name = "HsHrEmpAttachment.findByEmpNumber", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.hsHrEmpAttachmentPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpAttachment.findByEattachId", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.hsHrEmpAttachmentPK.eattachId = :eattachId"),
    @NamedQuery(name = "HsHrEmpAttachment.findByEattachDesc", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.eattachDesc = :eattachDesc"),
    @NamedQuery(name = "HsHrEmpAttachment.findByEattachFilename", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.eattachFilename = :eattachFilename"),
    @NamedQuery(name = "HsHrEmpAttachment.findByEattachSize", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.eattachSize = :eattachSize"),
    @NamedQuery(name = "HsHrEmpAttachment.findByEattachType", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.eattachType = :eattachType"),
    @NamedQuery(name = "HsHrEmpAttachment.findByScreen", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.screen = :screen"),
    @NamedQuery(name = "HsHrEmpAttachment.findByAttachedBy", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.attachedBy = :attachedBy"),
    @NamedQuery(name = "HsHrEmpAttachment.findByAttachedByName", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.attachedByName = :attachedByName"),
    @NamedQuery(name = "HsHrEmpAttachment.findByAttachedTime", query = "SELECT h FROM HsHrEmpAttachment h WHERE h.attachedTime = :attachedTime")})
public class HsHrEmpAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpAttachmentPK hsHrEmpAttachmentPK;
    @Column(name = "eattach_desc")
    private String eattachDesc;
    @Column(name = "eattach_filename")
    private String eattachFilename;
    @Column(name = "eattach_size")
    private Integer eattachSize;
    @Lob
    @Column(name = "eattach_attachment")
    private byte[] eattachAttachment;
    @Column(name = "eattach_type")
    private String eattachType;
    @Column(name = "screen")
    private String screen;
    @Column(name = "attached_by")
    private Integer attachedBy;
    @Column(name = "attached_by_name")
    private String attachedByName;
    @Basic(optional = false)
    @Column(name = "attached_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date attachedTime;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpAttachment() {
    }

    public HsHrEmpAttachment(HsHrEmpAttachmentPK hsHrEmpAttachmentPK) {
        this.hsHrEmpAttachmentPK = hsHrEmpAttachmentPK;
    }

    public HsHrEmpAttachment(HsHrEmpAttachmentPK hsHrEmpAttachmentPK, Date attachedTime) {
        this.hsHrEmpAttachmentPK = hsHrEmpAttachmentPK;
        this.attachedTime = attachedTime;
    }

    public HsHrEmpAttachment(int empNumber, int eattachId) {
        this.hsHrEmpAttachmentPK = new HsHrEmpAttachmentPK(empNumber, eattachId);
    }

    public HsHrEmpAttachmentPK getHsHrEmpAttachmentPK() {
        return hsHrEmpAttachmentPK;
    }

    public void setHsHrEmpAttachmentPK(HsHrEmpAttachmentPK hsHrEmpAttachmentPK) {
        this.hsHrEmpAttachmentPK = hsHrEmpAttachmentPK;
    }

    public String getEattachDesc() {
        return eattachDesc;
    }

    public void setEattachDesc(String eattachDesc) {
        this.eattachDesc = eattachDesc;
    }

    public String getEattachFilename() {
        return eattachFilename;
    }

    public void setEattachFilename(String eattachFilename) {
        this.eattachFilename = eattachFilename;
    }

    public Integer getEattachSize() {
        return eattachSize;
    }

    public void setEattachSize(Integer eattachSize) {
        this.eattachSize = eattachSize;
    }

    public byte[] getEattachAttachment() {
        return eattachAttachment;
    }

    public void setEattachAttachment(byte[] eattachAttachment) {
        this.eattachAttachment = eattachAttachment;
    }

    public String getEattachType() {
        return eattachType;
    }

    public void setEattachType(String eattachType) {
        this.eattachType = eattachType;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Integer getAttachedBy() {
        return attachedBy;
    }

    public void setAttachedBy(Integer attachedBy) {
        this.attachedBy = attachedBy;
    }

    public String getAttachedByName() {
        return attachedByName;
    }

    public void setAttachedByName(String attachedByName) {
        this.attachedByName = attachedByName;
    }

    public Date getAttachedTime() {
        return attachedTime;
    }

    public void setAttachedTime(Date attachedTime) {
        this.attachedTime = attachedTime;
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
        hash += (hsHrEmpAttachmentPK != null ? hsHrEmpAttachmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpAttachment)) {
            return false;
        }
        HsHrEmpAttachment other = (HsHrEmpAttachment) object;
        if ((this.hsHrEmpAttachmentPK == null && other.hsHrEmpAttachmentPK != null) || (this.hsHrEmpAttachmentPK != null && !this.hsHrEmpAttachmentPK.equals(other.hsHrEmpAttachmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpAttachment[ hsHrEmpAttachmentPK=" + hsHrEmpAttachmentPK + " ]";
    }
    
}
