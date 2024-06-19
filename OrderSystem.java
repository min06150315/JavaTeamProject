package JavaTeamProject;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class OrderSystem {
    HashMap<String, Product> map;
    public OrderSystem() {
        map = new HashMap<>();
        String filename = "./src/JavaTeamProject/textfiles/product.txt";
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + filename);
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
    void printHashMap() {
        for (String key : map.keySet())
            System.out.println("Name: " + key + map.get(key).toString());
    }
    void printHashMapForClient() {
        for (String key : map.keySet())
            System.out.println("Name: " + key + map.get(key).toStringForClient());
    }
    void MakeReceipt() {
        // order.txt 읽어서 불러오기
        String filename = "./src/JavaTeamProject/textfiles/order.txt";
        // 만들어낼 파일 경로
        String filepath = "./src/JavaTeamProject/textfiles/receipt.txt";
        Scanner inputStream = null;
        String[] productName = new String[64];
        int[][] product = new int[64][2]; // 가격과 수량만 필요함
        int[] productSum = new int[64];
        int totalSales = 0;
        int i = 0;

        // 파일 읽기
        try {
            inputStream = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + filename);
            System.exit(0);
        }

        while (inputStream.hasNext()) {
            productName[i] = inputStream.next(); // 이름 읽어오기
            product[i][0] = inputStream.nextInt(); // 가격 읽어오기
            product[i][1] = inputStream.nextInt(); // 수량 읽어오기
            inputStream.nextInt(); // 위치 읽어오기 (여기서는 필요 X)
            // 상품별 총 합 계산
            productSum[i] = product[i][0] * product[i][1]; // 가격 * 수량
            // 총 매출에 추가하기
            totalSales += productSum[i];
            i++;
        }
        inputStream.close();

        // 영수증 파일 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write("=================================================");
            writer.newLine();
            writer.write("                    Receipt");
            writer.newLine();
            writer.write("=================================================");
            writer.newLine();
            writer.write(String.format("%-19s %6s %8s %10s", "Item", "Qty", "Price", "Amount"));
            writer.newLine();
            writer.write("-------------------------------------------------");
            writer.newLine();
            for (int j = 0; j < i; j++) {
                writer.write(String.format("%-20s %5d %8d %10d", productName[j], product[j][1], product[j][0], productSum[j]));
                writer.newLine();
            }
            writer.write("-------------------------------------------------");
            writer.newLine();
            writer.write(String.format("Total:%40d", totalSales));
            writer.newLine();
            writer.write("=================================================");
            writer.newLine();
            writer.write("                  Thanks you!");
            writer.newLine();
            writer.write("=================================================");
            writer.newLine();

            System.out.println("Write in receipt.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
