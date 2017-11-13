package example.codeclan.com.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 13/11/2017.
 */

public class ListAdapter extends ArrayAdapter<Task> {

    public ListAdapter(Context context, ArrayList<Task> taskList){
        super(context, 0, taskList);
    }

    public View getView(int position, View listItemView, ViewGroup parent){
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_deed_list, parent, false);
        }
        Task currentTask = getItem(position);
        TextView taskTitle = (TextView) listItemView.findViewById(R.id.title);
        TextView taskDate = (TextView) listItemView.findViewById(R.id.date);
        taskTitle.setText(currentTask.getTitle());
        taskDate.setText(currentTask.getDate());


        listItemView.setTag(currentTask);
        return listItemView;
    }

}
