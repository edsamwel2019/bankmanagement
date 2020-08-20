/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edsamwelasifiwe.bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author eddy
 */
public class LoginForm extends JFrame implements ActionListener{
    JLabel lbl1,lbl2,lbl3;
    JTextField tfld1;
    JPasswordField pswdf2;
    JButton btn1,btn2,btn3;
    
        LoginForm(){
    //Move the text to the center
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("Bank Management System");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"Bank Management System");
        
       
       
        
        
        
        lbl1 = new JLabel("WELCOME");
        lbl1.setFont(new Font("Osward", Font.BOLD, 38));
        
        lbl2 = new JLabel("Card/Account No:");
        lbl2.setFont(new Font("Raleway", Font.BOLD, 28));
        
        lbl3 = new JLabel("PIN:");
        lbl3.setFont(new Font("Raleway", Font.BOLD, 28));
        
        tfld1 = new JTextField(15);
        pswdf2 = new JPasswordField(15);
        
        btn1 = new JButton("SIGN IN");
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.WHITE);
        
        btn2 = new JButton("CLEAR");
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        
        btn3 = new JButton("SIGN UP");
        btn3.setBackground(Color.BLACK);
        btn3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        lbl1.setBounds(175,50,450,200);
        add(lbl1);
        
        lbl2.setBounds(10,150,375,200);
        add(lbl2);
        
        tfld1.setBounds(300,235,230,30);
        add(tfld1);
        
        lbl3.setBounds(225,225,375,200);
        add(lbl3);
        
        tfld1.setFont(new Font("Arial", Font.BOLD, 14));
       
        
        pswdf2.setFont(new Font("Arial", Font.BOLD, 14));
        pswdf2.setBounds(300,310,230,30);
        add(pswdf2);
        
        btn1.setFont(new Font("Arial", Font.BOLD, 14));
        btn1.setBounds(300,400,100,30);
        add(btn1);
        
        btn2.setFont(new Font("Arial", Font.BOLD, 14));
        btn2.setBounds(430,400,100,30);
        add(btn2);
        
        btn3.setFont(new Font("Arial", Font.BOLD, 14));
        btn3.setBounds(300,450,230,30);
        add(btn3);
        
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
       
        try{        
            dbconn c1 = new dbconn();
            String a  = tfld1.getText();
            String b  = pswdf2.getText();
            String q  = "select * from login where cardno = '"+a+"' and pin = '"+b+"'";
            ResultSet rs = c1.stmnt.executeQuery(q);
            
            if(ae.getSource()==btn1){
                if(rs.next()){
                    new TranscationFnctn().setVisible(true);
                    setVisible(false);
                
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
                    
                }
            }else if(ae.getSource()==btn2){
                tfld1.setText("");
                pswdf2.setText("");
            }else if(ae.getSource()==btn3){
                new SignupForm1().setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
        }
            
    }
    
    
    public static void main(String[] args){
        new LoginForm().setVisible(true);
    }
}
