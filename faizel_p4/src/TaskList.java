import java.util.ArrayList;

public class TaskList {
    private ArrayList<TaskItem> userList;

    public void add(int index, TaskItem entry) {
        userList.add(index, entry);
    }
}
