package me.sunand.assignment11.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDataAccessLayer {
    static final String DB_URL = "jdbc:postgresql://172.22.0.1:2006/zs_intern_test";
    static final String USER = "postgres";
    static final String PASS = "root123";

    public List<Product> getAllProducts() {
        List<Product> l = new ArrayList<Product>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String QUERY = "select * from product";
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                l.add(p);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public List<String> getCategories() {
        List<String> l = new ArrayList<String>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String QUERY = "select category_name from category";
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                l.add(rs.getString(1));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public Map<String,List<Product>> getProductinCategories() {
        Map<String,List<Product>> m= new HashMap<String,List<Product>>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            String QUERY = "select * from category";
            ResultSet rs=stmt.executeQuery(QUERY);
            ResultSet rs1;
            while(rs.next()){
                int category_id=rs.getInt(1);
                String category_name=rs.getString(2);
                String query="select product.product_id,product_name,cost,quantity from product inner join category_product on product.product_id=category_product.product_id where category_id="+category_id;
                rs1=stmt1.executeQuery(query);
                List<Product> l = new ArrayList<Product>();
                while(rs1.next()){
                    l.add(new Product(rs1.getInt(1),rs1.getString(2),rs1.getInt(3),rs1.getInt(4)));
                }
                m.put(category_name,l);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
}
