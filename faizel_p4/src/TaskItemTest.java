import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithEmptyDueDate() {
        assertThrows(TaskItem.InvalidEmptyDateException.class, () -> new TaskItem("Dinner", "McDonald's", ""));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidFormattedDueDate() {
        assertThrows(TaskItem.InvalidDateFormatException.class, () -> new TaskItem("Dinner", "McDonald's", "08-19-2010"));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(TaskItem.InvalidTitleException.class, () -> new TaskItem("", "McDonald's", "2010-08-19"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2010-08-19");
        assertEquals("2010-08-19", task.date);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2010-08-19");
        assertEquals("Dinner", task.title);
    }

    @Test
    public void settingTaskItemDueDateFailsWithEmptyDate() {
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2010-08-19");
        assertThrows(TaskItem.InvalidEmptyDateException.class, () -> task.setDate(""));
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidFormattedDate() {
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2010-08-19");
        assertThrows(TaskItem.InvalidDateFormatException.class, () -> task.setDate("20-08-19"));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2010-08-19");
        task.setDate("2010-08-26");
        assertEquals("2010-08-26", task.date);
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2010-08-19");
        assertThrows(TaskItem.InvalidTitleException.class, () -> task.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem task = new TaskItem("Dinner", "McDonald's", "2010-08-19");
        task.setTitle("Lunch");
        assertEquals("Lunch", task.title);
    }
}
