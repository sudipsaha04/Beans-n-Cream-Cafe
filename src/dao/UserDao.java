/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class UserDao {
     public static void save(User user)
     {
         String query = "insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobilenumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityquestion()+"','"+user.getAnswer()+"','false')";
         DbOperation.setDataorDelete(query, "Registered Successfully! Wait for Admin Approval!");
     }
     
     public static User login(String email,String password){
         
         User user = null;
         try{
            ResultSet rs = DbOperation.getData("select * from user where email = '"+email+"' and password = '"+password+"'");
            while(rs.next())
            {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return user;
     }
     public static User getSecurityQuestion(String email)
     {
         User user = null;
         try{
            ResultSet rs = DbOperation.getData("select * from user where email= '"+email+"'");
            while(rs.next())
            {
                user = new User();
                user.setSecurityquestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         return user;
     }
     
     public static void update(String email,String newPassword)
     {
         String query ="update user set password = '"+newPassword+"' where email = '"+email+"'";
         DbOperation.setDataorDelete(query, "Password change Successfully");
     }
     
     
     public static ArrayList<User> getAllRecords(String email){
         ArrayList<User> arrayList = new ArrayList<>();
         try{
             ResultSet rs = DbOperation.getData("select * from user where email like '%"+email+"%'");
             while(rs.next())
             {
                 User user = new User();
                 user.setId(rs.getInt("id"));
                 user.setName(rs.getString("name"));
                 user.setEmail(rs.getString("email"));
                 user.setMobilenumber(rs.getString("mobileNumber"));
                 user.setAddress(rs.getString("address"));
                 user.setSecurityquestion(rs.getString("securityQuestion"));
                 user.setStatus(rs.getString("status"));
                 
                 arrayList.add(user);
             }
             
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }
         return arrayList;
     }
     
     public static void changeStatus(String email,String status)
     {
         String query = "update user set status = '"+status+"' where email = '"+email+"'";
         DbOperation.setDataorDelete(query, "Status Changed Successfully");
     }
     
     public static void changePassword(String email,String oldPassword,String newPassword)
     {
         try{
             ResultSet rs = DbOperation.getData("select *from user where email = '"+email+"' and password ='"+oldPassword+"'");
             if(rs.next())
             {
                 update(email, newPassword);
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Old password is wrong");
             }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }
     }
     
    public static void changeSecurityQuestion(String email,String password,String securityQuestion , String answer)
     {
         try{
             ResultSet rs = DbOperation.getData("select *from user where email = '"+email+"' and password ='"+password+"'");
             if(rs.next())
             {
                 update(email, securityQuestion,answer);
                 
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "password is wrong");
             }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }
     }
    
    public static void update(String email,String securityQuestion ,String answer)
     {
         String query ="update user set securityQuestion = '"+securityQuestion+"',answer = '"+answer+"' where email = '"+email+"'";
         DbOperation.setDataorDelete(query, "Security Question change Successfully");
     }
}
