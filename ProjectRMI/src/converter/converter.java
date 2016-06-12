/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 *
 * @author root
 */
public interface converter extends Remote{
    
    double CelciusKelvin (double a) throws RemoteException;
    double CelciusFahrenheit (double a) throws RemoteException;
    double FahrenheitKelvin (double a) throws RemoteException;
    double FahrenheitCelcius (double a) throws RemoteException;
    double KelvinCelcius (double a) throws RemoteException;
    double KelvinFahrenheit (double a) throws RemoteException;
    double AtmosPascal (double a) throws RemoteException;
    double AtmosPSI (double a) throws RemoteException;
    double PascalAtmos  (double a) throws RemoteException;
    double PascalPSI  (double a) throws RemoteException;
    double PSIAtmos  (double a) throws RemoteException;
    double PSIPascal  (double a) throws RemoteException;
    
    
}
