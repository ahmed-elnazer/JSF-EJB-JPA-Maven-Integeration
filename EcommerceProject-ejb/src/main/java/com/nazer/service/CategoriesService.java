/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.service;

import com.nazer.dao.CategoriesDao;
import com.nazer.entity.Categories;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class CategoriesService {

   @EJB
   CategoriesDao categoryDao;
   public void addCategory(Categories cat){
   
     categoryDao.create(cat);
       System.out.println(" cat added success");
   }

}
