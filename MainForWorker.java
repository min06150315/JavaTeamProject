package JavaTeamProject;

import java.util.Scanner;

public class MainForWorker {
    public static void main(String[] args) {
        Worker s = new Worker();
        Scanner k = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("\n1.Show List 2.Item Location 3.Clear Work > ");

            choice = k.nextInt();

            if (choice == 1) {
                s.ShowWorkList();
            }else if (choice == 2){
                System.out.print("If you want to know Where is item, Enter num (0r not need, Enter -1): ");
                int where = k.nextInt();
                s.ShowLocation(where);
            } else if (choice == 3) {
                k.nextLine();
                System.out.print("Enter clear order name: ");
                String what = k.nextLine();
                int result = s.ClearWork(what);
                if (result == 1) {
                    // 일을 다 끝냈다는 것의 확인 하기 위해서 txt파일 만들기
                    s.SendMessage();
                    // s.PrintStateEndOrNot();
                    break;
                }
            }
        }
    }
}
