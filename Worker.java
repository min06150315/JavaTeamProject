package JavaTeamProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Worker {
    private HashMap<String, Order> w = new HashMap<>();
    private boolean ing;

    public Worker(){// 이 class의 object를 만든 순간 데이터를 가지고 있다.
        String file = "work.txt";
        Scanner inputStream = null;
        try{
            inputStream = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("Fail to open the file!");
            System.exit(0);
        }
        //파일에 줄이 끝날 때까지 받아드리면서 데이터화하자.
        while(inputStream.hasNextLine()){
            String line = inputStream.nextLine();
            String []data = line.split(" ");
            //Order에 넣자.
            Order item = new Order(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]),Integer.parseInt(data[3]));
            //HashMap w에 넣음
            w.put(data[0],item);


        }
        //여기 까지 오면 파일에 있는 건 다 받아드린 것
    }
    public int clearWork(String name) {//일 했다면 list에서 지워주기
        if (w.isEmpty()) {
            System.out.println("All Cleared.");
            return 1;
        } else {
            int i = 0;
            for (String item : w.keySet()) {
                if (name.equals(item)) {
                    System.out.println("Clear");
                    w.remove(item);
                    i = 0;
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
        System.out.println("test");
        System.out.println("i)   name                price     Order number     where ");
        for (String item : w.keySet()) {
            System.out.println(i++ + ") " +w.get(item).toString());
        }


    }
    public void ShowWhere(int num){
        if(num <= 6) {
            System.out.println(" --floor 1-- ");
            System.out.println(" --------------------------------------- ");
            System.out.println("|       |       |       |               |");
            System.out.println("|       |       |       |               |");
            System.out.println("|   1   |   2   |   3   |               |");
            System.out.println("|       |       |       |               |");
            System.out.println("|       |       |       |               |");
            System.out.println(" ------------------------                ");
            System.out.println("|                                       |");
            System.out.println("|e                                      |");
            System.out.println(" x                ---------------------- ");
            System.out.println("|i                |      |       |      |");
            System.out.println("|t                |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |   4  |   5   |   6  |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println(" ----------------------------------------");

        }else{
            System.out.println(" --floor 2-- ");
            System.out.println(" --------------------------------------- ");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |   7   |   8   |   9   |  10   |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("|       |       |       |       |       |");
            System.out.println("        -------------------------------- ");
            System.out.println("|                                       |");
            System.out.println("|                                       |");
            System.out.println("                  ---------------------- ");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|                 |  11  |  12   |  13  |");
            System.out.println("|                 |      |       |      |");
            System.out.println("|      exit       |      |       |      |");
            System.out.println(" ----------------------------------------");
        }
    }
}
