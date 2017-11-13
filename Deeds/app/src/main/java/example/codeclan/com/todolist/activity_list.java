package example.codeclan.com.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class activity_list extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        TaskList tasks = new TaskList();
        ArrayList<Task> allDeeds = tasks.allTasks();

        ListAdapter listAdapter = new ListAdapter(this, allDeeds);
        ListView listView = (ListView) findViewById(R.id.deed_list);
        listView.setAdapter(listAdapter);

    }

}
