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
@Table(name = "trs_employee_language", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeLanguage.findAll", query = "SELECT t FROM TrsEmployeeLanguage t"),
    @NamedQuery(name = "TrsEmployeeLanguage.findByIdEmployeeLanguage", query = "SELECT t FROM TrsEmployeeLanguage t WHERE t.idEmployeeLanguage = :idEmployeeLanguage")})
public class TrsEmployeeLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_employee_language")
    private Integer idEmployeeLanguage;
    @JoinColumn(name = "id_language", referencedColumnName = "id_language")
    @ManyToOne
    private MstLanguage idLanguage;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeLanguage() {
    }

    public TrsEmployeeLanguage(Integer idEmployeeLanguage) {
        this.idEmployeeLanguage = idEmployeeLanguage;
    }

    public Integer getIdEmployeeLanguage() {
        return idEmployeeLanguage;
    }

    public void setIdEmployeeLanguage(Integer idEmployeeLanguage) {
        this.idEmployeeLanguage = idEmployeeLanguage;
    }

    public MstLanguage getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(MstLanguage idLanguage) {
        this.idLanguage = idLanguage;
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
        hash += (idEmployeeLanguage != null ? idEmployeeLanguage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeLanguage)) {
            return false;
        }
        TrsEmployeeLanguage other = (TrsEmployeeLanguage) object;
        if ((this.idEmployeeLanguage == null && other.idEmployeeLanguage != null) || (this.idEmployeeLanguage != null && !this.idEmployeeLanguage.equals(other.idEmployeeLanguage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeLanguage[ idEmployeeLanguage=" + idEmployeeLanguage + " ]";
    }
    
}
