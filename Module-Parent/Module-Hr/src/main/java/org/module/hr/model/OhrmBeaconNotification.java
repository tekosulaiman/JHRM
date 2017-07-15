/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_beacon_notification", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmBeaconNotification.findAll", query = "SELECT o FROM OhrmBeaconNotification o"),
    @NamedQuery(name = "OhrmBeaconNotification.findById", query = "SELECT o FROM OhrmBeaconNotification o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmBeaconNotification.findByName", query = "SELECT o FROM OhrmBeaconNotification o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmBeaconNotification.findByExpiryDate", query = "SELECT o FROM OhrmBeaconNotification o WHERE o.expiryDate = :expiryDate")})
public class OhrmBeaconNotification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    @Basic(optional = false)
    @Lob
    @Column(name = "definition")
    private String definition;

    public OhrmBeaconNotification() {
    }

    public OhrmBeaconNotification(Integer id) {
        this.id = id;
    }

    public OhrmBeaconNotification(Integer id, String name, Date expiryDate, String definition) {
        this.id = id;
        this.name = name;
        this.expiryDate = expiryDate;
        this.definition = definition;
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
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
        if (!(object instanceof OhrmBeaconNotification)) {
            return false;
        }
        OhrmBeaconNotification other = (OhrmBeaconNotification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmBeaconNotification[ id=" + id + " ]";
    }
    
}
