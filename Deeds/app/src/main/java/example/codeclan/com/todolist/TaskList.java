package example.codeclan.com.todolist;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
}
