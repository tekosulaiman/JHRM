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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author tekosulaiman@yahoo.com
*/
@Entity
@Table(name = "trs_job_vacancy", catalog = "dbhr", schema = "schema_hr")
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
}