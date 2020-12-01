import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class UserApp {

    // initialize scanner
    private static Scanner input = new Scanner(System.in);

    // prompt to ask user whether to create new list or load saved list
    public static int appMenuPrompt() {
        System.out.println("Select Your Application");
        System.out.println("------------");
        System.out.println("          ");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit\n");

        // read input from user
        String done = input.nextLine();
        // return user input as int
        return Integer.parseInt(done);
    }

    public static void main(String[] args) throws IOException {
        // create instances of both app classes
        TaskApp taskApp = new TaskApp();
        ContactApp contactApp = new ContactApp();

        // main menu
        int loop = 1;

        while (loop == 1) {
            int option = appMenuPrompt();
            switch (option) {
                case 1:
                    taskApp.mainMenuInterface();
                    break;

                case 2:
                    contactApp.mainMenuInterface();
                    break;

                case 3:
                    loop = 0;
                    break;
            }
        }
    }
}
