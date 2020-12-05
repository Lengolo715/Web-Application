/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moses.nov25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class UserDAO {

    /**
     * @param args the command line arguments
     */
    
    private Connection con;
    private Statement stmnt;
    
    public Connection getCon() {
        return con;
    }

    public Statement getStmnt() {
        return stmnt;
    }
    
    public UserDAO(String user, String password, String dbName ) {
        try {
            String fqurl = "jdbc:mysql://localhost:3306/"+dbName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(fqurl,user,password);
            stmnt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end of connection constructor
    
    public String addUser(String name, String surname, String user, String password) throws SQLException{
        String message = "";
        int row = 0;
        
        String sql = "Insert into mos values('"+ name + "','" + surname +"','" + user+ "','"+ password +"')";
        ResultSet result = stmnt.executeQuery("select * from mos where username='"+ user +"'");
        
        if(result.equals(user)){
            System.out.println("User already exists");
            message = "User already exists";
            System.out.println("Rows affected: " + row);
        }//end of if
        
        else{
            row = stmnt.executeUpdate(sql);
            System.out.println("User added");
            message = "User succesfully added";
            System.out.println("Rows affected: " + row);
        }//end of else
        
        return message;
    }//end of method
    
    public String checkUser(String user) throws SQLException{
        String message = "";
        int row= 0;
        
        String sql = "select * from mos where username='" + user+"'";
        ResultSet result = stmnt.executeQuery(sql);
        
        if(result.next()){
            message = "User found";
            System.out.println("User exists");
        }//end of if
        
        else{
            message = "User not found";
        System.out.println("User not Found");
        System.out.println("Affected "+ row );
        }//end of else
        return message;
    }//end of method
    
    public String checkUserCred(String user, String password) throws SQLException{
        String message = "";
        
        
        String sql = "select * from mos where username='" + user + "'" +"and password='" + password +"'";
        ResultSet result = stmnt.executeQuery(sql);
        
        if(result.next()){
            message = "User credentials match";
            System.out.println("User credentials match");
            
        }//end of if
        
        else{
            message = "User credentials do not match";
            System.out.println("User credentials do not match");
        }//end of else
        
        return message;
    }//end of method
    
    public String changePassword(String user, String password) throws SQLException{
        int row = 0;
        String message ="";
        String sql = "select * from mos where username='"+user+"'";
        ResultSet result = stmnt.executeQuery(sql);
        
        if(result.next()){
            
            sql = "update mos set password='"+ password +"'" + " where username='"+user+"'";
            row = stmnt.executeUpdate(sql);
            message = "Succefully changed";
            System.out.println(row + " affected");
        }//end of if
        
        else{
            message = "Username doesn't match";
        }//end of else
        
        return message;
    }//end of metthod
    
    
    
    public static void main(String[] args) throws SQLException {
        
        UserDAO user = new UserDAO("root","Lengolo","mo");
        Connection mcon = user.getCon();
        //String msg = user.addUser("Lengolo", "abcd1234");
        //String msg = user.checkUserCred("Lengolo", "abcd1234");
        //String msg = user.changePassword("Lengolo", "Matema");
        //System.out.println(message);
        //System.out.println(msg);
        
        user.getCon().close();
    }//end of main
    
}//end of class