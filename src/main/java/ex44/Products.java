package ex44;

public class Products {
    private String name;
    private float price;
    private int quantity;

    public Products(String name, float price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


}
