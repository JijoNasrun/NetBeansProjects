/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author root
 */
public class gradingImp extends UnicastRemoteObject implements SysGrade {
    
     public gradingImp() throws RemoteException {       
    }

    @Override
    public String calculateGrade(int a, int b, int c) throws RemoteException {
        int result = a+b+c;
        String grade;
        if((result <= 100)&&(result>=90))
       {    grade = "A+";   }
       else if((result>=80)&&(result<=89))
       {    grade = "A";    }
       else if((result>=70)&&(result<=79))
       {    grade = "A-";   }
       else if((result>=66)&&(result<=69))
       {   grade = "B+";    }
        else if ((result >= 60) && (result <= 65))
        {   grade = "B";    }
        else if ((result >= 50) && (result <= 59)) {
            grade = "C";
        }
        else if ((result >= 40) && (result <= 49)) {
            grade = "C-";
        }
       else
            grade="FAILED";
        return grade;
        
    }
    
}
