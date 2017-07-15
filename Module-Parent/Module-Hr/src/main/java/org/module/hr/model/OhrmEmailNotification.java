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
@Table(name = "ohrm_email_notification", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmailNotification.findAll", query = "SELECT o FROM OhrmEmailNotification o"),
    @NamedQuery(name = "OhrmEmailNotification.findById", query = "SELECT o FROM OhrmEmailNotification o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmEmailNotification.findByName", query = "SELECT o FROM OhrmEmailNotification o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmEmailNotification.findByIsEnable", query = "SELECT o FROM OhrmEmailNotification o WHERE o.isEnable = :isEnable")})
public class OhrmEmailNotification implements Serializable {
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
    @Column(name = "is_enable")
    private int isEnable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationId")
    private List<OhrmEmailSubscriber> ohrmEmailSubscriberList;

    public OhrmEmailNotification() {
    }

    public OhrmEmailNotification(Integer id) {
        this.id = id;
    }

    public OhrmEmailNotification(Integer id, String name, int isEnable) {
        this.id = id;
        this.name = name;
        this.isEnable = isEnable;
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

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    @XmlTransient
    public List<OhrmEmailSubscriber> getOhrmEmailSubscriberList() {
        return ohrmEmailSubscriberList;
    }

    public void setOhrmEmailSubscriberList(List<OhrmEmailSubscriber> ohrmEmailSubscriberList) {
        this.ohrmEmailSubscriberList = ohrmEmailSubscriberList;
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
        if (!(object instanceof OhrmEmailNotification)) {
            return false;
        }
        OhrmEmailNotification other = (OhrmEmailNotification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmailNotification[ id=" + id + " ]";
    }
    
}
