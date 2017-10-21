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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "trs_job_vacancy", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsJobVacancy.findAll", query = "SELECT t FROM TrsJobVacancy t"),
    @NamedQuery(name = "TrsJobVacancy.findByIdTrsJobVacancy", query = "SELECT t FROM TrsJobVacancy t WHERE t.idTrsJobVacancy = :idTrsJobVacancy")})
public class TrsJobVacancy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsJobVacancy_idTrsJobVacancy_GENERATOR", sequenceName="SCHEMA_HR.TrsJobVacancy_idTrsJobVacancy_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsJobVacancy_idTrsJobVacancy_GENERATOR")
	
    @Column(name = "id_trs_job_vacancy")
    private Integer idTrsJobVacancy;
	
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "no_of_positions")
    private Integer noOfPositions;
    
    @Column(name = "published_in_feed")
    private Boolean publishedInFeed;
    
    @Column(name = "defined_time")
    @Temporal(TemporalType.DATE)
    private Date definedTime;
    
    @Column(name = "updated_time")
    @Temporal(TemporalType.DATE)
    private Date updatedTime;
    
    @Column(name = "active")
    @Basic(optional = false)
    private Boolean active;    
    
    @OneToMany(mappedBy = "idTrsJobVacancy")
    private List<TrsJobCandidate> trsJobVacancyList;
    
    @JoinColumn(name = "id_job_title", referencedColumnName = "id_job_title")
    @ManyToOne
    private MstJobtitle idJobTitle;
    
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsJobVacancy() {
    }

    public TrsJobVacancy(Integer idTrsJobVacancy) {
        this.idTrsJobVacancy = idTrsJobVacancy;
    }

    public Integer getIdTrsJobVacancy() {
        return idTrsJobVacancy;
    }

    public void setIdTrsJobVacancy(Integer idTrsJobVacancy) {
        this.idTrsJobVacancy = idTrsJobVacancy;
    }

    public MstJobtitle getIdJobTitle() {
        return idJobTitle;
    }

    public void setIdJobTitle(MstJobtitle idJobTitle) {
        this.idJobTitle = idJobTitle;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNoOfPositions() {
        return noOfPositions;
    }

    public void setNoOfPositions(Integer noOfPositions) {
        this.noOfPositions = noOfPositions;
    }

    public Boolean getPublishedInFeed() {
        return publishedInFeed;
    }

    public void setPublishedInFeed(Boolean publishedInFeed) {
        this.publishedInFeed = publishedInFeed;
    }

    public Date getDefinedTime() {
        return definedTime;
    }

    public void setDefinedTime(Date definedTime) {
        this.definedTime = definedTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((definedTime == null) ? 0 : definedTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idEmployee == null) ? 0 : idEmployee.hashCode());
		result = prime * result + ((idJobTitle == null) ? 0 : idJobTitle.hashCode());
		result = prime * result + ((idTrsJobVacancy == null) ? 0 : idTrsJobVacancy.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((noOfPositions == null) ? 0 : noOfPositions.hashCode());
		result = prime * result + ((publishedInFeed == null) ? 0 : publishedInFeed.hashCode());
		result = prime * result + ((trsJobVacancyList == null) ? 0 : trsJobVacancyList.hashCode());
		result = prime * result + ((updatedTime == null) ? 0 : updatedTime.hashCode());
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
		TrsJobVacancy other = (TrsJobVacancy) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (definedTime == null) {
			if (other.definedTime != null)
				return false;
		} else if (!definedTime.equals(other.definedTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idEmployee == null) {
			if (other.idEmployee != null)
				return false;
		} else if (!idEmployee.equals(other.idEmployee))
			return false;
		if (idJobTitle == null) {
			if (other.idJobTitle != null)
				return false;
		} else if (!idJobTitle.equals(other.idJobTitle))
			return false;
		if (idTrsJobVacancy == null) {
			if (other.idTrsJobVacancy != null)
				return false;
		} else if (!idTrsJobVacancy.equals(other.idTrsJobVacancy))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noOfPositions == null) {
			if (other.noOfPositions != null)
				return false;
		} else if (!noOfPositions.equals(other.noOfPositions))
			return false;
		if (publishedInFeed == null) {
			if (other.publishedInFeed != null)
				return false;
		} else if (!publishedInFeed.equals(other.publishedInFeed))
			return false;
		if (trsJobVacancyList == null) {
			if (other.trsJobVacancyList != null)
				return false;
		} else if (!trsJobVacancyList.equals(other.trsJobVacancyList))
			return false;
		if (updatedTime == null) {
			if (other.updatedTime != null)
				return false;
		} else if (!updatedTime.equals(other.updatedTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrsJobVacancy [idTrsJobVacancy=" + idTrsJobVacancy + ", name=" + name + ", description=" + description
				+ ", noOfPositions=" + noOfPositions + ", publishedInFeed=" + publishedInFeed + ", definedTime="
				+ definedTime + ", updatedTime=" + updatedTime + ", active=" + active + ", trsJobVacancyList="
				+ trsJobVacancyList + ", idJobTitle=" + idJobTitle + ", idEmployee=" + idEmployee + "]";
	}
    
	
}
