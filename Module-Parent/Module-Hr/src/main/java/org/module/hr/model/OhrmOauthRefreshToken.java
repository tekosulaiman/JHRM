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
@Table(name = "ohrm_oauth_refresh_token", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOauthRefreshToken.findAll", query = "SELECT o FROM OhrmOauthRefreshToken o"),
    @NamedQuery(name = "OhrmOauthRefreshToken.findByRefreshToken", query = "SELECT o FROM OhrmOauthRefreshToken o WHERE o.refreshToken = :refreshToken"),
    @NamedQuery(name = "OhrmOauthRefreshToken.findByClientId", query = "SELECT o FROM OhrmOauthRefreshToken o WHERE o.clientId = :clientId"),
    @NamedQuery(name = "OhrmOauthRefreshToken.findByUserId", query = "SELECT o FROM OhrmOauthRefreshToken o WHERE o.userId = :userId"),
    @NamedQuery(name = "OhrmOauthRefreshToken.findByExpires", query = "SELECT o FROM OhrmOauthRefreshToken o WHERE o.expires = :expires"),
    @NamedQuery(name = "OhrmOauthRefreshToken.findByScope", query = "SELECT o FROM OhrmOauthRefreshToken o WHERE o.scope = :scope")})
public class OhrmOauthRefreshToken implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "refresh_token")
    private String refreshToken;
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

    public OhrmOauthRefreshToken() {
    }

    public OhrmOauthRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public OhrmOauthRefreshToken(String refreshToken, String clientId, Date expires) {
        this.refreshToken = refreshToken;
        this.clientId = clientId;
        this.expires = expires;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
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
        hash += (refreshToken != null ? refreshToken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmOauthRefreshToken)) {
            return false;
        }
        OhrmOauthRefreshToken other = (OhrmOauthRefreshToken) object;
        if ((this.refreshToken == null && other.refreshToken != null) || (this.refreshToken != null && !this.refreshToken.equals(other.refreshToken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOauthRefreshToken[ refreshToken=" + refreshToken + " ]";
    }
    
}
