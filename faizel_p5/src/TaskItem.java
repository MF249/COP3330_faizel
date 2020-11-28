public class TaskItem {
    protected String title;
    protected String description;
    protected String date;
    protected Boolean completion;

    public TaskItem(String title, String description, String date) {
        if(isStringValid(title)) {
            this.title = title;
        } else {
            throw new InvalidTitleException("title field left empty; must be at least one character long");
        }

        if(isStringValid(description)) {
            this.description = description;
        } else {
            throw new InvalidDescriptionException("description field left empty; must be at least one character long");
        }

        if(isStringValid(date)) {
            if(isDateValid(date)) {
                this.date = date;
            } else {
                throw new InvalidDateFormatException("invalid date format used; must be in YYYY-MM-DD format");
            }
        } else {
            throw new InvalidEmptyDateException("date field left empty; must be at least one character long");
        }

        completion = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public Boolean getCompletion() {
        return completion;
    }

    protected void setTitle(String title) {
        if(isStringValid(title)) {
            this.title = title;
        }
        else {
            throw new InvalidTitleException("title field left empty; must be at least one character long");
        }
    }

    protected void setDescription(String description) {
        if(isStringValid(description)) {
            this.description = description;
        }
        else {
            throw new InvalidDescriptionException("description field left empty; must be at least one character long");
        }
    }

    protected void setDate(String date) {
        if(isStringValid(date)) {
            if(isDateValid(date)) {
                this.date = date;
            }
            else {
                throw new InvalidDateFormatException("invalid date format used; must be in YYYY-MM-DD format");
            }
        }
        else {
            throw new InvalidEmptyDateException("date field left empty; must be at least one character long");
        }

    }

    protected void setCompletion(Boolean completion) {
        if(completion != this.completion) {
            this.completion = completion;
        } else {
            throw new InvalidCompletionStatusException("task already desired status; please choose a different task");
        }
    }

    private boolean isStringValid(String entry) {
        return entry.length() > 0;
    }

    private boolean isDateValid(String entry) {
        return entry.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})");
    }

    static class InvalidTitleException extends IllegalArgumentException {
        public InvalidTitleException(String msg) {
            super(msg);
        }
    }

    static class InvalidDescriptionException extends IllegalArgumentException {
        public InvalidDescriptionException(String msg) {
            super(msg);
        }
    }

    static class InvalidEmptyDateException extends IllegalArgumentException {
        public InvalidEmptyDateException(String msg) {
            super(msg);
        }
    }

    static class InvalidDateFormatException extends IllegalArgumentException {
        public InvalidDateFormatException(String msg) {
            super(msg);
        }
    }

    static class InvalidCompletionStatusException extends IllegalArgumentException {
        public InvalidCompletionStatusException(String msg) {
            super(msg);
        }
    }
}
