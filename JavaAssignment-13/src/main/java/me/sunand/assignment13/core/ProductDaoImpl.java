package me.sunand.assignment13.core;

import com.datastax.driver.core.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    public List<Product> findAll(){
        List<Product> l = new ArrayList<Product>();
        try{
            Cluster cluster = Cluster.builder().addContactPoints("172.24.144.1").withPort(2003).build();
            Session session = cluster.connect("zs_intern_test");
            ResultSet rs = session.execute("select * from products");
            for(Row row : rs){
                Product p=new Product(row.getInt(1),row.getString(2),row.getInt(3),row.getInt(4));
                l.add(p);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return l;
    }
    public Product findById(int id){
        Product p=null;
        try{
            Cluster cluster = Cluster.builder().addContactPoints("172.24.144.1").withPort(2003).build();
            Session session = cluster.connect("zs_intern_test");
            ResultSet rs = session.execute("select * from products where id="+id);
            for(Row row:rs){
                p=new Product(row.getInt(1),row.getString(2),row.getInt(3),row.getInt(4));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return p;
    }
    public void insert(int id,String product_name,int cost,int quantity){
        try{
            Cluster cluster = Cluster.builder().addContactPoints("172.24.144.1").withPort(2003).build();
            Session session = cluster.connect("zs_intern_test");
            PreparedStatement statement=session.prepare("insert into products(id,product_name,cost,quantity) values(?,?,?,?)");
            BoundStatement boundStatement=new BoundStatement(statement);
            session.execute(boundStatement.bind(id,product_name,cost,quantity));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void update(String product_name,int cost,int quantity){
        try{
            Cluster cluster = Cluster.builder().addContactPoints("172.24.144.1").withPort(2003).build();
            Session session = cluster.connect("zs_intern_test");
            PreparedStatement statement=session.prepare("update products set cost=? quantity=? where product_name=?");
            BoundStatement boundStatement=new BoundStatement(statement);
            session.execute(boundStatement.bind(cost,quantity,product_name));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteById(int id){
        try{
            Cluster cluster = Cluster.builder().addContactPoints("172.24.144.1").withPort(2003).build();
            Session session = cluster.connect("zs_intern_test");
            session.execute("delete from products where id="+id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public boolean exists(String product_name){
        boolean flag=false;
        try{
            Cluster cluster = Cluster.builder().addContactPoints("172.24.144.1").withPort(2003).build();
            Session session = cluster.connect("zs_intern_test");
            ResultSet rs = session.execute("select * from products where product_name="+product_name);
            for(Row row:rs){
                flag=true;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return flag;
    }
    public static void main(String[] args){
        ProductDaoImpl p=new ProductDaoImpl();
        List<Product> l=p.findAll();
        Product pr=p.findById(1);
        p.insert(3,"realme",10000,45);
        p.deleteById(2);
        boolean b=p.exists("oppo");
    }
}
