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
@Table(name = "trs_employee_salary", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEmployeeSalary.findAll", query = "SELECT t FROM TrsEmployeeSalary t"),
    @NamedQuery(name = "TrsEmployeeSalary.findByIdSalary", query = "SELECT t FROM TrsEmployeeSalary t WHERE t.idSalary = :idSalary")})
public class TrsEmployeeSalary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_salary")
    private Integer idSalary;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;
    @Column(name = "pay_grade")
    private String payGrade;
    @Column(name = "salary_component")
    private String salaryComponent;
    @Column(name = "pay_frequency")
    private String payFrequency;
    @Column(name = "currency")
    private String currency;
    @Column(name = "amount")
    private String amount;
    @Column(name = "comment")
    private String comment;

    public TrsEmployeeSalary() {
    }

    public TrsEmployeeSalary(Integer idSalary) {
        this.idSalary = idSalary;
    }

    public Integer getIdSalary() {
        return idSalary;
    }

    public void setIdSalary(Integer idSalary) {
        this.idSalary = idSalary;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }
    
    public String getPayGrade() {
		return payGrade;
	}

	public void setPayGrade(String payGrade) {
		this.payGrade = payGrade;
	}

	public String getSalaryComponent() {
		return salaryComponent;
	}

	public void setSalaryComponent(String salaryComponent) {
		this.salaryComponent = salaryComponent;
	}

	public String getPayFrequency() {
		return payFrequency;
	}

	public void setPayFrequency(String payFrequency) {
		this.payFrequency = payFrequency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalary != null ? idSalary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEmployeeSalary)) {
            return false;
        }
        TrsEmployeeSalary other = (TrsEmployeeSalary) object;
        if ((this.idSalary == null && other.idSalary != null) || (this.idSalary != null && !this.idSalary.equals(other.idSalary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEmployeeSalary[ idSalary=" + idSalary + " ]";
    }
    
}
