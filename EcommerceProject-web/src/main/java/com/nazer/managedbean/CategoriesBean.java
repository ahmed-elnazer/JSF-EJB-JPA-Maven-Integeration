/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.managedbean;

import com.nazer.entity.Categories;
import com.nazer.management.EcommerceManagement;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author user
 */
@ViewScoped
@ManagedBean(name = "categoriesBean")
public class CategoriesBean {

    /**
     * Creates a new instance of CategoriesBean
     */
    public CategoriesBean() {
        
    }

    private Categories cat;

   
    
    @EJB
    EcommerceManagement ecommm;

    @PostConstruct
    public void getAllCategoriesList() {
        cat = new Categories();

    }
    
     public Categories getCat() {
        return cat;
    }

    public void setCat(Categories cat) {
        this.cat = cat;
    }
    
    public void addCategory(){
    
         ecommm.addCategory(cat);
    }

}
