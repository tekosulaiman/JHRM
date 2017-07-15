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
@Table(name = "ohrm_email_subscriber", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmEmailSubscriber.findAll", query = "SELECT o FROM OhrmEmailSubscriber o"),
    @NamedQuery(name = "OhrmEmailSubscriber.findById", query = "SELECT o FROM OhrmEmailSubscriber o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmEmailSubscriber.findByName", query = "SELECT o FROM OhrmEmailSubscriber o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmEmailSubscriber.findByEmail", query = "SELECT o FROM OhrmEmailSubscriber o WHERE o.email = :email")})
public class OhrmEmailSubscriber implements Serializable {
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
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmEmailNotification notificationId;

    public OhrmEmailSubscriber() {
    }

    public OhrmEmailSubscriber(Integer id) {
        this.id = id;
    }

    public OhrmEmailSubscriber(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OhrmEmailNotification getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(OhrmEmailNotification notificationId) {
        this.notificationId = notificationId;
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
        if (!(object instanceof OhrmEmailSubscriber)) {
            return false;
        }
        OhrmEmailSubscriber other = (OhrmEmailSubscriber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmEmailSubscriber[ id=" + id + " ]";
    }
    
}
