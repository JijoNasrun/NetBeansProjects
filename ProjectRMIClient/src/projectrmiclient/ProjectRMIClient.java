/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectrmiclient;

/**
 *
 * @author root
 */
import converter.converter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProjectRMIClient extends JFrame implements ActionListener {
    
    double n1 = 0.0;
    double  d1;
    JButton jb[] = new JButton[24];
    JTextField tf;
    Container con;
    int button,i;
    String str;
    String num="";
    JPanel tp,bp; //declaring 2 panels for textfield and buttons
    
    public ProjectRMIClient(){
                   setTitle("Temperature & Pressure Converter");
                   tp = new JPanel();
                   bp = new JPanel();
                   tf = new JTextField(22);
                   tf.setEditable(false);
                   con = getContentPane();
                   bp.setLayout(new GridLayout(5,4));
                   tp.add(tf);
                   con.add(tp,"North");                  //placing the textfield in the north
                   for(int i=0;i<10;i++)                    //inserting and numbering buttons
                    {       
                        jb[i] = new JButton(""+i);
                    }
                   jb[10] = new JButton(".");
                   jb[11] = new JButton("clear");
                   jb[12] = new JButton("C~K");
                   jb[13] = new JButton("C~F");
                   jb[14] = new JButton("K~C");
                   jb[15] = new JButton("K~F");
                   jb[16] = new JButton("F~C");
                   jb[17] = new JButton("F~K");
                   jb[18] = new JButton("A~Pas");
                   jb[19] = new JButton("A~PSI");
                   jb[20] = new JButton("Pas~A");
                   jb[21] = new JButton("Pas~PSI");
                   jb[22] = new JButton("PSI~A");
                   jb[23] = new JButton("PSI~Pas");
                   
                   for(int i = 0;i<24;i++)
{
                             jb[i].addActionListener(this);
                             bp.add(jb[i]);
                             }
                   con.add(bp,"Center"); //placing the panel with the buttons in the center
                   setDefaultCloseOperation(EXIT_ON_CLOSE);
                   }     
    public void actionPerformed(ActionEvent ae)
    {  
        str = ae.getActionCommand();             //get the text on the button
        System.out.println(str);
        for(int i=0;i<10;i++)
        {
            if(ae.getSource()==jb[i])
            {
                num = num+str;     //if the button clicked is a number,
                tf.setText(num);     // concatenate it to the string “num”
            }
        }
            if((ae.getSource())==jb[10])                 //if the button pressed is “.”
            {
                num = num+str;                         //concatenate it to num
                tf.setText(num);
            }
            
            if(ae.getSource()==jb[12])          //if the button pressed is “C~K”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.CelciusKelvin(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Kelvin");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
             if(ae.getSource()==jb[13])          //if the button pressed is “C~F”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.CelciusFahrenheit(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Fahrenheit");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
             if(ae.getSource()==jb[14])          //if the button pressed is “K~C”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.KelvinCelcius(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Celcius");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            } 
             if(ae.getSource()==jb[15])          //if the button pressed is “K~F”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.KelvinFahrenheit(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Fahrenheit");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
             if(ae.getSource()==jb[16])          //if the button pressed is “F~C”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.FahrenheitCelcius(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Celcius");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
             if(ae.getSource()==jb[17])          //if the button pressed is “F~K”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.FahrenheitKelvin(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Kelvin");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
            if(ae.getSource()==jb[18])          //if the button pressed is “A~Pas”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.AtmosPascal(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Pascal");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
            if(ae.getSource()==jb[19])          //if the button pressed is “A~PSI”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.AtmosPSI(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" PSI");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
            if(ae.getSource()==jb[20])          //if the button pressed is “Pas~A”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.PascalAtmos(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Atmospheric");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
            if(ae.getSource()==jb[21])          //if the button pressed is “Pas~PSI”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.PascalPSI(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" PSI");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
            if(ae.getSource()==jb[22])          //if the button pressed is “PSI~A”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.PSIAtmos(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Atmospheric");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
            if(ae.getSource()==jb[23])          //if the button pressed is “PSI~Pas”
            {
                if(!(tf.getText().equals("")))
                {
                tf.setText("");
                n1 = Double.parseDouble(num);//store 2nd operand in n2
                num = "";
                    try
                    {
                        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1098);
                        converter impl =(converter) myRegistry.lookup("converter");
                        
                            d1 = impl.PSIPascal(n1);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str +" Pascal");       //print the value
                    }
                    catch(Exception e){}
                }
                else
                {
                    tf.setText("");
                }
            }
            if(ae.getSource()==jb[11]) //if button pressed is “CLEAR”
            {
                tf.setText("");
                num = "";
                n1=0.0;
           
                button=0;                               
            }
}
public static void main(String args[])
{
                   JFrame f = new ProjectRMIClient();
                   f.setSize(500,300);
                   f.setResizable(false);
                   f.setVisible(true);
                   }
}
          
          


    

