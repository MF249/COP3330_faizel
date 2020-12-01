import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class ContactApp {
    // initialize scanner
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // create instance of ContactApp
        ContactApp app = new ContactApp();
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

        // read input from user
        String done = input.nextLine();
        // return user input as int
        return Integer.parseInt(done);
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
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu\n");

        // read input from user
        String done = input.nextLine();
        // return user input as int
        return Integer.parseInt(done);
    }

    public static int editContactPrompt() {
        System.out.println("\nWhich task will you edit?");

        // read input from user
        String done = input.nextLine();
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    public static int deleteContactPrompt() {
        System.out.println("\nWhich task will you remove?");

        // read input from user
        String done = input.nextLine();
        // return user input as int
        int output = Integer.parseInt(done);
        return output;
    }

    public static String writeAndSaveListPrompt() {
        System.out.println("Enter the filename to save as: ");

        // read input from user
        String done = input.nextLine();
        return done;
    }

    public static String loadSavedListPrompt() {
        System.out.println("Enter the filename to load: ");

        // read input from user
        String done = input.nextLine();
        return done;
    }

    // create a program that allows the user to create a task
    private void createContactItem(ContactList list) {
        ContactItem entry = null;

        while(true) {
            try {
                // take user inputs
                String firstName = getFirstName();
                String lastName = getLastName();
                String phoneNumber = getPhoneNumber();
                String emailAddress = getEmailAddress();

                // create ContactItem
                entry = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                break;
            } catch (ContactItem.InvalidPhoneNumberException ex) {
                System.out.println("WARNING: phone number does not match xxx-xxx-xxxx; please try again\n");
            } catch (ContactItem.InvalidEmailException ex) {
                System.out.println("WARNING: email must contain an @ symbol before domain; please try again\n");
            } catch (ContactItem.InvalidContactItemException ex) {
                System.out.println("WARNING: at least on field must be filled; please try again\n");
            }
        }

        // add to ContactList
        list.add(entry);
    }

    // create a program that allows the user to edit a task
    private void editContactItem(ContactList list) {
        try {
            // print all TaskItems in TaskList
            list.listPrint();
            // prompt user to choose which task to edit
            int editNumber = editContactPrompt();
            // change name/description/date of selected TaskItem
            ContactItem temp = list.get(editNumber);

            String entry = getFirstName();
            temp.setFirstName(entry);

            entry = getLastName();
            temp.setLastName(entry);

            entry = getPhoneNumber();
            temp.setPhoneNumber(entry);

            entry = getEmailAddress();
            temp.setEmailAddress(entry);
        } catch (ContactItem.InvalidFirstNameChangeException ex) {
            System.out.println("all other fields are blank; please enter a first name\n");
        } catch (ContactItem.InvalidLastNameChangeException ex) {
            System.out.println("all other fields are blank; please enter a last name\n");
        } catch (ContactItem.InvalidEmailChangeException ex) {
            System.out.println("all other fields are blank; please enter an email\n");
        } catch (ContactItem.InvalidPhoneNumberChangeException ex) {
            System.out.println("all other fields are blank; please enter a phone number\n");
        } catch (ContactList.InvalidListIndexException ex) {
            System.out.println("contact does not exist; please delete an existing task\n");
        }
    }

    // create a program which allows the user to remove a listed task
    private void deleteContactItem(ContactList list) {
        // displays all tasks
        list.listPrint();
        while(true) {
            try {
                // prompt user to choose which TaskItem to select
                int deleteNumber = deleteContactPrompt();
                // gets task to check if task exists
                list.get(deleteNumber);
                // removes TaskItem from TaskList
                list.remove(deleteNumber);
                break;
            } catch (ContactList.InvalidListIndexException ex) {
                System.out.println("WARNING: contact does not exist; please delete an existing contact");
            }
        }
    }

    protected void mainMenuInterface() throws IOException {
        ContactList list = null;
        int loop = 1;

        while(loop == 1) {
            int option = mainMenuPrompt();
            int resume = 1;
            switch (option) {
                case 1:
                    list = new ContactList();
                    System.out.println("new contact list has been created");
                    while (resume == 1) {
                        resume = listOperationInterface(list, resume);
                    }
                    break;

                case 2:
                    String filename = loadSavedListPrompt();
                    list = readList(filename);
                    System.out.println("contact list has been loaded");
                    while (resume == 1) {
                        resume = listOperationInterface(list, resume);
                    }
                    break;

                case 3:
                    loop = 0;
            }
        }
    }

    protected int listOperationInterface(ContactList list, int loop) {
        while(true) {
            try {
                int option = listOperationMenuPrompt();
                switch (option) {
                    case 1:
                        list.emptyListCheck();
                        list.listPrint();
                        return 1;

                    case 2:
                        createContactItem(list);
                        return 1;

                    case 3:
                        list.emptyListCheck();
                        editContactItem(list);
                        return 1;

                    case 4:
                        list.emptyListCheck();
                        deleteContactItem(list);
                        return 1;

                    case 5:
                        list.emptyListCheck();
                        String filename = writeAndSaveListPrompt();
                        list.writeList(filename);
                        System.out.println("Contact list has been saved");
                        return 1;

                    case 6:
                        return 0;
                }
            }  catch (ContactList.InvalidEmptyListException ex) {
                System.out.println("WARNING: List currently has no contacts; please first create a contact");
            }
        }
    }

    public static String getFirstName() {
        System.out.println("First name: ");
        return input.nextLine();
    }

    public static String getLastName() {
        System.out.println("Last name: ");
        return input.nextLine();
    }

    public static String getPhoneNumber() {
        System.out.println("Phone number (xxx-xxx-xxxx): ");
        return input.nextLine();
    }

    public static String getEmailAddress() {
        System.out.println("Email Address (x@y.z): ");
        return input.nextLine();
    }

    protected ContactList readList(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        ContactList list = new ContactList();
        String string;
        String[] stringArray = new String[4];
        int i = 0;

        while((string = br.readLine()) != null) {
            stringArray[i] = string;
            i++;

            if(i == 4) {
                ContactItem temp = new ContactItem(stringArray[0], stringArray[1], stringArray[2], stringArray[3]);
                list.add(temp);
                i = 0;
            }
        }
        fr.close();
        br.close();

        return list;
    }

}
