/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectrmi;
import converter.converterImp;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author root
 */
public class ProjectRMI {
    
    private void startServer(){
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("converter", new converterImp());
            
            System.out.println("system is ready");
             
        } catch (Exception e) {
        }     
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProjectRMI main = new ProjectRMI();
        main.startServer();
    }
    
}
