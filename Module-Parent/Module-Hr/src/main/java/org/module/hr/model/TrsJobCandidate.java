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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.module.api.common.utilities.BusinessCaseUtilities;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "trs_job_candidate", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsJobCandidate.findAll", query = "SELECT t FROM TrsJobCandidate t"),
    @NamedQuery(name = "TrsJobCandidate.findByIdTrsJobCandidate", query = "SELECT t FROM TrsJobCandidate t WHERE t.idTrsJobCandidate = :idTrsJobCandidate")})
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((idTrsJobCandidate == null) ? 0 : idTrsJobCandidate.hashCode());
		result = prime * result + ((idTrsJobVacancy == null) ? 0 : idTrsJobVacancy.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrsJobCandidate other = (TrsJobCandidate) obj;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (idTrsJobCandidate == null) {
			if (other.idTrsJobCandidate != null)
				return false;
		} else if (!idTrsJobCandidate.equals(other.idTrsJobCandidate))
			return false;
		if (idTrsJobVacancy == null) {
			if (other.idTrsJobVacancy != null)
				return false;
		} else if (!idTrsJobVacancy.equals(other.idTrsJobVacancy))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrsJobCandidate [idTrsJobCandidate=" + idTrsJobCandidate + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", contactNo=" + contactNo + ", resume=" + resume
				+ ", fullName=" + fullName + ", idTrsJobVacancy=" + idTrsJobVacancy + ", trsJobCandidateVacancyList="
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
	
}
