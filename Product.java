package JavaTeamProject;

public class Product {
    private String name;
    private int price;
    private int count;
    private int location;   // (1 ~ 4)
    Product(String name, int price, int count, int location) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count += count;
    }
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format("  Price: %d  Count: %d  Location: %d", price, count, location);
    }
    public String toStringForClient() {
        return String.format("  Price: %d  Count: %d", price, count);
    }
}
