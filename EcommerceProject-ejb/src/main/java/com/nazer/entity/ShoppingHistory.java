/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "shoppingHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingHistory.findAll", query = "SELECT s FROM ShoppingHistory s"),
    @NamedQuery(name = "ShoppingHistory.findByCreationTime", query = "SELECT s FROM ShoppingHistory s WHERE s.creationTime = :creationTime"),
    @NamedQuery(name = "ShoppingHistory.findByShoppinghistoryId", query = "SELECT s FROM ShoppingHistory s WHERE s.shoppinghistoryId = :shoppinghistoryId"),
    @NamedQuery(name = "ShoppingHistory.findByDeleted", query = "SELECT s FROM ShoppingHistory s WHERE s.deleted = :deleted")})
public class ShoppingHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "creationTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shoppinghistoryId")
    private Long shoppinghistoryId;
    @Column(name = "deleted")
    private Integer deleted;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne
    private Users userId;
    @JoinColumn(name = "itemId", referencedColumnName = "itemId")
    @ManyToOne
    private Items itemId;

    public ShoppingHistory() {
    }

    public ShoppingHistory(Long shoppinghistoryId) {
        this.shoppinghistoryId = shoppinghistoryId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Long getShoppinghistoryId() {
        return shoppinghistoryId;
    }

    public void setShoppinghistoryId(Long shoppinghistoryId) {
        this.shoppinghistoryId = shoppinghistoryId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Items getItemId() {
        return itemId;
    }

    public void setItemId(Items itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppinghistoryId != null ? shoppinghistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingHistory)) {
            return false;
        }
        ShoppingHistory other = (ShoppingHistory) object;
        if ((this.shoppinghistoryId == null && other.shoppinghistoryId != null) || (this.shoppinghistoryId != null && !this.shoppinghistoryId.equals(other.shoppinghistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nazer.entity.ShoppingHistory[ shoppinghistoryId=" + shoppinghistoryId + " ]";
    }
    
}
