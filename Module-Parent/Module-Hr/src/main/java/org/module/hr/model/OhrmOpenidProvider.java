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
@Table(name = "ohrm_openid_provider", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOpenidProvider.findAll", query = "SELECT o FROM OhrmOpenidProvider o"),
    @NamedQuery(name = "OhrmOpenidProvider.findById", query = "SELECT o FROM OhrmOpenidProvider o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmOpenidProvider.findByProviderName", query = "SELECT o FROM OhrmOpenidProvider o WHERE o.providerName = :providerName"),
    @NamedQuery(name = "OhrmOpenidProvider.findByProviderUrl", query = "SELECT o FROM OhrmOpenidProvider o WHERE o.providerUrl = :providerUrl"),
    @NamedQuery(name = "OhrmOpenidProvider.findByStatus", query = "SELECT o FROM OhrmOpenidProvider o WHERE o.status = :status")})
public class OhrmOpenidProvider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "provider_name")
    private String providerName;
    @Column(name = "provider_url")
    private String providerUrl;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerId")
    private List<OhrmAuthProviderExtraDetails> ohrmAuthProviderExtraDetailsList;

    public OhrmOpenidProvider() {
    }

    public OhrmOpenidProvider(Integer id) {
        this.id = id;
    }

    public OhrmOpenidProvider(Integer id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<OhrmAuthProviderExtraDetails> getOhrmAuthProviderExtraDetailsList() {
        return ohrmAuthProviderExtraDetailsList;
    }

    public void setOhrmAuthProviderExtraDetailsList(List<OhrmAuthProviderExtraDetails> ohrmAuthProviderExtraDetailsList) {
        this.ohrmAuthProviderExtraDetailsList = ohrmAuthProviderExtraDetailsList;
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
        if (!(object instanceof OhrmOpenidProvider)) {
            return false;
        }
        OhrmOpenidProvider other = (OhrmOpenidProvider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOpenidProvider[ id=" + id + " ]";
    }
    
}
