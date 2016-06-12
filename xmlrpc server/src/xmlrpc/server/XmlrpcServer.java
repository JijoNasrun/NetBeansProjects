/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlrpc.server;
import java.util.*;
import org.apache.xmlrpc.*;

/**
 *
 * @author jijonasrun
 */
public class XmlrpcServer {

    /**
     * @param args the command line arguments
     */
    public static void main (String [] args) {
   
      try {
         XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
         Vector params = new Vector();
         
         params.addElement(new Integer(17));
         params.addElement(new Integer(13));

         Object result = server.execute("sample.sum", params);

         int sum = ((Integer) result).intValue();
         System.out.println("The sum is: "+ sum);

      } catch (Exception exception) {
         System.err.println("JavaClient: " + exception);
      }
   }
}