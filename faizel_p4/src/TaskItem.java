import java.util.Scanner;

public class TaskItem {
    protected String title;
    protected String description;
    protected String date;

    public TaskItem(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public boolean isStringValid(String entry) {
        return entry.length() > 0;
    }
}
