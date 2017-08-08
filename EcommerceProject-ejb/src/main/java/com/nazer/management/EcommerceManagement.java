/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.management;

import com.nazer.entity.Categories;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author user
 */
@Local
public interface EcommerceManagement {
    public void addCategory(Categories cat);
}
