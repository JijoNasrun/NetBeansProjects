/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javacodegeeks.example.service;

import com.javacodegeeks.example.entity.Customer;
import javax.ejb.Remote;

/**
 *
 * @author jijonasrun
 */
@Remote
public interface AccountServiceRemote {

    Customer createAccount(String firstName, String lastName);
    
}
