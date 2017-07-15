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
import javax.persistence.Id;
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
@Table(name = "ohrm_oauth_access_token", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOauthAccessToken.findAll", query = "SELECT o FROM OhrmOauthAccessToken o"),
    @NamedQuery(name = "OhrmOauthAccessToken.findByAccessToken", query = "SELECT o FROM OhrmOauthAccessToken o WHERE o.accessToken = :accessToken"),
    @NamedQuery(name = "OhrmOauthAccessToken.findByClientId", query = "SELECT o FROM OhrmOauthAccessToken o WHERE o.clientId = :clientId"),
    @NamedQuery(name = "OhrmOauthAccessToken.findByUserId", query = "SELECT o FROM OhrmOauthAccessToken o WHERE o.userId = :userId"),
    @NamedQuery(name = "OhrmOauthAccessToken.findByExpires", query = "SELECT o FROM OhrmOauthAccessToken o WHERE o.expires = :expires"),
    @NamedQuery(name = "OhrmOauthAccessToken.findByScope", query = "SELECT o FROM OhrmOauthAccessToken o WHERE o.scope = :scope")})
public class OhrmOauthAccessToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "access_token")
    private String accessToken;
    @Basic(optional = false)
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @Column(name = "expires")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    @Column(name = "scope")
    private String scope;

    public OhrmOauthAccessToken() {
    }

    public OhrmOauthAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public OhrmOauthAccessToken(String accessToken, String clientId, Date expires) {
        this.accessToken = accessToken;
        this.clientId = clientId;
        this.expires = expires;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessToken != null ? accessToken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmOauthAccessToken)) {
            return false;
        }
        OhrmOauthAccessToken other = (OhrmOauthAccessToken) object;
        if ((this.accessToken == null && other.accessToken != null) || (this.accessToken != null && !this.accessToken.equals(other.accessToken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOauthAccessToken[ accessToken=" + accessToken + " ]";
    }
    
}
