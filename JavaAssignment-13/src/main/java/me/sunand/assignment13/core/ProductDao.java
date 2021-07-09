package me.sunand.assignment13.core;
import java.util.List;
public interface ProductDao {
    public List<Product> findAll();
    public Product findById(int id);
    public void insert(int id,String product_name,int cost,int quantity);
   // public void update(String product_name,int cost,int quantity);
    //public void deleteById(int id);
    //public boolean exists(String product_name);
}
