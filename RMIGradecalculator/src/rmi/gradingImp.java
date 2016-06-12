/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.*;
import java.util.Scanner;



public class gradingImp extends UnicastRemoteObject implements grading {
    
    
    public gradingImp() throws RemoteException{
        
            
            List<String> subject = new ArrayList<>();
       
            String agree ="yes";
            int subject_pointer =0;
            Scanner sc = new Scanner (System.in);
            
            while(agree.equalsIgnoreCase("yes"))
            {
                System.out.println("Enter your subject name");
                subject.add(sc.nextLine());
                subject_pointer=+1;
                System.out.println("Is there any subject more? (yes/no)");
                agree = sc.nextLine();
                
            }
            
            int len = subject.size();
            List<String> grades = new ArrayList<>();
            
            for(int x=0;x<len;x++)
            {
                int carrymark;
                int finalmark;
                int markah_kesian;
                
                System.out.println("Subject :"+subject.get(x));
                
                System.out.println("Enter Carry mark:");
                carrymark=sc.nextInt();
                System.out.println("Enter Final mark:");
                finalmark=sc.nextInt();
                System.out.println("Enter Markah Kesian:");
                markah_kesian=sc.nextInt();
                String g = grading(carrymark,finalmark,markah_kesian);
                grades.add(g);
                
                System.out.println (subject.get(x)+" "+g);
            }
           
   
            
           
            
            
}

    @Override
    public String grading(int a, int b, int c) throws RemoteException {
       int result = a+b+c;
       String grade = null;
       
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
       System.out.println(grade);
       return grade;

    
}
}
