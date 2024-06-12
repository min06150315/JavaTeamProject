package JavaTeamProject;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// 소비자를 위한 Main 시스템
public class MainForClient {
    public static void main(String[] args) throws IOException {
        Scanner k = new Scanner(System.in);
        OrderSystem o = new OrderSystem();
        HashMap<String, Order> order = new HashMap<>();
        
        while (true) {
            System.out.print("\n1.Item List 2.Order 3.Update 4.Your Order List 5.Done > ");
            int choice = k.nextInt();

            if (choice == 1) {  // product.txt 파일에 있는 상품 리스트 확인하기
                o.printHashMapForClient();
            } else if (choice == 2) {   // 상품의 이름과 개수 입력하여 주문하기
                System.out.print("Enter name what you want to order: ");
                k.nextLine();   //for nextLine의 특성때문에
                String name = k.nextLine();

                if(!o.map.containsKey(name)){   // 만약 입력한 이름이 상품 목록에 없을 때
                    System.out.println("Not here.");
                    continue;
                }
                // 입력한 이름이 상품 목록과 일치할 때에 개수 입력 받기
                System.out.print("Enter number of item you want to buy: ");
                int num = k.nextInt();

                o.map.get(name).setCount(-num);
                Order l = new Order(name, o.map.get(name).getPrice(), num, o.map.get(name).getLocation());
                order.put(name, l);

                System.out.println("Current Your order: " + name + " " + num);
            } else if (choice == 3) {   // 주문한 상품 변경하기
                // 삭제를 원하면 1, 수량 변경을 원하면 2 입력하기
                System.out.print("1.Delete Order 2.Change the number of products 3.Quit > ");
                int deleteOrNot = k.nextInt();

                if (deleteOrNot == 1) {
                    // 삭제하고 싶은 상품명 입력
                    System.out.print("Enter name what you want to delete: ");
                    k.nextLine();
                    String name = k.nextLine();
                    if (!order.containsKey(name)) { // 입력한 이름이 상품 목록에 없을 때에
                        System.out.println("Not here.");
                        continue;
                    }
                    o.map.get(name).setCount(order.get(name).getNum());
                    order.remove(name);

                    System.out.println("Delete Complete.");
                } else if (deleteOrNot == 2) {
                    // 변경하고 싶은 상품명 입력
                    System.out.print("Enter name what you want to change: ");
                    k.nextLine();
                    String name = k.nextLine();
                    if (!order.containsKey(name)) { // 입력한 이름이 상품 목록에 없을 때에
                        System.out.println("Not here.");
                        continue;
                    }
                    o.map.get(name).setCount(order.get(name).getNum());

                    System.out.print("Enter new number of item: ");
                    int newNum = k.nextInt();

                    o.map.get(name).setCount(-newNum);
                    order.get(name).setNum(newNum);

                    System.out.println("Update Complete.");
                }
            } else if(choice == 4) {    // 내 장바구니 출력
                int i = 1;
                if (order.isEmpty()) {  // 아무것도 주문하지 않았다면 비어있다고 표시
                    System.out.println("----Empty----");
                } else {
                    for (String s : order.keySet()) {   // 장바구니 출력
                        System.out.println(i++ + ") " + order.get(s).toStringForClient());
                    }
                }
            } else if (choice == 5) {
                System.out.println("Order is complete!");
                break;
            }

        }

        // 유저의 주문에 따라 product.txt 의 물품 개수 변경
        FileOutputStream output = null;
        try {
            output = new FileOutputStream("./src/JavaTeamProject/textfiles/product.txt");
        } catch(Exception e) {
            System.out.println("Fail to open the file!");
            System.exit(0);
        }
        for (String s : o.map.keySet()) {
            output.write((s + " " + o.map.get(s).getPrice() + " " + o.map.get(s).getCount() + " " + o.map.get(s).getLocation() + "\n").getBytes());
        }
        System.out.println("Update Complete product.txt");

        //order.txt 만들자.
        String fileName = "./src/JavaTeamProject/textfiles/order.txt";
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            // 주문 내역을 파일에 쓰기
            for (Order orderItem : order.values()) {
                String orderLine = orderItem.getName() + " " +
                        orderItem.getPrice() + " " +
                        orderItem.getNum() + " " +
                        orderItem.getLocation() + "\n";
                bufferedWriter.write(orderLine);
            }
            System.out.println("Write in Order List in order.txt");
        } catch (IOException e) {
            System.err.println("Error occurred while writing to order.txt: " + e.getMessage());
            e.printStackTrace();
        }

        o.MakeReceipt();
    }
}
