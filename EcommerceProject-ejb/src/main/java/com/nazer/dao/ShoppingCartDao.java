/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.dao;

import com.nazer.entity.ShoppingCart;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class ShoppingCartDao extends AbstractFacade<ShoppingCart> {

    @PersistenceContext(unitName = "com.mycompany_EcommerceProject-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShoppingCartDao() {
        super(ShoppingCart.class);
    }
    
}
