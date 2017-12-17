/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
*
* @author tekosulaiman@yahoo.com
*/
@Entity
@Table(name = "trs_job_candidate", catalog = "dbhr", schema = "schema_hr")
public class TrsJobCandidate implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_trs_job_candidate")
    private String idTrsJobCandidate;
    
    @Column(name = "contact_no")
    private String contactNo;
    
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "resume")
    private String resume;
    
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    
    @OneToMany(mappedBy = "idTrsJobCandidate")
    private List<MstUploadFile> mstUploadFileList;
    
    @JoinColumn(name = "id_trs_job_vacancy", referencedColumnName = "id_trs_job_vacancy")
    @ManyToOne
    private TrsJobVacancy idTrsJobVacancy;

    public TrsJobCandidate() {
    }

    public TrsJobCandidate(String idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }

    public TrsJobCandidate(String idTrsJobCandidate, Date createdAt, String firstName) {
        this.idTrsJobCandidate = idTrsJobCandidate;
        this.createdAt = createdAt;
        this.firstName = firstName;
    }

    public String getIdTrsJobCandidate() {
        return idTrsJobCandidate;
    }

    public void setIdTrsJobCandidate(String idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @XmlTransient
    public List<MstUploadFile> getMstUploadFileList() {
        return mstUploadFileList;
    }

    public void setMstUploadFileList(List<MstUploadFile> mstUploadFileList) {
        this.mstUploadFileList = mstUploadFileList;
    }

    public TrsJobVacancy getIdTrsJobVacancy() {
        return idTrsJobVacancy;
    }

    public void setIdTrsJobVacancy(TrsJobVacancy idTrsJobVacancy) {
        this.idTrsJobVacancy = idTrsJobVacancy;
    }
}