import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class App {
    private TaskList list = new TaskList();

    public static void main(String[] args) {
        App app = new App();

    }

    // prompt to ask user whether to create new list or load saved list
    public static String mainMenuPrompt() {
        System.out.println("Main Menu");
        System.out.println("------------");
        System.out.println("          ");
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit");
        System.out.println("          ");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        // return user input string
        return done;
    }

    // print list operation menu prompt
    public static String listOperationMenuPrompt() {
        System.out.println("List Operation Menu");
        System.out.println("----------------------");
        System.out.println("          ");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu");
        System.out.println("          ");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        // return user input string
        return done;
    }

    // create a program that allows the user to view the tasks in the list
        // print all TaskItems in TaskList
        // open list operation menu

    // create a program that allows the user to create a task
    public void createTaskItem(TaskList userList, int index) {
        // take name/description/date
        String title = getTitle();
        String description = getDescription();
        String date = getDate();

        // create TaskItem
        TaskItem entry = new TaskItem(title, description, date);

        // add to TaskList
        list.add(index, entry);
    }

        // create a program that allows the user to edit a task
            // print all TaskItems in TaskList
            // prompt user to choose which task to edit
            // change name/description/date of selected TaskItem
            // open list operation menu

        // create a program that marks a task as completed
            // displays uncompleted tasks
            // asks user which to mark as completed
            // changes selected TaskItem to completed status
            // open list operation menu

        // create a program that un-marks a task as completed
            // displays completed tasks
            // asks user which to revert to uncompleted
            // changes selected TaskItem to uncompleted status
            // open list operation menu

        // create a program which allows the user to remove a listed task
            // displays all tasks
            // prompt user to choose which TaskItem to select
            // removes TaskItem from TaskList
            // open list operation menu

        // create a program which allows the user to save the list to a .txt file
            // asks user to enter the filename to save under
            // saves TaskList to .txt file of given name
            // open list operation menu

    // option to quit
    // return to main menu

    // create a program that allows the user to load a saved list
        // asks user to enter the filename of the saved list
        // writes in TaskList using .txt file
        // open list operation menu

    // quit option
    // exit

    public String getTitle() {
        // will ask the user to reenter a title is field is left empty
        Scanner input = new Scanner(System.in);
        String title = "";
        while(true) {
            System.out.println("Task title: ");
            title = input.nextLine();

            if(isStringValid(title)) {
                break;
            }
        }
        return title;
    }

    public String getDescription() {
        // will ask the user to reenter a title is field is left empty
        Scanner input = new Scanner(System.in);
        String description = "";
        while(true) {
            System.out.println("Task description: ");
            description = input.nextLine();

            if(isStringValid(description)) {
                break;
            }
        }
        return description;
    }

    public String getDate() {
        // will ask the user to reenter a title is field is left empty
        Scanner input = new Scanner(System.in);
        String date = "";
        while(true) {
            System.out.println("Task due date (YYYY-MM-DD): ");
            date = input.nextLine();

            if(isStringValid(date)) {
                break;
            }
        }
        return date;
    }

    public boolean isStringValid(String entry) {
        return entry.length() > 0;
    }

}
