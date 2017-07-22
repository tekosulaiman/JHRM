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
@Table(name = "trs_employee_exprience", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeExprience.findAll", query = "SELECT t FROM TrsEmployeeExprience t"),
    @NamedQuery(name = "TrsEmployeeExprience.findByIdExprience", query = "SELECT t FROM TrsEmployeeExprience t WHERE t.idExprience = :idExprience")})
public class TrsEmployeeExprience implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_exprience")
    private Integer idExprience;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEmployeeExprience() {
    }

    public TrsEmployeeExprience(Integer idExprience) {
        this.idExprience = idExprience;
    }

    public Integer getIdExprience() {
        return idExprience;
    }

    public void setIdExprience(Integer idExprience) {
        this.idExprience = idExprience;
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
        hash += (idExprience != null ? idExprience.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeExprience)) {
            return false;
        }
        TrsEmployeeExprience other = (TrsEmployeeExprience) object;
        if ((this.idExprience == null && other.idExprience != null) || (this.idExprience != null && !this.idExprience.equals(other.idExprience))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeExprience[ idExprience=" + idExprience + " ]";
    }
    
}
