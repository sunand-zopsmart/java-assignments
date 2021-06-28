package me.sunand.assignment10.core;

import java.util.*;
import java.sql.*;

public class ProductDaoImpl implements ProductDao {
    static final String DB_URL = "jdbc:postgresql://172.23.144.1:2006/zs-intern-products";
    static final String USER = "postgres";
    static final String PASS = "root123";

    public List<Product> findAll() {
        List<Product> l = new ArrayList<Product>();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String QUERY = "select * from products";
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                l.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public Product findById(int id) {
        Product p = null;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String QUERY = "select * from products where id=" + id;
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void insert(String product_name, int cost, int quantity) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt;
            String QUERY = "insert into products(product_name,cost,quantity) values(?,?,?)";
            stmt = conn.prepareStatement(QUERY);
            stmt.setString(1, product_name);
            stmt.setInt(2, cost);
            stmt.setInt(3, quantity);
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String product_name, int cost, int quantity) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt;
            String QUERY = "update products set cost=? quantity=? where product_name=?";
            stmt = conn.prepareStatement(QUERY);
            stmt.setInt(1, cost);
            stmt.setInt(2, quantity);
            stmt.setString(3, product_name);
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String QUERY = "delete from products where id=" + id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(String product_name) {
        boolean flag = false;
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String QUERY = "select * from products where product_name=" + product_name;
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void main(String[] args) {
        ProductDaoImpl p = new ProductDaoImpl();
        List<Product> l = p.findAll();
        Product pr = p.findById(1);
        p.insert("iPhone", 50000, 23);
        p.update("laptop", 100000, 4);
        p.deleteById(2);
        boolean b = p.exists("mobile");
    }
}
