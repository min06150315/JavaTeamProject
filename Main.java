package JavaTeamProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // items.txt 파일 받아드려서 hashmap에 저장\
        OrderSystem o = new OrderSystem();
        String filename = "./src/JavaTeamProject/textfiles/items.txt";
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + filename);
            System.exit(0);
        }
        while (inputStream.hasNext()) {
            String name = inputStream.next();
            int price = inputStream.nextInt();
            int count = inputStream.nextInt();
            int location = inputStream.nextInt();

            Product new_product = new Product(price, count, location);
            o.addHashMap(name, new_product);
        }
        o.printHashMap();
    }
}
