/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemgrade;
import com.rmi.gradingImp;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author root
 */
public class SystemGrade {
 private void serverGrade(){
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1098);
             
            // create a new service named myMessage
            registry.rebind("mygrade", new gradingImp());
        } catch (Exception e) {
            e.printStackTrace();
        }     
        System.out.println("system is ready");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SystemGrade main = new SystemGrade();
        main.serverGrade();
    }
    
}
