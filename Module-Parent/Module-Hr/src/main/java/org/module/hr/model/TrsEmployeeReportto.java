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
@Table(name = "trs_employee_reportto", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeReportto.findAll", query = "SELECT t FROM TrsEmployeeReportto t"),
    @NamedQuery(name = "TrsEmployeeReportto.findByIdReportto", query = "SELECT t FROM TrsEmployeeReportto t WHERE t.idReportto = :idReportto"),
    @NamedQuery(name = "TrsEmployeeReportto.findByMethodeDiret", query = "SELECT t FROM TrsEmployeeReportto t WHERE t.methodeDiret = :methodeDiret")})
public class TrsEmployeeReportto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_reportto")
    private Integer idReportto;
    @Column(name = "methode_diret")
    private Character methodeDiret;
    @JoinColumn(name = "id_employee_supervisor", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployeeSupervisor;
    @JoinColumn(name = "id_employee_sub", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployeeSub;

    public TrsEmployeeReportto() {
    }

    public TrsEmployeeReportto(Integer idReportto) {
        this.idReportto = idReportto;
    }

    public Integer getIdReportto() {
        return idReportto;
    }

    public void setIdReportto(Integer idReportto) {
        this.idReportto = idReportto;
    }

    public Character getMethodeDiret() {
        return methodeDiret;
    }

    public void setMethodeDiret(Character methodeDiret) {
        this.methodeDiret = methodeDiret;
    }

    public TrsEmployee getIdEmployeeSupervisor() {
        return idEmployeeSupervisor;
    }

    public void setIdEmployeeSupervisor(TrsEmployee idEmployeeSupervisor) {
        this.idEmployeeSupervisor = idEmployeeSupervisor;
    }

    public TrsEmployee getIdEmployeeSub() {
        return idEmployeeSub;
    }

    public void setIdEmployeeSub(TrsEmployee idEmployeeSub) {
        this.idEmployeeSub = idEmployeeSub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReportto != null ? idReportto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeReportto)) {
            return false;
        }
        TrsEmployeeReportto other = (TrsEmployeeReportto) object;
        if ((this.idReportto == null && other.idReportto != null) || (this.idReportto != null && !this.idReportto.equals(other.idReportto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeReportto[ idReportto=" + idReportto + " ]";
    }
    
}
