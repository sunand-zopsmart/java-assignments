package me.sunand.assignment11.core;

/**
 * Controller to generate Http Url
 *
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class ProductController {
    //private final ProductService productService;
    //@Autowired
    //public ProductController(ProductService productService){
    //  this.productService=productService;
    ProductService productService = new ProductService();

    @RequestMapping(path = "api1")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @RequestMapping(path = "api2")
    @GetMapping
    public List<String> getCategories() {
        return productService.getCategories();
    }
    @RequestMapping(path="api3")
    @GetMapping
    public Map<String, List<Product>> getProductinCategories() {
        return productService.getProductinCategories();
    }
}