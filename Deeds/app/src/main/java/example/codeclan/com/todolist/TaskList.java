package example.codeclan.com.todolist;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.SqlRunner;

import static example.codeclan.com.todolist.Task.completeToBool;
import static example.codeclan.com.todolist.Task.priorityToEnum;
import static example.codeclan.com.todolist.Task.typeToDeedType;

/**
 * Created by user on 12/11/2017.
 */

public class TaskList {

    private ArrayList<Task> allTasks;


    public TaskList() {
        allTasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getAllTasks() {
        return allTasks;
    }

    public int getNumberOfTasks(){
        return allTasks.size();
    }

    public void addToTaskList(Task newTask){
        allTasks.add(newTask);
    }

    public ArrayList<Task> allTasks(){
        String sql = String.format("SELECT * FROM tasks;");
        ResultSet rs = SqlRunner.executeQuery(sql);
        return map(rs);
    }

    public ArrayList<Task> map(ResultSet rs){
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
