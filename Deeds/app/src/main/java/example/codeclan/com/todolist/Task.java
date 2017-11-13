package example.codeclan.com.todolist;


import java.sql.ResultSet;
import java.util.ArrayList;

import db.SqlRunner;

import static android.R.attr.value;
import static java.lang.String.valueOf;


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

    public String isCompleteToString(){
        if (complete){
            return "true";
        }
        else {
            return "false";
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

    public static Priority priorityToEnum(String priority){
        for (Priority value : Priority.values()){
            if (value.getName().equals(priority)){
                return Priority.valueOf(priority);

            }
        }
        return Priority.LOW;
    }

    public static DeedType typeToDeedType(String type){
        for (DeedType value : DeedType.values()){
            if (value.getName().equals(type)){
                return DeedType.valueOf(type);

            }
        }
        return DeedType.TEST;
    }

    public static boolean completeToBool(String complete){
        if (complete.equals("true")){
            return true;
        }
        else {
            return false;
        }
    }

    public void save(){
        String sql = String.format("INSERT INTO tasks (title, due_date, details, priority, type, complete) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", this.title, this.getDate(), this.details, this.getPriority().getName(), this.getType().getName(), this.isCompleteToString());
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void deleteAll(){
        String sql = String.format("DELETE FROM tasks;");
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete(){
        String sql = String.format("DELETE FROM tasks WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update(){
        String sql = String.format("UPDATE tasks SET (title = '%s', due_date = '%s', details = '%s', priority = '%s', type = '%s', complete = '%s') WHERE id = %d;", this.title, this.date, this.details, this.getPriority().getName(), this.getType().getName(), this.isCompleteToString(), this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static ArrayList<Task> map(ResultSet rs){
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String date = rs.getString("due_date");
                String details = rs.getString("details");
                String priority = rs.getString("priority");
                String type = rs.getString("type");
                String complete = rs.getString("complete");

                tasks.add(new Task(title, date, details, priorityToEnum(priority), typeToDeedType(type), completeToBool(complete)));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
        } finally {
            SqlRunner.closeConnection();
        }
        return tasks;
    }

}
