package JavaTeamProject;

import java.util.Scanner;

public class MainForWorker {
    public static void main(String[] args) {
        Worker s = new Worker();
        Scanner k = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("1. showList 2. Where item 3. Clear work");

            choice = k.nextInt();

            if (choice == 1) {
                s.ShowWorkList();
            }else if(choice == 2){
                System.out.println("If you want to know Where is item, Enter num (0r not need, Enter -1): ");
                int where = k.nextInt();
                s.ShowWhere(where);
            } else if (choice == 3) {
                k.nextLine();
                System.out.println("Enter clear order name: ");
                String what = k.nextLine();
                int result = s.clearWork(what);
                if(result == 1){
                    break;
                }
            }

        }
        //일을 다 했다는 것 => 배송시작 즉, 영수증 주고 난 돈 받고~~~~
    }
}
