package JavaTeamProject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MainforClient {


    public static void main(String[] args) throws IOException {
        Scanner k = new Scanner(System.in);
        OrderSystem o = new OrderSystem();
        HashMap<String, Order> c = new HashMap<>();
        HashMap<String, Order> order = new HashMap<>();
        while(true){
            System.out.print("1. Iteamlist, 2. order. 3. update, 4. Your Order List, 5. done > ");
            int choice = k.nextInt();
            if(choice == 1){
                o.printHashMapforClient();

            }
            else if(choice == 2){
                System.out.println("Enter name what you want to order: ");
                k.nextLine();//for nextLine의 특성때문에
                String name = k.nextLine();
                if(!o.map.containsKey(name)){
                    System.out.println("Not here.");
                    continue;
                }
                //여긴 물건이 있다는 거야.
                System.out.println("Enter number of item you want to buy: ");
                int num = k.nextInt();
                o.map.get(name).setCount(-num);
                Order l = new Order(name, o.map.get(name).getPrice(), num, o.map.get(name).getLocation());
                order.put(name, l);
                System.out.println("Current Your order: " + name + " " + num);

            }else if(choice == 3){
                System.out.println("Enter name what you want to change: ");
                k.nextLine();
                String name = k.nextLine();
                if(!order.containsKey(name)){//이상한 거 업데이트하려고 하면
                    System.out.println("Not here.");
                    continue;
                }
                //여기 까지 온거면 이름 정확하게 쓴거
                System.out.println("Enter if you want to delete 1, or change number of item 2: ");
                int deleteOrNot = k.nextInt();
                if(deleteOrNot==1){
                    o.map.get(name).setCount(order.get(name).getNum());
                    order.remove(name);
                }else if(deleteOrNot ==2){
                    o.map.get(name).setCount(order.get(name).getNum());
                    System.out.println("Enter new number of item : ");
                    int newNum = k.nextInt();
                    o.map.get(name).setCount(-newNum);
                    order.get(name).setNum(newNum);//업데이트 완료!
                }


            }else if(choice == 4){
                int i = 1;
                if(order.isEmpty()){
                    System.out.println("----Empty----");
                }else {
                    for (String s : order.keySet()) {
                        System.out.println(i++ + ") " + order.get(s).toStringForClient());
                    }
                }
            }else if(choice == 5){
                System.out.println("Order is complete!");
                break;
            }

        }

        //모든 주문이 끝난 거니까, txt 업데이트 하자.
        //Product.txt
        FileOutputStream output = null;
        try{
            output = new FileOutputStream("product.txt");
        }catch(Exception e){
            System.out.println("Fail to open the file!");
            System.exit(0);
        }
        for(String s : o.map.keySet()) {
            output.write((s + " " + o.map.get(s).getPrice() + " " + o.map.get(s).getCount() + " " + o.map.get(s).getLocation() + "\n").getBytes());
        }
        //order.txt 만들자.
        try{
            output = new FileOutputStream("order1.txt");
        }catch(Exception e){
            System.out.println("Fail to open the file!");
            System.exit(0);
        }
        for(String s : order.keySet()) {
            output.write((order.get(s).toString()+"\n").getBytes());
        }
    }
}
