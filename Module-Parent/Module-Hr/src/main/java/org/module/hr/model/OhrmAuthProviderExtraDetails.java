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
import javax.persistence.Lob;
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
@Table(name = "ohrm_auth_provider_extra_details", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmAuthProviderExtraDetails.findAll", query = "SELECT o FROM OhrmAuthProviderExtraDetails o"),
    @NamedQuery(name = "OhrmAuthProviderExtraDetails.findById", query = "SELECT o FROM OhrmAuthProviderExtraDetails o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmAuthProviderExtraDetails.findByProviderType", query = "SELECT o FROM OhrmAuthProviderExtraDetails o WHERE o.providerType = :providerType")})
public class OhrmAuthProviderExtraDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "provider_type")
    private Integer providerType;
    @Lob
    @Column(name = "client_id")
    private String clientId;
    @Lob
    @Column(name = "client_secret")
    private String clientSecret;
    @Lob
    @Column(name = "developer_key")
    private String developerKey;
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmOpenidProvider providerId;

    public OhrmAuthProviderExtraDetails() {
    }

    public OhrmAuthProviderExtraDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProviderType() {
        return providerType;
    }

    public void setProviderType(Integer providerType) {
        this.providerType = providerType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getDeveloperKey() {
        return developerKey;
    }

    public void setDeveloperKey(String developerKey) {
        this.developerKey = developerKey;
    }

    public OhrmOpenidProvider getProviderId() {
        return providerId;
    }

    public void setProviderId(OhrmOpenidProvider providerId) {
        this.providerId = providerId;
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
        if (!(object instanceof OhrmAuthProviderExtraDetails)) {
            return false;
        }
        OhrmAuthProviderExtraDetails other = (OhrmAuthProviderExtraDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmAuthProviderExtraDetails[ id=" + id + " ]";
    }
    
}
