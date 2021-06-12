package me.sunand.Assignment3.core;
public class EcommProducts {
    public static void main(String[] args){
       Product[] products= new Product[]{
                    new PineApple(),
                    new Samsung(),
                    new Shampoo()
       };
       System.out.println("Details of various products");
       for(Product product:products){
            System.out.println("Product Name: "+product.getClass().getSimpleName());
            System.out.println("Per Unit Cost: "+product.getCost());
            System.out.println("Quantity Available: "+product.getQuantity());
            if(product instanceof PineApple) {
                System.out.println("Colour: "+new PineApple().color);
                System.out.println("Vitamins: "+new PineApple().vitamins);
            }
            else if(product instanceof Samsung){
                System.out.println("Network: "+new Samsung().network);
                System.out.println("Battery: "+new Samsung().battery);
            }
            else{
                System.out.println("Brand: "+new Shampoo().brand);
                System.out.println("pH: "+new Shampoo().pH);
            }
       }
    }
   enum ProductType{
        GROCERY,ELECTRONICS,PERSONAL
   }
   static abstract class Product{
        ProductType productType;
        Product(ProductType productType) {
            this.productType=productType;
        }
       public ProductType getProductType() {
           return productType;
       }
       public abstract int getCost();
        public abstract int getQuantity();

   }
   static class PineApple extends Product{
          PineApple(){
              super(ProductType.GROCERY);
          }
          String color="yellow";
          String vitamins=new StringBuffer().append("A").append(",").append("B6").append(",").append("E").append(",").append("K").toString();
          public int getCost(){
              return 50;
          }
          public int getQuantity(){
              return 100;
          }
   }
   static class Samsung extends Product{
        Samsung(){
            super(ProductType.ELECTRONICS);
        }
        String network="4G";
        String battery="lithium-ion";
        String camera="41 megapixels";
        public int getCost(){
            return 1000;
        }
        public int getQuantity() {
            return 10;
        }
   }
   static class Shampoo extends Product{
        Shampoo(){
            super(ProductType.PERSONAL);
        }
        String brand="Pantene";
        String pH="3";
        public int getCost(){
            return 10;
        }
        public int getQuantity(){
            return 10000;
        }
   }
}
