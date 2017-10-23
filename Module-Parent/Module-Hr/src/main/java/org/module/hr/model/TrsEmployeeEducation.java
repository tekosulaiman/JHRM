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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "trs_employee_education", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeEducation.findAll", query = "SELECT t FROM TrsEmployeeEducation t"),
    @NamedQuery(name = "TrsEmployeeEducation.findByIdEmployeeEducation", query = "SELECT t FROM TrsEmployeeEducation t WHERE t.idEmployeeEducation = :idEmployeeEducation")})
public class TrsEmployeeEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsEmployeeEducation_idEmployeeEducation_GENERATOR", sequenceName="SCHEMA_HR.TrsEmployeeEducation_idEmployeeEducation_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsEmployeeEducation_idEmployeeEducation_GENERATOR")
    @Column(name = "id_employee_education")
    private Integer idEmployeeEducation;
    @JoinColumn(name = "id_education", referencedColumnName = "id_education")
    @ManyToOne
    private MstEducation idEducation;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    @Column(name = "institute")
    private String institute;
    @Column(name = "major_specialization")
    private String majorSpecialization;
    @Column(name = "year")
    private Integer year;
    @Column(name = "gpa_score")
    private String gpaScore;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    public TrsEmployeeEducation() {
    }

    public TrsEmployeeEducation(Integer idEmployeeEducation) {
        this.idEmployeeEducation = idEmployeeEducation;
    }

    public Integer getIdEmployeeEducation() {
        return idEmployeeEducation;
    }

    public void setIdEmployeeEducation(Integer idEmployeeEducation) {
        this.idEmployeeEducation = idEmployeeEducation;
    }

    public MstEducation getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(MstEducation idEducation) {
        this.idEducation = idEducation;
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
        hash += (idEmployeeEducation != null ? idEmployeeEducation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeEducation)) {
            return false;
        }
        TrsEmployeeEducation other = (TrsEmployeeEducation) object;
        if ((this.idEmployeeEducation == null && other.idEmployeeEducation != null) || (this.idEmployeeEducation != null && !this.idEmployeeEducation.equals(other.idEmployeeEducation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeEducation[ idEmployeeEducation=" + idEmployeeEducation + " ]";
    }

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getMajorSpecialization() {
		return majorSpecialization;
	}

	public void setMajorSpecialization(String majorSpecialization) {
		this.majorSpecialization = majorSpecialization;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGpaScore() {
		return gpaScore;
	}

	public void setGpaScore(String gpaScore) {
		this.gpaScore = gpaScore;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
}
