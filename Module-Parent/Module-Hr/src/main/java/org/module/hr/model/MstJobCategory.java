package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_job_category database table.
 * 
 */
@Entity
@Table(name="mst_job_category")
@NamedQuery(name="MstJobCategory.findAll", query="SELECT m FROM MstJobCategory m")
public class MstJobCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_job_category")
	private Integer idJobCategory;

	@Column(name="job_category_name")
	private String jobCategoryName;

	public MstJobCategory() {
	}

	public Integer getIdJobCategory() {
		return this.idJobCategory;
	}

	public void setIdJobCategory(Integer idJobCategory) {
		this.idJobCategory = idJobCategory;
	}

	public String getJobCategoryName() {
		return this.jobCategoryName;
	}

	public void setJobCategoryName(String jobCategoryName) {
		this.jobCategoryName = jobCategoryName;
	}

}