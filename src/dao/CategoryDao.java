/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
import model.Category;


/**
 *
 * @author HP
 */
public class CategoryDao {
    
    public static void save(Category category){
        
        String query= "insert into category (name) values('"+category.getName()+"')";
        DbOperation.setDataorDelete(query, "Category Added Successfully");
    }
    
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
            ResultSet rs= DbOperation.getData("select *from category");//resultset data store kore table e
            while(rs.next()){//call the data from category
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);
            }
                
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void delete(String id){
        String query = "delete from category where id = '"+id+"'";
        DbOperation.setDataorDelete(query, "Category deleted successfully");
    }
            
}
