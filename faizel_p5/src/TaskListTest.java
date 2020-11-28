import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);

        assertEquals(1, list.size());
    }

    @Test
    public void completingTaskItemChangesStatus() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);
        task.setCompletion(true);

        assertEquals(true, task.getCompletion());
    }


    @Test
    public void gettingTaskItemFailsWithInvalidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);

        assertThrows(TaskList.InvalidListIndexException.class, () -> list.get(2));
    }

    @Test
    public void completingCompletedTaskItemFails() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);
        task.setCompletion(true);

        assertThrows(TaskItem.InvalidCompletionStatusException.class, () -> task.setCompletion(true));
    }

    @Test
    public void gettingTaskItemSucceedsWithValidIndex() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);

        assertEquals(task, list.get(0));
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList list = new TaskList();

        assertEquals(0, list.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        TaskApp a = new TaskApp();
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);
        list.remove(0);

        assertEquals(0, list.size());
    }

    @Test
    public void revertingCompletedTaskItemChangesStatus() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);
        task.setCompletion(true);
        task.setCompletion(false);

        assertEquals(false, task.getCompletion());
    }

    @Test
    public void emptyListCheckThrowsExceptionWhenListIsEmpty() {
        TaskList list = new TaskList();
        assertThrows(TaskList.InvalidEmptyListException.class, () -> list.emptyListCheck());
    }

    @Test
    public void typeListCheckThrowsExceptionWhenListHasNoTasksToComplete() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);
        task.setCompletion(true);
        assertThrows(TaskList.InvalidIncompletionAttemptException.class, () -> list.statusCheck(1));
    }

    @Test
    public void typeListCheckThrowsExceptionWhenListHasNoTasksToUncomplete() {
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);
        assertThrows(TaskList.InvalidCompletionAttemptException.class, () -> list.statusCheck(0));
    }

    @Test
    public void savingListToANewlyCreatedFileSucceeds() throws IOException {
        TaskApp a = new TaskApp();
        TaskList list = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        list.add(task);

        // file will be created in repository
        String filename = "randomfilename.txt";
        list.writeList(filename);

        TaskList listTwo = a.readList(filename);
        TaskItem temp = listTwo.get(0);
        assertEquals(task.getTitle(), temp.getTitle());
    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException {
        // assumes list contains identical task in sampleout.txt to task in listOne
        TaskApp a = new TaskApp();
        TaskList listOne = new TaskList();
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2020-10-20");
        listOne.add(task);
        TaskList listTwo = a.readList("sampleout.txt");

        TaskItem tempOne = listOne.get(0);
        TaskItem tempTwo = listTwo.get(0);

        assertEquals(tempOne.getTitle(), tempTwo.getTitle());
        assertEquals(tempOne.getDescription(), tempTwo.getDescription());
        assertEquals(tempOne.getDate(), tempTwo.getDate());
        assertEquals(tempOne.getCompletion(), tempTwo.getCompletion());
    }
}
