package JavaTeamProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class OrderSystem {
    HashMap<String, Product> map;
    public OrderSystem() {
        map = new HashMap<>();
        String file = "product.txt";
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("Fail to open the file!");
            System.exit(0);
        }
        //파일에 줄이 끝날 때까지 받아드리면서 데이터화하자.
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            String[] data = line.split(" ");
            //Product에 넣자.
            Product item = new Product(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            //HashMap w에 넣음
            map.put(data[0], item);
        }
    }
    void addHashMap(String name, Product p) {
        map.put(name, p);
    }
    void printHashMap() {
        for (String key : map.keySet())
            System.out.println("Name: " + key + map.get(key).toString());
    }

    void printHashMapforClient() {
        for (String key : map.keySet())
            System.out.println("Name: " + key + map.get(key).toStringForClient());
    }
}
