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
@Table(name = "trs_employee_skill", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeSkill.findAll", query = "SELECT t FROM TrsEmployeeSkill t"),
    @NamedQuery(name = "TrsEmployeeSkill.findByIdEmployeeSkill", query = "SELECT t FROM TrsEmployeeSkill t WHERE t.idEmployeeSkill = :idEmployeeSkill")})
public class TrsEmployeeSkill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_employee_skill")
    private Integer idEmployeeSkill;
    @JoinColumn(name = "id_skill", referencedColumnName = "id_skill")
    @ManyToOne
    private MstSkill idSkill;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeSkill() {
    }

    public TrsEmployeeSkill(Integer idEmployeeSkill) {
        this.idEmployeeSkill = idEmployeeSkill;
    }

    public Integer getIdEmployeeSkill() {
        return idEmployeeSkill;
    }

    public void setIdEmployeeSkill(Integer idEmployeeSkill) {
        this.idEmployeeSkill = idEmployeeSkill;
    }

    public MstSkill getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(MstSkill idSkill) {
        this.idSkill = idSkill;
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
        hash += (idEmployeeSkill != null ? idEmployeeSkill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeSkill)) {
            return false;
        }
        TrsEmployeeSkill other = (TrsEmployeeSkill) object;
        if ((this.idEmployeeSkill == null && other.idEmployeeSkill != null) || (this.idEmployeeSkill != null && !this.idEmployeeSkill.equals(other.idEmployeeSkill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeSkill[ idEmployeeSkill=" + idEmployeeSkill + " ]";
    }
    
}
