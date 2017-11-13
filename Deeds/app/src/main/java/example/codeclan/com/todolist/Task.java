package example.codeclan.com.todolist;


import java.util.Date;
import example.codeclan.com.todolist.db.SqlRunner;


/**
 * Created by user on 12/11/2017.
 */

public class Task {


    private int id;
    private String title;
    private String date;
    private String details;
    private Priority priority;
    private DeedType type;
    private boolean complete;


    public Task(int id, String title, String date, String details, Priority priority, DeedType type, boolean complete) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.details = details;
        this.priority = priority;
        this.type = type;
        this.complete = complete;
    }

    public Task(String title, String date, String details, Priority priority, DeedType type, boolean complete) {
        this.title = title;
        this.date = date;
        this.details = details;
        this.priority = priority;
        this.type = type;
        this.complete = complete;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public Priority getPriority() {
        return priority;
    }

    public DeedType getType() {
        return type;
    }



    public boolean isComplete() {
        return complete;
    }

    public int isCompleteToInt(){
        if (complete){
            return 1;
        }
        else {
            return 0;
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
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


    public void save(){
        String sql = String.format("INSERT INTO tasks (title, due_date, details, priority, type, complete) VALUES ('%s', '%s', '%s', '%s', '%s', '%i')", this.title, this.getDate(), this.details, this.getPriority().getName(), this.getType().getName(), this.isCompleteToInt());
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

}
