package JavaTeamProject;


public class Order {
    private String name;//상품명
    private double price;//가격
    private double num;//주문량
    private int where;//장소


    public Order(String name, double price, double num, int where){
        this.name = name;
        this.price = price;
        this.num = num;
        this.where = where;
    }

    public double getNum(){//주문 시 재고량 관리를 위해
        return num;
    }

    public String toString(){//주문 시 재고량 관리를 위해
        return name+ "\t\t\t\t" + price + "\t\t\t" + num + "\t\t\t" +  where;

    }
    public Order getOrder(){//
        return new Order(name, price, num, where);
    }

    public int getWhere(){//
        return where;
    }


}
