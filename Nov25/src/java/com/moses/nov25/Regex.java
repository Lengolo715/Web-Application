/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moses.nov25;

import java.util.regex.*;
/**
 *
 * @author User
 */
public class Regex {
    
    private String name;
    private String surname;
    private String email;
    
    public String getName(){
        return this.name;
    }//end of get method
    
    public String getSurname(){
        return this.surname;
    }//end of get method
    
    public String getEmail(){
        return this.email;
    }//end of get method

    public String nameRegexCheck(String regexMatch)
    {
       String status = "";
       String regexCheck = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ])+$";
       Pattern checkReg = Pattern.compile(regexCheck);
       Matcher regMatch = checkReg.matcher(regexMatch);
       
        System.out.println(regMatch.matches());
        
        if(regMatch.matches()){
                this.name = regexMatch;
                status = "Valid";
        }//end of if
        
        else{
          status = "Invalid";
        }//end of else
        
    return status;
   }//end of method   
   
    public String surnameRegexCheck(String regexMatch)
    {
       String status = "";
       String regexCheck = "(?i)^(?:(?![×Þß÷þø])[-'0-9a-zÀ-ÿ])+$";
       Pattern checkReg = Pattern.compile(regexCheck);
       Matcher regMatch = checkReg.matcher(regexMatch);
       System.out.println(regMatch.matches());
        
        if(regMatch.matches()){
          this.surname = regexMatch;
          status = "Valid";
        }//end of if
        
        else{
          status = "Invalid";
        }//end of else
        return status;
   }//end of method 
   
    public String emailRegexCheck(String regexMatch)
    {
       String status = "";
       String regexCheck = "[A-Za-z0-9._]+@[A-Za-z0-9\\-]+\\.[A-Za-z]{2,4}|[A-Za-z0-9._]+@[A-Za-z0-9\\-]+\\.[A-Za-z]{2,4}+\\.[A-Za-z]{2,4}";
       Pattern checkReg = Pattern.compile(regexCheck);
       Matcher regMatch = checkReg.matcher(regexMatch);
       System.out.println(regMatch.matches());
        
        if(regMatch.matches()){
           this.email = regexMatch;
           status = "Valid";
        }//end of if
        else{
          status = "Invalid";
        }//end of else
        return status;
   }//end of method    
    
    public Regex(){}
  
}//end of class
