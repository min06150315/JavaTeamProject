package JavaTeamProject;

import java.util.HashMap;

public class OrderSystem {
    HashMap<String, Product> map;
    public OrderSystem() {
        map = new HashMap<>();
    }
    void addHashMap(String name, Product p) {
        map.put(name, p);
    }
    void printHashMap() {
        for (String key : map.keySet())
            System.out.println("Name: " + key + map.get(key).toString());
    }
}
