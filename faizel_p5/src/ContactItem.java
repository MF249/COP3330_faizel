public class ContactItem {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress) {
        int counter = 0;

        this.firstName = firstName;
        if(this.firstName.length() > 0) {
            counter++;
        }

        this.lastName = lastName;
        if(this.lastName.length() > 0) {
            counter++;
        }

        this.phoneNumber = phoneNumber;
        if(this.phoneNumber.length() > 0) {
            counter++;

            if(!isNumberValid(this.phoneNumber)) {
                throw new InvalidPhoneNumberException("invalid phone number format; must be in xxx-xxx-xxxx format");
            }
        }

        this.emailAddress = emailAddress;
        if(this.emailAddress.length() > 0) {
            counter++;

            if(!isEmailValid(this.emailAddress)) {
                throw new InvalidEmailException("invalid email format; must contain '@'");
            }
        }

        if(counter < 1) {
            throw new InvalidContactItemException("invalid contact item creation; please fill out at least one field");
        }

    }

    public void setFirstName(String firstName) {
        if(firstName.length() < 1 && lastName.length() < 1 && phoneNumber.length() < 1 && emailAddress.length() < 1) {
            throw new InvalidFirstNameChangeException("all fields are blank; please enter a first name");
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if(firstName.length() < 1 && lastName.length() < 1 && phoneNumber.length() < 1 && emailAddress.length() < 1) {
            throw new InvalidLastNameChangeException("all fields are blank; please enter a last name");
        } else {
            this.lastName = lastName;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if(firstName.length() < 1 && lastName.length() < 1 && phoneNumber.length() < 1 && emailAddress.length() < 1) {
            throw new InvalidPhoneNumberChangeException("all fields are blank; please enter a phone number");
        } else {
            if(phoneNumber.length() < 1) {
                this.phoneNumber = phoneNumber;
            } else {
                if (isNumberValid(phoneNumber)) {
                    this.phoneNumber = phoneNumber;
                } else {
                    throw new InvalidPhoneNumberException("invalid phone number format; must be in xxx-xxx-xxxx format");
                }
            }
        }
    }

    public void setEmailAddress(String emailAddress) {
        if(firstName.length() < 1 && lastName.length() < 1 && phoneNumber.length() < 1 && emailAddress.length() < 1) {
            throw new InvalidEmailChangeException("all fields are blank; please enter an email address");
        } else {
            if(emailAddress.length() < 1) {
                this.emailAddress = emailAddress;
            } else {
                if (isEmailValid(emailAddress)) {
                    this.emailAddress = emailAddress;
                } else {
                    throw new InvalidEmailException("invalid email format; must contain '@'");
                }
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private boolean isNumberValid(String input) {
        return input.matches("([0-9]{3})-([0-9]{3})-([0-9]{4})");
    }

    private boolean isEmailValid(String input) {
        String mustContain = "@";

        for (char c : mustContain.toCharArray()) {
            if (input.indexOf(c) != -1) return true;
        }
        return false;
    }

    static class InvalidPhoneNumberException extends IllegalArgumentException {
        public InvalidPhoneNumberException(String msg) { super(msg); }
    }

    static class InvalidEmailException extends IllegalArgumentException {
        public InvalidEmailException(String msg) { super(msg); }
    }

    static class InvalidContactItemException extends IllegalArgumentException {
        public InvalidContactItemException(String msg) {
            super(msg);
        }
    }

    static class InvalidFirstNameChangeException extends IllegalArgumentException {
        public InvalidFirstNameChangeException(String msg) {
            super(msg);
        }
    }

    static class InvalidLastNameChangeException extends IllegalArgumentException {
        public InvalidLastNameChangeException(String msg) {
            super(msg);
        }
    }

    static class InvalidPhoneNumberChangeException extends IllegalArgumentException {
        public InvalidPhoneNumberChangeException(String msg) {
            super(msg);
        }
    }

    static class InvalidEmailChangeException extends IllegalArgumentException {
        public InvalidEmailChangeException(String msg) {
            super(msg);
        }
    }
}
