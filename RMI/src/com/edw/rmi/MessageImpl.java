/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edw.rmi;

/**
 *
 * @author jijonasrun
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
 
public class MessageImpl extends UnicastRemoteObject implements Message {
 
    public MessageImpl() throws RemoteException {       
    }
     
    @Override
    public void sayHello(String name) throws RemoteException {
        System.out.println("Hello "+name);
        System.out.println("Anda Babi.");
        System.out.println("Have a nice day.");
    }
     
}