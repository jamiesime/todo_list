package example.codeclan.com.todolist;

/**
 * Created by user on 13/11/2017.
 */

public enum DeedType {

    TEST("Test Type");

    private String name;

    DeedType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
