/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_pay_grade", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmPayGrade.findAll", query = "SELECT o FROM OhrmPayGrade o"),
    @NamedQuery(name = "OhrmPayGrade.findById", query = "SELECT o FROM OhrmPayGrade o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmPayGrade.findByName", query = "SELECT o FROM OhrmPayGrade o WHERE o.name = :name")})
public class OhrmPayGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "salGrdCode")
    private List<HsHrEmpBasicsalary> hsHrEmpBasicsalaryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmPayGrade")
    private List<OhrmPayGradeCurrency> ohrmPayGradeCurrencyList;

    public OhrmPayGrade() {
    }

    public OhrmPayGrade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<HsHrEmpBasicsalary> getHsHrEmpBasicsalaryList() {
        return hsHrEmpBasicsalaryList;
    }

    public void setHsHrEmpBasicsalaryList(List<HsHrEmpBasicsalary> hsHrEmpBasicsalaryList) {
        this.hsHrEmpBasicsalaryList = hsHrEmpBasicsalaryList;
    }

    @XmlTransient
    public List<OhrmPayGradeCurrency> getOhrmPayGradeCurrencyList() {
        return ohrmPayGradeCurrencyList;
    }

    public void setOhrmPayGradeCurrencyList(List<OhrmPayGradeCurrency> ohrmPayGradeCurrencyList) {
        this.ohrmPayGradeCurrencyList = ohrmPayGradeCurrencyList;
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
        if (!(object instanceof OhrmPayGrade)) {
            return false;
        }
        OhrmPayGrade other = (OhrmPayGrade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmPayGrade[ id=" + id + " ]";
    }
    
}
