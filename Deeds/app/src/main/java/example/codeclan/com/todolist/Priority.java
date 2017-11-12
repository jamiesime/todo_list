package example.codeclan.com.todolist;

/**
 * Created by user on 12/11/2017.
 */

public enum Priority {

    ESSENTIAL("Essential"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private String name;

    Priority(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
