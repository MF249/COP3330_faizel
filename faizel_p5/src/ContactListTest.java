import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {

    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        assertEquals(0, list.size());
    }

    @Test
    public void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("John","", "", "");
        list.add(item);

        assertEquals(1, list.size());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("John","", "", "");
        list.add(item);
        list.remove(0);

        assertEquals(0, list.size());
    }

    @Test
    public void gettingItemWithInvalidIndexFails() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("John","", "", "");
        list.add(item);

        assertThrows(ContactList.InvalidListIndexException.class, () -> list.get(1));
    }

    @Test
    public void emptyListCheckFailsWithNoItemsInList() {
        ContactList list = new ContactList();
        assertThrows(ContactList.InvalidEmptyListException.class, () -> list.emptyListCheck());
    }

    @Test
    public void emptyListCheckSucceedsWithItemsInList() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem("John","", "", "");
        list.add(item);
        assertDoesNotThrow(() -> list.emptyListCheck());
    }

    @Test
    public void savedContactListCanBeLoaded() throws IOException {
        // assumes list contains identical contact in sampleout2.txt to contact in listOne
        ContactApp a = new ContactApp();
        ContactList listOne = new ContactList();
        ContactItem task = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        listOne.add(task);
        ContactList listTwo = a.readList("sampleout2.txt");

        ContactItem tempOne = listOne.get(0);
        ContactItem tempTwo = listTwo.get(0);

        assertEquals(tempOne.getFirstName(), tempTwo.getFirstName());
        assertEquals(tempOne.getLastName(), tempTwo.getLastName());
        assertEquals(tempOne.getPhoneNumber(), tempTwo.getPhoneNumber());
        assertEquals(tempOne.getEmailAddress(), tempTwo.getEmailAddress());
    }
}
