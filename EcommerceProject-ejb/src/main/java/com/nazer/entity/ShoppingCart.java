/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "shoppingCart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingCart.findAll", query = "SELECT s FROM ShoppingCart s"),
    @NamedQuery(name = "ShoppingCart.findByShoppingCartId", query = "SELECT s FROM ShoppingCart s WHERE s.shoppingCartId = :shoppingCartId"),
    
    @NamedQuery(name = "ShoppingCart.findByItemPrice", query = "SELECT s FROM ShoppingCart s WHERE s.itemPrice = :itemPrice"),
    @NamedQuery(name = "ShoppingCart.findByItemPriceCurrency", query = "SELECT s FROM ShoppingCart s WHERE s.itemPriceCurrency = :itemPriceCurrency"),
    @NamedQuery(name = "ShoppingCart.findByDeleted", query = "SELECT s FROM ShoppingCart s WHERE s.deleted = :deleted")})
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shoppingCartId")
    private Long shoppingCartId;
    
    @Column(name = "itemPrice")
    private Integer itemPrice;
    @Size(max = 100)
    @Column(name = "itemPriceCurrency")
    private String itemPriceCurrency;
    @Column(name = "deleted")
    private Integer deleted;
    @ManyToMany(mappedBy = "shoppingCartCollection")
    private Collection<Items> itemsCollection;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne
    private Users userId;

    public ShoppingCart() {
    }

    public ShoppingCart(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

   

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemPriceCurrency() {
        return itemPriceCurrency;
    }

    public void setItemPriceCurrency(String itemPriceCurrency) {
        this.itemPriceCurrency = itemPriceCurrency;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public Collection<Items> getItemsCollection() {
        return itemsCollection;
    }

    public void setItemsCollection(Collection<Items> itemsCollection) {
        this.itemsCollection = itemsCollection;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoppingCartId != null ? shoppingCartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingCart)) {
            return false;
        }
        ShoppingCart other = (ShoppingCart) object;
        if ((this.shoppingCartId == null && other.shoppingCartId != null) || (this.shoppingCartId != null && !this.shoppingCartId.equals(other.shoppingCartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nazer.entity.ShoppingCart[ shoppingCartId=" + shoppingCartId + " ]";
    }
    
}
