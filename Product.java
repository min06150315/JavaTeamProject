package JavaTeamProject;

public class Product {
    private String name;
    private int price;
    private int count;
    private int location;   // (1 ~ 4)
    Product(int price, int count, int location) {
        this.price = price;
        this.count = count;
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getCount() {
        return count;
    }
    public int getLocation() {
        return location;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("  Price: %d  Count: %d  Location: %d", price, count, location);
    }
}
