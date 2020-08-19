/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edsamwelasifiwe.bank_management_system;

import java.sql.*;

/**
 *
 * @author eddy
 */
public class dbconn {
    Connection cn;
    Statement stmnt;
    public dbconn(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            cn =DriverManager.getConnection("jdbc:mysql:///bankManagement","root","12345");    
            stmnt =cn.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
