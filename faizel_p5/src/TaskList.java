import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class TaskList {
    private ArrayList<TaskItem> userList;

    public TaskList() {
        userList = new ArrayList<TaskItem>();
    }

    public void add(TaskItem entry) {
        userList.add(entry);
    }

    public TaskItem get(int index) {
        if(index < userList.size()) {
            return userList.get(index);
        }
        else {
            throw new InvalidListIndexException("task does not exist in list; number must match with task number");
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
            TaskItem temp = userList.get(i);

            if(temp.getCompletion()) {
                System.out.println(i + ") *** [" + temp.getDate() + "] " + temp.getTitle() + ": " + temp.getDescription());
            } else {
                System.out.println(i + ") [" + temp.getDate() + "] " + temp.getTitle() + ": " + temp.getDescription());
            }
        }
    }

    public void typeListPrint(int type) {
        switch (type) {
            case 0:
                // prints uncompleted tasks
                System.out.println("Uncompleted Tasks");
                System.out.println("-----------------\n");
                for (int i = 0; i < userList.size(); i++) {
                    TaskItem temp = userList.get(i);
                    Boolean status = temp.getCompletion();

                    if (!status) {
                        taskPrint(i, temp.getTitle(), temp.getDescription(), temp.getDate(), false);
                    }
                }
                break;

            case 1:
                // prints completed tasks
                System.out.println("Completed Tasks");
                System.out.println("-----------------\n");
                for (int i = 0; i < userList.size(); i++) {
                    TaskItem temp = userList.get(i);
                    Boolean status = temp.getCompletion();

                    if (status) {
                        taskPrint(i, temp.getTitle(), temp.getDescription(), temp.getDate(), true);
                    }
                }
                break;
        }
    }

    private void taskPrint(int itemNumber, String title, String description, String date, Boolean completion) {
        if(!completion) {
            System.out.println(itemNumber + ") [" + date + "] " + title + ": " + description);
        } else {
            System.out.println(itemNumber + ") *** [" + date + "] " + title + ": " + description);
        }
    }

    public void emptyListCheck() {
        if(userList.size() != 0) {
        } else {
            throw new InvalidEmptyListException("list contains no tasks; please create a task first");
        }
    }

    public void statusCheck(int type) {
        switch (type) {
            case 0:
                for(int i = 0; i < userList.size(); i++) {
                    TaskItem temp = userList.get(i);
                    if(temp.getCompletion()) {
                        return;
                    }
                }
                throw new InvalidCompletionAttemptException("no tasks are completed; please select another option");

            case 1:
                for(int i = 0; i < userList.size(); i++) {
                    TaskItem temp = userList.get(i);
                    if(!temp.getCompletion()) {
                        return;
                    }
                }
                throw new InvalidIncompletionAttemptException("all tasks are completed; please select another option");
        }
    }

    public void writeList(String filename) {
        try(Formatter output = new Formatter(filename)) {
            for(int i = 0; i < userList.size(); i++) {
                TaskItem temp = userList.get(i);
                output.format("%s,%s,%s,%b%n", temp.getTitle(), temp.getDescription(), temp.getDate(), temp.getCompletion());
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

    static class InvalidCompletionAttemptException extends IllegalArgumentException {
        public InvalidCompletionAttemptException(String msg) {
            super(msg);
        }
    }

    static class InvalidIncompletionAttemptException extends IllegalArgumentException {
        public InvalidIncompletionAttemptException(String msg) {
            super(msg);
        }
    }

    static class InvalidEmptyListException extends IllegalArgumentException {
        public InvalidEmptyListException(String msg) {
            super(msg);
        }
    }
}
