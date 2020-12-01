import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class ContactList {
    private ArrayList<ContactItem> userList;

    public ContactList() {
        userList = new ArrayList<ContactItem>();
    }

    public void add(ContactItem entry) {
        userList.add(entry);
    }

    public ContactItem get(int index) {
        if(index < userList.size()) {
            return userList.get(index);
        }
        else {
            throw new InvalidListIndexException("contact does not exist in list; number must match with contact number");
        }
    }

    public void remove(int index) {
        userList.remove(index);
    }

    public int size() {
        return userList.size();
    }

    public void listPrint() {
        System.out.println("Current Tasks");
        System.out.println("-----------------\n");
        for(int i = 0; i < userList.size(); i++) {
            ContactItem temp = userList.get(i);
            System.out.println(i + ") Name: " + temp.getFirstName() + " " + temp.getLastName());
            System.out.println("Phone: " + temp.getPhoneNumber());
            System.out.println("Email: " + temp.getEmailAddress());
        }
    }

    public void emptyListCheck() {
        if(userList.size() != 0) {
        } else {
            throw new InvalidEmptyListException("list contains no contacts; please create a contact first");
        }
    }

    public void writeList(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < userList.size(); i++) {
                ContactItem temp = userList.get(i);
                output.format("%s%n", temp.getFirstName());
                output.format("%s%n", temp.getLastName());
                output.format("%s%n", temp.getPhoneNumber());
                output.format("%s%n", temp.getEmailAddress());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...\n");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static class InvalidListIndexException extends IllegalArgumentException {
        public InvalidListIndexException(String msg) {
            super(msg);
        }
    }

    static class InvalidEmptyListException extends IllegalArgumentException {
        public InvalidEmptyListException(String msg) {
            super(msg);
        }
    }
}
