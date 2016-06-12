/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectrpcserver;
import org.apache.xmlrpc.*;
/**
 *
 * @author root
 */
public class ProjectRPCServer {

    
    public double CelciusKelvin(double a){
      return new Double(a+273.15);
    }
      public double CelciusFahrenheit(double a){
      return new Double((a*1.8)+32);
    }
      public double FahrenheitKelvin(double a){
      return new Double((a+459.67)*5/9);
    }
    public double FahrenheitCelcius(double a){
      return new Double((a - 32) / 1.8);
    }
    public double KelvinCelcius(double a){
      return new Double(a - 273.15);
    }
    public double KelvinFahrenheit(double a){
      return new Double((a-273.15)* 1.8 + 32.00);
   }
    public double AtmosPascal(double a){
        return new Double(a*101325);
    }
    
    public double AtmosPSI(double a){
        return new Double(a*14.6959488);
    }
    
    public double PascalAtmos(double a){
        return new Double(a/101325);
    }
    
    public double PascalPSI(double a){
        return new Double(a*0.000145037);
    }
    
    public double PSIAtmos(double a) {
        return new Double(a*0.0680459639);
    }
    
    public double PSIPascal(double a){
        return new Double(a*6894.75729);
    }
    
    
    
    public static void main(String[] args) {
       try {

         System.out.println("Attempting to start XML-RPC Server...");
         
         WebServer server = new WebServer(80);
         server.addHandler("converter", new ProjectRPCServer());
         server.start();
         
         System.out.println("Started successfully.");
         System.out.println("Accepting requests. (Halt program to stop.)");
         
      } catch (Exception exception){
         System.err.println("JavaServer: " + exception);
      }
    }
}
    

