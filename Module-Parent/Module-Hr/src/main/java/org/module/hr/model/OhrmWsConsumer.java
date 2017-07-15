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
@Table(name = "ohrm_ws_consumer", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmWsConsumer.findAll", query = "SELECT o FROM OhrmWsConsumer o"),
    @NamedQuery(name = "OhrmWsConsumer.findByAppId", query = "SELECT o FROM OhrmWsConsumer o WHERE o.appId = :appId"),
    @NamedQuery(name = "OhrmWsConsumer.findByAppToken", query = "SELECT o FROM OhrmWsConsumer o WHERE o.appToken = :appToken"),
    @NamedQuery(name = "OhrmWsConsumer.findByAppName", query = "SELECT o FROM OhrmWsConsumer o WHERE o.appName = :appName"),
    @NamedQuery(name = "OhrmWsConsumer.findByStatus", query = "SELECT o FROM OhrmWsConsumer o WHERE o.status = :status")})
public class OhrmWsConsumer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "app_id")
    private Integer appId;
    @Basic(optional = false)
    @Column(name = "app_token")
    private String appToken;
    @Column(name = "app_name")
    private String appName;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;

    public OhrmWsConsumer() {
    }

    public OhrmWsConsumer(Integer appId) {
        this.appId = appId;
    }

    public OhrmWsConsumer(Integer appId, String appToken, short status) {
        this.appId = appId;
        this.appToken = appToken;
        this.status = status;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appId != null ? appId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmWsConsumer)) {
            return false;
        }
        OhrmWsConsumer other = (OhrmWsConsumer) object;
        if ((this.appId == null && other.appId != null) || (this.appId != null && !this.appId.equals(other.appId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmWsConsumer[ appId=" + appId + " ]";
    }
    
}
