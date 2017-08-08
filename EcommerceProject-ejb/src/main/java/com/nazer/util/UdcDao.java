/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.util;

import com.nazer.dao.AbstractFacade;
import com.nazer.util.Udc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class UdcDao extends AbstractFacade<Udc> {

    @PersistenceContext(unitName = "com.mycompany_EcommerceProject-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UdcDao() {
        super(Udc.class);
    }
    
}
