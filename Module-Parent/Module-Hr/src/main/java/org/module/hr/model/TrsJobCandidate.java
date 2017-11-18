package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.module.api.common.utilities.BusinessCaseUtilities;

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
    @SequenceGenerator(name="TrsJobCandidate_idTrsJobCandidate_GENERATOR", sequenceName="SCHEMA_HR.TrsJobCandidate_idTrsJobCandidate_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsJobCandidate_idTrsJobCandidate_GENERATOR")
    @Column(name = "id_trs_job_candidate")
    private Integer idTrsJobCandidate;
    
    @Column(name = "first_name")
    @Basic(optional = false)
    private String firstName;
    
    @Column(name = "middle_name")
    @Basic(optional = true)
    private String middleName;
    
    @Column(name = "last_name")
    @Basic(optional = true)
    private String lastName;
    
    @Column(name = "contact_no")
    @Basic(optional = true)
    private String contactNo;
    
    @Column(name = "resume")
    @Basic(optional = true)
    private String resume;
    
    @Transient
    private String fullName;
    
    @JoinColumn(name = "id_job_vacancy", referencedColumnName = "id_trs_job_vacancy")
    @ManyToOne
    private TrsJobVacancy idTrsJobVacancy;
    
    @Column(name = "created_at")
    @Basic(optional = false)
    private Date createdAt;
    
    @Column(name = "updated_at")
    @Basic(optional = true)
    private Date updatedAt;
    
    @Column(name = "email")
    @Basic(optional = true)
    private String email;

    public TrsJobCandidate() {
    }

    public TrsJobCandidate(Integer idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }

    public Integer getIdTrsJobCandidate() {
        return idTrsJobCandidate;
    }

    public void setIdTrsJobCandidate(Integer idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }
    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public TrsJobVacancy getIdTrsJobVacancy() {
		return idTrsJobVacancy;
	}

	public void setIdTrsJobVacancy(TrsJobVacancy idTrsJobVacancy) {
		this.idTrsJobVacancy = idTrsJobVacancy;
	}

    public String getFullName() {
    	this.fullName = BusinessCaseUtilities.composeFullName(this.firstName, this.middleName, this.lastName);
		return fullName;
	}
    
    public void setFullName(String fullName) {
		this.fullName = fullName;
	}
    
    public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}