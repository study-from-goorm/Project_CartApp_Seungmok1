public class Product {

    private int key;
    private String name;
    private int price;

    public Product(String name, int price) {
        key++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Product product = (Product) obj;
        return key==product.key && name.equals(product.name) && price==product.price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime * (name.hashCode() + price);
    }
}
