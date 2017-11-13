package example.codeclan.com.todolist;

import java.util.Date;

/**
 * Created by user on 12/11/2017.
 */

public class Task {

    private String title;
    private Date date;
    private String details;
    private Priority priority;
    private DeedType type;
    private boolean complete;

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }



}
