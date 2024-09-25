/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;
import model.Product;

/**
 *
 * @author HP
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try{
           
            ResultSet rs = DbOperation.getData("select max(id) from bill");
            if(rs.next())
            {
                id= rs.getInt(1);
                id =id+1;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void save(Bill bill){
        
        String query= "insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreatedBy()+"')";
        DbOperation.setDataorDelete(query, "Bill details Added Successfully");
    }
    public static ArrayList<Product> getAllRecords(){
         
         ArrayList<Product> arrayList = new ArrayList<>();
         
         try{
             ResultSet rs = DbOperation.getData("select *from Product");
             while(rs.next())
             {
                 Product product = new Product();
                 product.setId(rs.getInt("id"));
                 product.setName(rs.getString("name"));
                 product.setCategory(rs.getString("category"));
                 product.setPrice(rs.getString("price"));
                 arrayList.add(product);
             }
             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return arrayList;
     }
     
     public static void update(Product product){
           String query = "update product set name = '"+product.getName()+"', category = '"+product.getCategory()+"',price = '"+product.getPrice()+"'where id =  '"+product.getId()+"'";
           DbOperation.setDataorDelete(query, "Product updated successfully");
     }
     
     public static void delete(String id){
        String query = "delete from product where id = '"+id+"'";
        DbOperation.setDataorDelete(query, "Product deleted successfully");
    }
     
     public static ArrayList<Bill> getAllRecordsByInc(String date){
         
         ArrayList<Bill> arrayList = new ArrayList<>();
         
         try{
             ResultSet rs = DbOperation.getData("select *from bill where date like '%"+date+"%'");
             while(rs.next())
             {
                 Bill bill =new Bill();
                 bill.setId(rs.getInt("id"));
                 bill.setName(rs.getString("name")); 
                 bill.setMobileNumber(rs.getString("mobileNumber"));
                 bill.setEmail(rs.getString("email"));
                 bill.setDate(rs.getString("date"));
                 bill.setTotal(rs.getString("total"));
                 bill.setCreatedBy(rs.getString("createdBy"));
                 arrayList.add(bill);
             }             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return arrayList;
     }
     public static ArrayList<Bill> getAllRecordsByDesc(String date){
         
         ArrayList<Bill> arrayList = new ArrayList<>();
         
         try{
             ResultSet rs = DbOperation.getData("select *from bill where date like '%"+date+"%'order By id DESC");
             while(rs.next())
             {
                 Bill bill =new Bill();
                 bill.setId(rs.getInt("id"));
                 bill.setName(rs.getString("name")); 
                 bill.setMobileNumber(rs.getString("mobileNumber"));
                 bill.setEmail(rs.getString("email"));
                 bill.setDate(rs.getString("date"));
                 bill.setTotal(rs.getString("total"));
                 bill.setCreatedBy(rs.getString("createdBy"));
                 arrayList.add(bill);
             }             
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return arrayList;
     }
}
