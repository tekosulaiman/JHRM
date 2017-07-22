package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_employement_status database table.
 * 
 */
@Entity
@Table(name="mst_employement_status")
@NamedQuery(name="MstEmployementStatus.findAll", query="SELECT m FROM MstEmployementStatus m")
public class MstEmployementStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_employement_status")
	private Integer idEmployementStatus;

	@Column(name="employement_status_name")
	private String employementStatusName;

	public MstEmployementStatus() {
	}

	public Integer getIdEmployementStatus() {
		return this.idEmployementStatus;
	}

	public void setIdEmployementStatus(Integer idEmployementStatus) {
		this.idEmployementStatus = idEmployementStatus;
	}

	public String getEmployementStatusName() {
		return this.employementStatusName;
	}

	public void setEmployementStatusName(String employementStatusName) {
		this.employementStatusName = employementStatusName;
	}

}