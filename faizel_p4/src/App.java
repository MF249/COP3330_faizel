import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        // create instance of App.java
        App app = new App();
        // prompt user to create/load list
        app.mainMenuInterface();
    }

    // prompt to ask user whether to create new list or load saved list
    public static int mainMenuPrompt() {
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
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    // print list operation menu prompt
    public static int listOperationMenuPrompt() {
        System.out.println("\nList Operation Menu");
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
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    public static int editTaskPrompt() {
        System.out.println("Which task will you edit?");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    public static int deleteTaskPrompt() {
        System.out.println("Which task will you remove?");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    public static int completeTaskPrompt() {
        System.out.println("Which task will you mark as completed?");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    public static int incompleteTaskPrompt() {
        System.out.println("Which task will you unmark as completed?");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    public static String writeAndSaveListPrompt() {
        System.out.println("Enter the filename to save as: ");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        return done;
    }

    public static String loadSavedListPrompt() {
        System.out.println("Enter the filename to load: ");

        // initialize scanner for input
        Scanner input = new Scanner(System.in);
        // read input from user
        String done = input.nextLine();
        return done;
    }

    // create a program that allows the user to create a task
    private void createTaskItem(TaskList list) {
        TaskItem entry = null;

        while(true) {
            try {
                // take name/description/date
                String title = getTitle();
                String description = getDescription();
                String date = getDate();

                // create TaskItem
                entry = new TaskItem(title, description, date);
                break;
            } catch (TaskItem.InvalidTitleException ex) {
                System.out.println("WARNING: title field left empty; must be at least one character long\n");
            } catch (TaskItem.InvalidDescriptionException ex) {
                System.out.println("WARNING: description field left empty; must be at least one character long\n");
            } catch (TaskItem.InvalidEmptyDateException ex) {
                System.out.println("WARNING: date field left empty; must be at least one character long\n");
            } catch (TaskItem.InvalidDateFormatException ex) {
                System.out.println("WARNING: invalid date format used; must be in YYYY-MM-DD format\n");
            }
        }

        // add to TaskList
        list.add(entry);
    }

    // create a program that allows the user to edit a task
    private void editTaskItem(TaskList list) {
        // print all TaskItems in TaskList
        list.listPrint();
        // prompt user to choose which task to edit
        int editNumber = editTaskPrompt();
        // change name/description/date of selected TaskItem
        TaskItem temp = list.get(editNumber);
        changeTitle(temp);
        changeDescription(temp);
        changeDate(temp);
    }

    // create a program that marks a task as completed
    private void completeTaskItem(TaskList list) {
        // displays uncompleted tasks
        list.typeListPrint(0);
        while(true) {
            try {
                // asks user which to mark as completed
                int completeNumber = completeTaskPrompt();
                // changes selected TaskItem to completed status
                TaskItem temp = list.get(completeNumber);
                temp.setCompletion(true);
                break;
            } catch (TaskList.InvalidListIndexException ex) {
                System.out.println("WARNING: task does not exist; please enter a different number");
            } catch (TaskItem.InvalidCompletionStatusException ex) {
                System.out.println("WARNING: task is already complete; please enter a different number");
            }
        }
    }

    // create a program that un-marks a task as completed
    private void incompleteTaskItem(TaskList list) {
        // displays completed tasks
        list.typeListPrint(1);
        while(true) {
            try {
                // asks user which to revert to uncompleted
                int incompleteNumber = incompleteTaskPrompt();
                // changes selected TaskItem to uncompleted status
                TaskItem temp = list.get(incompleteNumber);
                temp.setCompletion(false);
                break;
            } catch (TaskList.InvalidListIndexException ex) {
                System.out.println("WARNING: task does not exist; please enter a different number");
            } catch (TaskItem.InvalidCompletionStatusException ex) {
                System.out.println("WARNING: task is already incomplete; please enter a different number");
            }
        }
    }

    // create a program which allows the user to remove a listed task
    private void deleteTask(TaskList list) {
        // displays all tasks
        list.listPrint();
        while(true) {
            try {
                // prompt user to choose which TaskItem to select
                int deleteNumber = deleteTaskPrompt();
                // gets task to check if task exists
                list.get(deleteNumber);
                // removes TaskItem from TaskList
                list.remove(deleteNumber);
                break;
            } catch (TaskList.InvalidListIndexException ex) {
                System.out.println("WARNING: task does not exist; please delete an existing task");
            }
        }
    }


    private String getTitle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Task title: ");
        return input.nextLine();
    }

    private String getDescription() {
        Scanner input = new Scanner(System.in);
        System.out.println("Task description: ");
        return input.nextLine();
    }

    private String getDate() {
        Scanner input = new Scanner(System.in);
        System.out.println("Task due date (YYYY-MM-DD): ");
        return input.nextLine();
    }

    private void changeTitle(TaskItem task) {
        String newTitle = getTitle();
        task.setTitle(newTitle);
    }

    private void changeDescription(TaskItem task) {
        String newDescription = getDescription();
        task.setDescription(newDescription);
    }

    private void changeDate(TaskItem task) {
        String newDate = getDate();
        task.setDate(newDate);
    }

    protected void mainMenuInterface() throws IOException {
        TaskList list = null;
        int loop = 1;

        while(loop == 1) {
            int option = mainMenuPrompt();
            int resume = 1;
            switch (option) {
                case 1:
                    list = new TaskList();
                    System.out.println("new task list has been created");
                    while (resume == 1) {
                        resume = listOperationInterface(list, resume);
                    }
                    break;

                case 2:
                    String filename = loadSavedListPrompt();
                    list = readList(filename);
                    System.out.println("task list has been loaded");
                    while (resume == 1) {
                        resume = listOperationInterface(list, resume);
                    }
                    break;

                case 3:
                    loop = 0;
            }
        }
    }

    protected int listOperationInterface(TaskList list, int loop) {
        while(true) {
            try {
                int option = listOperationMenuPrompt();
                switch (option) {
                    case 1:
                        list.emptyListCheck();
                        list.listPrint();
                        return 1;

                    case 2:
                        createTaskItem(list);
                        return 1;

                    case 3:
                        list.emptyListCheck();
                        editTaskItem(list);
                        return 1;

                    case 4:
                        list.emptyListCheck();
                        deleteTask(list);
                        return 1;

                    case 5:
                        list.emptyListCheck();
                        list.statusCheck(1);
                        completeTaskItem(list);
                        return 1;

                    case 6:
                        list.emptyListCheck();
                        list.statusCheck(0);
                        incompleteTaskItem(list);
                        return 1;

                    case 7:
                        list.emptyListCheck();
                        String filename = writeAndSaveListPrompt();
                        list.writeList(filename);
                        System.out.println("Task list has been saved");
                        return 1;

                    case 8:
                        return 0;
                }
            } catch (TaskList.InvalidCompletionAttemptException ex) {
                System.out.println("WARNING: No tasks are completed; please select another option");
            } catch (TaskList.InvalidIncompletionAttemptException ex) {
                System.out.println("WARNING: All tasks are completed; please select another option");
            } catch (TaskList.InvalidEmptyListException ex) {
                System.out.println("WARNING: List currently has no tasks; please first create a task");
            }
        }
    }

    protected TaskList readList(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        TaskList list = new TaskList();
        String string;
        String[] stringArray;

        while((string = br.readLine()) != null) {
            stringArray = string.split(",");

            TaskItem temp = new TaskItem(stringArray[0], stringArray[1], stringArray[2]);
            if (Objects.equals("true", stringArray[3])) {
                temp.setCompletion(true);
            }
            list.add(temp);
        }
        fr.close();
        br.close();

        return list;
    }

}
