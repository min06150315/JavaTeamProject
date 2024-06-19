package JavaTeamProject;

public class Order {
    private String name;//상품명
    private int price;//가격
    private int num;//주문량
    private int location;//장소
    public Order(String name, int price, int num, int location){
        this.name = name;
        this.price = price;
        this.num = num;
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getNum() {       //주문 시 재고량 관리를 위해
        return num;
    }
    public void setNum(int num) {   //주문 시 재고량 관리를 위해
        this.num = num;
    }
    public int getLocation() {
        return location;
    }
    public String toString() {      //주문 시 재고량 관리를 위해
        return String.format("%-11s\t%-5d\t%-12d\t%-8d", name, price, num, location);
    }
    public String toStringForClient() {     //고객을 위해
        return String.format("%-11s\t%-5d\t%-12d", name, price, num);
    }

}
