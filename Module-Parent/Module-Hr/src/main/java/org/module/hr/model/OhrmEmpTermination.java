/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_emp_termination", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmpTermination.findAll", query = "SELECT o FROM OhrmEmpTermination o"),
    @NamedQuery(name = "OhrmEmpTermination.findById", query = "SELECT o FROM OhrmEmpTermination o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmEmpTermination.findByTerminationDate", query = "SELECT o FROM OhrmEmpTermination o WHERE o.terminationDate = :terminationDate"),
    @NamedQuery(name = "OhrmEmpTermination.findByNote", query = "SELECT o FROM OhrmEmpTermination o WHERE o.note = :note")})
public class OhrmEmpTermination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "termination_date")
    @Temporal(TemporalType.DATE)
    private Date terminationDate;
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "terminationId")
    private List<HsHrEmployee> hsHrEmployeeList;
    @JoinColumn(name = "reason_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmEmpTerminationReason reasonId;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee empNumber;

    public OhrmEmpTermination() {
    }

    public OhrmEmpTermination(Integer id) {
        this.id = id;
    }

    public OhrmEmpTermination(Integer id, Date terminationDate) {
        this.id = id;
        this.terminationDate = terminationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public List<HsHrEmployee> getHsHrEmployeeList() {
        return hsHrEmployeeList;
    }

    public void setHsHrEmployeeList(List<HsHrEmployee> hsHrEmployeeList) {
        this.hsHrEmployeeList = hsHrEmployeeList;
    }

    public OhrmEmpTerminationReason getReasonId() {
        return reasonId;
    }

    public void setReasonId(OhrmEmpTerminationReason reasonId) {
        this.reasonId = reasonId;
    }

    public HsHrEmployee getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(HsHrEmployee empNumber) {
        this.empNumber = empNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmEmpTermination)) {
            return false;
        }
        OhrmEmpTermination other = (OhrmEmpTermination) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmpTermination[ id=" + id + " ]";
    }
    
}
