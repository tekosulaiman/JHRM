package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_nationality database table.
 * 
 */
@Entity
@Table(name="mst_nationality")
@NamedQuery(name="MstNationality.findAll", query="SELECT m FROM MstNationality m")
public class MstNationality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_nationality")
	private Integer idNationality;

	@Column(name="name_nationality")
	private String nameNationality;

	public MstNationality() {
	}

	public Integer getIdNationality() {
		return this.idNationality;
	}

	public void setIdNationality(Integer idNationality) {
		this.idNationality = idNationality;
	}

	public String getNameNationality() {
		return this.nameNationality;
	}

	public void setNameNationality(String nameNationality) {
		this.nameNationality = nameNationality;
	}

}