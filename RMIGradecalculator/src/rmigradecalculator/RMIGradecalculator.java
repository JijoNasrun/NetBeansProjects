/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmigradecalculator;

import rmi.gradingImp;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class RMIGradecalculator {

   private void startServer()
   {
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1098);

            // create a new service named myMessage

            registry.rebind("mygrade", new gradingImp());
            
        } catch (Exception e) {
        }
        System.out.println("system is ready");
    }
   
   
    public static void main(String[] args) {
        RMIGradecalculator client = new RMIGradecalculator();
  
        client.startServer();
    }
    
}
