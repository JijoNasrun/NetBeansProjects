/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorws_client_application;

import java.util.Scanner;

/**
 *
 * @author jijonasrun
 */
public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Scanner reader = new Scanner(System.in);
            System.out.println("INSERT FIRST NUMBER");
            int i=reader.nextInt();
            System.out.println("INSERT SECOND NUMBER");
            int j=reader.nextInt();
            int result=operation(i,j);
            System.out.println("RESULT:"+result);
        }
        catch(Exception ex)
        {
            System.out.println("Exception: " + ex);
        }
        
       
    }

    private static int operation(int i, int j) {
        com.mycompany.calculatorwsapplication.CalculatorWS_Service service = new com.mycompany.calculatorwsapplication.CalculatorWS_Service();
        com.mycompany.calculatorwsapplication.CalculatorWS port = service.getCalculatorWSPort();
        return port.operation(i, j);
    }
    
}
