/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author root
 */
public class converterImp extends UnicastRemoteObject implements converter {
    

    
    public converterImp() throws RemoteException
    {
         
    }
              
       double convert;
       
 
    @Override
    public double CelciusKelvin(double a) throws RemoteException {
        convert = a+273.15;
        System.out.println("masuk");
        return convert;
    }

    @Override
    public double CelciusFahrenheit(double a) throws RemoteException {
       convert = (a*1.8)+32;
       return convert;
    }

    @Override
    public double FahrenheitKelvin(double a) throws RemoteException {
        convert = (a+459.67)*5/9;
        return convert;
    }

    @Override
    public double FahrenheitCelcius(double a) throws RemoteException {
        convert= (a - 32) / 1.8;
        return convert;
    }

    @Override
    public double KelvinCelcius(double a) throws RemoteException {
        convert = a - 273.15;
        return convert;
    }

    @Override
    public double KelvinFahrenheit(double a) throws RemoteException {
        convert=(a-273.15)* 1.8 + 32.00;
        return convert;
    }

    @Override
    public double AtmosPascal(double a) throws RemoteException {
        convert = a*101325;
        return convert;
    }

    @Override
    public double AtmosPSI(double a) throws RemoteException {
       convert = a*14.6959488;
       return convert;
    }

    @Override
    public double PascalAtmos(double a) throws RemoteException {
       convert = a/101325; 
       return convert;
    }

    @Override
    public double PascalPSI(double a) throws RemoteException {
        convert=a*0.000145037;
        return convert;
    }

    @Override
    public double PSIAtmos(double a) throws RemoteException {
        convert = a*0.0680459639;
        return convert;
    }

    @Override
    public double PSIPascal(double a) throws RemoteException {
       convert =a*6894.75729;
       return convert; 
    }
       
    }
  
    
   
