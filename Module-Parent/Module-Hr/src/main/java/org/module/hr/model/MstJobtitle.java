package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_jobtitle database table.
 * 
 */
@Entity
@Table(name="mst_jobtitle")
@NamedQuery(name="MstJobtitle.findAll", query="SELECT m FROM MstJobtitle m")
public class MstJobtitle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_job_title")
	private Integer idJobTitle;

	@Column(name="job_description")
	private String jobDescription;

	@Column(name="job_name")
	private String jobName;

	@Column(name="job_note")
	private String jobNote;

	public MstJobtitle() {
	}

	public Integer getIdJobTitle() {
		return this.idJobTitle;
	}

	public void setIdJobTitle(Integer idJobTitle) {
		this.idJobTitle = idJobTitle;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobNote() {
		return this.jobNote;
	}

	public void setJobNote(String jobNote) {
		this.jobNote = jobNote;
	}

}