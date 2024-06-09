package JavaTeamProject;


public class Order {
    private String name;//상품명
    private int price;//가격
    private int num;//주문량
    private int where;//장소


    public Order(String name, int price, int num, int where){
        this.name = name;
        this.price = price;
        this.num = num;
        this.where = where;
    }

    public int getNum(){//주문 시 재고량 관리를 위해
        return num;
    }
    public void setNum(int num){//주문 시 재고량 관리를 위해
        this.num = num;
    }

    public String toString(){//주문 시 재고량 관리를 위해
        return name+ " " + price + " " + num + " " +  where;

    }

    public String toStringForClient(){//고객을 위해
        return name+ "\t\t\t\t" + price + "\t\t\t" + num;

    }


    public Order getOrder(){//
        return new Order(name, price, num, where);
    }

    public int getWhere(){//
        return where;
    }


}
