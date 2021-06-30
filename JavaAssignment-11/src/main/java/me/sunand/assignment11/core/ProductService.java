package me.sunand.assignment11.core;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProductService {
    ProductDataAccessLayer productDao = new ProductDataAccessLayer();
    public List<Product> getAllProducts(){
       return productDao.getAllProducts();
    }
    public List<String> getCategories(){
        return productDao.getCategories();
    }
    public Map<String,List<Product>> getProductinCategories(){
        return productDao.getProductinCategories();
    }
}
