import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {
        assertThrows(ContactItem.InvalidContactItemException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        assertDoesNotThrow(() -> new ContactItem("John", "Doe", "111-111-1111", ""));
    }

    @Test
    public void creationFailsWithInvalidEmailAddress() {
        assertThrows(ContactItem.InvalidEmailException.class, () -> new ContactItem("John", "Doe", "111-111-1111", "johndoe.com"));
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        assertDoesNotThrow(() -> new ContactItem("", "Doe", "111-111-1111", "johndoe@email.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        assertDoesNotThrow(() -> new ContactItem("John", "", "111-111-1111", "johndoe@email.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhoneNumber() {
        assertDoesNotThrow(() -> new ContactItem("John", "Doe", "", "johndoe@email.com"));
    }

    @Test
    public void creationFailsWithInvalidPhoneNumber() {
        assertThrows(ContactItem.InvalidPhoneNumberException.class, () -> new ContactItem("John", "Doe", "1111111111", "johndoe@email.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");
        assertEquals(contact.getFirstName(), "John");
        assertEquals(contact.getLastName(), "Doe");
        assertEquals(contact.getPhoneNumber(), "111-111-1111");
        assertEquals(contact.getEmailAddress(), "johndoe@email.com");
    }

    @Test
    public void editingFirstNameFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("John", "", "", "");
        assertThrows(ContactItem.InvalidFirstNameChangeException.class, () -> contact.setFirstName(""));
    }

    @Test
    public void editingLastNameFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("", "Doe", "", "");
        assertThrows(ContactItem.InvalidLastNameChangeException.class, () -> contact.setLastName(""));
    }

    @Test
    public void editingPhoneNumberFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("", "", "111-111-1111", "");
        assertThrows(ContactItem.InvalidPhoneNumberChangeException.class, () -> contact.setPhoneNumber(""));
    }

    @Test
    public void editingEmailFailsWithAllBlankValues() {
        ContactItem contact = new ContactItem("", "", "", "johndoe@email.com");
        assertThrows(ContactItem.InvalidEmailChangeException.class, () -> contact.setEmailAddress(""));
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "");
        assertDoesNotThrow(() -> contact.setEmailAddress("johndoe@email.com"));
    }

    @Test
    public void editingFailsWithInvalidEmail() {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "");
        assertThrows(ContactItem.InvalidEmailException.class, () -> contact.setEmailAddress("johndoe.com"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactItem contact = new ContactItem("", "Doe", "111-111-1111", "johndoe@email.com");
        assertDoesNotThrow(() -> contact.setFirstName("John"));
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactItem contact = new ContactItem("John", "", "111-111-1111", "johndoe@email.com");
        assertDoesNotThrow(() -> contact.setLastName("Doe"));
    }

    @Test
    public void editingSucceedsWithBlankPhoneNumber() {
        ContactItem contact = new ContactItem("John", "Doe", "", "johndoe@email.com");
        assertDoesNotThrow(() -> contact.setPhoneNumber("111-111-1111"));
    }

    @Test
    public void editingFailsWithInvalidPhoneNumber() {
        ContactItem contact = new ContactItem("John", "Doe", "", "johndoe@email.com");
        assertThrows(ContactItem.InvalidPhoneNumberException.class, () -> contact.setPhoneNumber("1111111111"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactItem contact = new ContactItem("John", "Doe", "111-111-1111", "johndoe@email.com");

        contact.setFirstName("Joe");
        contact.setLastName("Dohn");
        contact.setPhoneNumber("999-999-9999");
        contact.setEmailAddress("joedohn@email.com");

        assertEquals(contact.getFirstName(), "Joe");
        assertEquals(contact.getLastName(), "Dohn");
        assertEquals(contact.getPhoneNumber(), "999-999-9999");
        assertEquals(contact.getEmailAddress(), "joedohn@email.com");
    }
}
