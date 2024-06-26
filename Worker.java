package JavaTeamProject;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Worker {
    private HashMap<String, Order> w = new HashMap<>();

    public Worker() {// 이 class의 object를 만든 순간 데이터를 가지고 있다.
        String file = "./src/JavaTeamProject/textfiles/order.txt";
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
            String []data = line.split(" ");
            //Order에 넣자.
            Order item = new Order(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),Integer.parseInt(data[3]));
            //HashMap w에 넣음
            w.put(data[0],item);
        }
        //여기 까지 오면 파일에 있는 건 다 받아드린 것
    }
    public int ClearWork(String name) {//일 했다면 list에서 지워주기
        if (w.isEmpty()) {//처음 부터 할 일이 없었다면
            System.out.println("All Cleared.");
            return 1;
        } else {//할 일이 있을 때
            int i = 0;
            for (String item : w.keySet()) {
                if (name.equals(item)) {
                    System.out.println("Clear");
                    w.remove(item);
                    i = 0;
                    if(w.isEmpty()){//만약 방금 없앤게 마지막이였다면 끝내야지
                        System.out.println("All Cleared.");
                        return 1;
                    }
                    break;
                }
                i = 1;
            }
            if(i == 1){
                System.out.println("Not Order item.");
            }
        }
        return 0;
    }

    public void ShowWorkList() {
        int i = 1;
        System.out.println("   Name      \tPrice\tOrder number \tLocation ");
        for (String item : w.keySet())
            System.out.println(i++ + ") " +w.get(item).toString());
    }
    public void ShowLocation(int num) {
        if(num <= 6) {
            System.out.println(" --Floor 1-- ");
            System.out.println(" --------------------------------------- ");
            System.out.println("|       |       |       |               |");
            System.out.println("|       |       |       |               |");
            System.out.println("|   1   |   2   |   3   |               |");
            System.out.println("|       |       |       |               |");
            System.out.println("|       |       |       |               |");
            System.out.println("| ------------------------              |");
            System.out.println("|                                       |");
            System.out.println("|e                                      |");
            System.out.println("|x                ----------------------|");
            System.out.println("|i                |      |       |      |");
            System.out.println("|t                |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |   4  |   5   |   6  |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println(" --------------------------------------- ");

        } else {
            System.out.println(" --Floor 2-- ");
            System.out.println(" --------------------------------------- ");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |   7   |   8   |   9   |  10   |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       --------------------------------|");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("|                 ----------------------|");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |  11  |  12   |  13  |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|      exit       |      |       |      |");
            System.out.println(" --------------------------------------- ");
        }
    }
    public void PrintStateEndOrNot() {
        String fileName = "./src/JavaTeamProject/textfiles/finish.txt";

        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("true");
                System.out.println("Write Complete.");
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
    public void SendMessage() {
        String fileName = "./src/JavaTeamProject/textfiles/message.txt";

        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Your order has been shipped.");
                System.out.println("Write Complete.");
        } catch (IOException e) {
            System.err.println("Error");
        }
    }
}
