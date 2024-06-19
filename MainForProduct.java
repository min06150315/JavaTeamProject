package JavaTeamProject;

import java.util.Scanner;

// 회사를 위한 Main 시스템
public class MainForProduct {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        OrderSystem o = new OrderSystem();
        int menu;
        while (true) {
            System.out.print("\n1.Item List 2.Delivery Check Message 3.Quit > ");
            menu = s.nextInt();
            switch (menu) {
                case 1:
                    o.printHashMap();
                    break;
                case 2:
                    // o.SendMessage();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}
