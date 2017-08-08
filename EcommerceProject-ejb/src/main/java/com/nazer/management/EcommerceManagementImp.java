/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.management;


import com.nazer.entity.Categories;
import com.nazer.service.CategoriesService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author user
 */
@Stateless
public class EcommerceManagementImp implements EcommerceManagement{
@EJB
CategoriesService catService;
    @Override
    public void addCategory(Categories cat) {
            System.out.println("i am here now in EcommerceManagementImp");
            catService.addCategory(cat);
            
    }

}
