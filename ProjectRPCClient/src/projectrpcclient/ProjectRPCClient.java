/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectrpcclient;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.xmlrpc.XmlRpcClient;

/**
 *
 * @author root
 */
public class ProjectRPCClient extends JFrame implements ActionListener {
    double n1 = 0.0;
    double  d1;
    JButton jb[] = new JButton[24];
    JTextField tf;
    Container con;
    int button,i;
    String str;
    String num="";
    JPanel tp,bp; //declaring 2 panels for textfield and buttons
    public ProjectRPCClient(){
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
    {
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.CelciusKelvin", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Kelvin");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                         }
                        
                                  //print the value
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
                       try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.CelciusFahrenheit", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Fahrenheit");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                         }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.KelvinCelcius", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Celcius");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                         }       //print the value
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.KelvinFahrenheit", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Fahrenheit");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                         }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.FahrenheitCelcius", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Celcius");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                         }
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
                    { try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.FahrenheitKelvin", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Kelvin");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                         }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.AtmosPascal", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Pascal");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                    }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.AtmosPSI", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" PSI");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                    }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.PascalAtmos", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Atmospheric");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                    }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.PascalPSI", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" PSI");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                    }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.PSIAtmos", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Atmospheric");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                    }
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
                        try {
                            XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
                            Vector params = new Vector();

                            params.addElement(new Double(n1));
                           

                            Object result = server.execute("converter.PSIPascal", params);

                            
                             d1 = ((Double) result);
                        
                            str = String.valueOf(d1);          //convert the //value to string
                            tf.setText(str+" Pascal");

                         } catch (Exception exception) {
                            System.err.println("JavaClient: " + exception);
                    }
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
    
    public static void main(String[] args) {
        JFrame f = new ProjectRPCClient();
                   f.setSize(500,300);
                   f.setResizable(false);
                   f.setVisible(true);
                   }

    
    }
    

