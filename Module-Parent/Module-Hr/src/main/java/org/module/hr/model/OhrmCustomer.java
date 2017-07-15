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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_customer", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmCustomer.findAll", query = "SELECT o FROM OhrmCustomer o"),
    @NamedQuery(name = "OhrmCustomer.findByCustomerId", query = "SELECT o FROM OhrmCustomer o WHERE o.customerId = :customerId"),
    @NamedQuery(name = "OhrmCustomer.findByName", query = "SELECT o FROM OhrmCustomer o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmCustomer.findByDescription", query = "SELECT o FROM OhrmCustomer o WHERE o.description = :description"),
    @NamedQuery(name = "OhrmCustomer.findByIsDeleted", query = "SELECT o FROM OhrmCustomer o WHERE o.isDeleted = :isDeleted")})
public class OhrmCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public OhrmCustomer() {
    }

    public OhrmCustomer(Integer customerId) {
        this.customerId = customerId;
    }

    public OhrmCustomer(Integer customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmCustomer)) {
            return false;
        }
        OhrmCustomer other = (OhrmCustomer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmCustomer[ customerId=" + customerId + " ]";
    }
    
}
