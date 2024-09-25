/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class tables {
    public static void main(String[] args)
    {
        try
        {
            String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200), email varchar(200), mobileNumber varchar(11),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20), UNIQUE(email)) ";
            String adminDetais = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','01316981596','Bangladesh','admin','versity name?','AUST','true')";
            String categoryTable ="create table category(id int AUTO_INCREMENT primary key , name varchar(200))";
            String productTable ="create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            String billTable ="create table bill(id int primary key , name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
            //DbOperation.setDataorDelete(userTable ,"User table created successfully");
            //DbOperation.setDataorDelete(adminDetais ,"Admin details added successfully");
            //DbOperation.setDataorDelete(categoryTable ,"Category table created successfully");
            //DbOperation.setDataorDelete(productTable ,"Product table created successfully");
            DbOperation.setDataorDelete(billTable ,"Bill table created successfully");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
