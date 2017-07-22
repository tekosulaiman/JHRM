/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @Column(name = "id_employee_education")
    private Integer idEmployeeEducation;
    @JoinColumn(name = "id_education", referencedColumnName = "id_education")
    @ManyToOne
    private MstEducation idEducation;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

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
    
}
