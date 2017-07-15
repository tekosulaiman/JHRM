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
@Table(name = "ohrm_menu_item", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmMenuItem.findAll", query = "SELECT o FROM OhrmMenuItem o"),
    @NamedQuery(name = "OhrmMenuItem.findById", query = "SELECT o FROM OhrmMenuItem o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmMenuItem.findByMenuTitle", query = "SELECT o FROM OhrmMenuItem o WHERE o.menuTitle = :menuTitle"),
    @NamedQuery(name = "OhrmMenuItem.findByParentId", query = "SELECT o FROM OhrmMenuItem o WHERE o.parentId = :parentId"),
    @NamedQuery(name = "OhrmMenuItem.findByLevel", query = "SELECT o FROM OhrmMenuItem o WHERE o.level = :level"),
    @NamedQuery(name = "OhrmMenuItem.findByOrderHint", query = "SELECT o FROM OhrmMenuItem o WHERE o.orderHint = :orderHint"),
    @NamedQuery(name = "OhrmMenuItem.findByUrlExtras", query = "SELECT o FROM OhrmMenuItem o WHERE o.urlExtras = :urlExtras"),
    @NamedQuery(name = "OhrmMenuItem.findByStatus", query = "SELECT o FROM OhrmMenuItem o WHERE o.status = :status")})
public class OhrmMenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "menu_title")
    private String menuTitle;
    @Column(name = "parent_id")
    private Integer parentId;
    @Basic(optional = false)
    @Column(name = "level")
    private short level;
    @Basic(optional = false)
    @Column(name = "order_hint")
    private int orderHint;
    @Column(name = "url_extras")
    private String urlExtras;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmScreen screenId;

    public OhrmMenuItem() {
    }

    public OhrmMenuItem(Integer id) {
        this.id = id;
    }

    public OhrmMenuItem(Integer id, String menuTitle, short level, int orderHint, short status) {
        this.id = id;
        this.menuTitle = menuTitle;
        this.level = level;
        this.orderHint = orderHint;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public int getOrderHint() {
        return orderHint;
    }

    public void setOrderHint(int orderHint) {
        this.orderHint = orderHint;
    }

    public String getUrlExtras() {
        return urlExtras;
    }

    public void setUrlExtras(String urlExtras) {
        this.urlExtras = urlExtras;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public OhrmScreen getScreenId() {
        return screenId;
    }

    public void setScreenId(OhrmScreen screenId) {
        this.screenId = screenId;
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
        if (!(object instanceof OhrmMenuItem)) {
            return false;
        }
        OhrmMenuItem other = (OhrmMenuItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmMenuItem[ id=" + id + " ]";
    }
    
}
