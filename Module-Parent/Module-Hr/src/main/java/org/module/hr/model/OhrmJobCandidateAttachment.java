/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "ohrm_job_candidate_attachment", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmJobCandidateAttachment.findAll", query = "SELECT o FROM OhrmJobCandidateAttachment o"),
    @NamedQuery(name = "OhrmJobCandidateAttachment.findById", query = "SELECT o FROM OhrmJobCandidateAttachment o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmJobCandidateAttachment.findByFileName", query = "SELECT o FROM OhrmJobCandidateAttachment o WHERE o.fileName = :fileName"),
    @NamedQuery(name = "OhrmJobCandidateAttachment.findByFileType", query = "SELECT o FROM OhrmJobCandidateAttachment o WHERE o.fileType = :fileType"),
    @NamedQuery(name = "OhrmJobCandidateAttachment.findByFileSize", query = "SELECT o FROM OhrmJobCandidateAttachment o WHERE o.fileSize = :fileSize"),
    @NamedQuery(name = "OhrmJobCandidateAttachment.findByAttachmentType", query = "SELECT o FROM OhrmJobCandidateAttachment o WHERE o.attachmentType = :attachmentType")})
public class OhrmJobCandidateAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_type")
    private String fileType;
    @Basic(optional = false)
    @Column(name = "file_size")
    private int fileSize;
    @Lob
    @Column(name = "file_content")
    private byte[] fileContent;
    @Column(name = "attachment_type")
    private Integer attachmentType;
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmJobCandidate candidateId;

    public OhrmJobCandidateAttachment() {
    }

    public OhrmJobCandidateAttachment(Integer id) {
        this.id = id;
    }

    public OhrmJobCandidateAttachment(Integer id, String fileName, int fileSize) {
        this.id = id;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public Integer getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(Integer attachmentType) {
        this.attachmentType = attachmentType;
    }

    public OhrmJobCandidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(OhrmJobCandidate candidateId) {
        this.candidateId = candidateId;
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
        if (!(object instanceof OhrmJobCandidateAttachment)) {
            return false;
        }
        OhrmJobCandidateAttachment other = (OhrmJobCandidateAttachment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobCandidateAttachment[ id=" + id + " ]";
    }
    
}
