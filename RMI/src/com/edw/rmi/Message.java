/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author jijonasrun
 */
public interface Message extends Remote{
    
void sayHello(String name) throws RemoteException;
    
}
