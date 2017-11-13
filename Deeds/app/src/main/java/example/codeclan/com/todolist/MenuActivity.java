package example.codeclan.com.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void navToCreate(View button){
        Intent i = new Intent (this, activity_create.class);
        startActivity(i);
    }

    public void navToSearch(View button){
        Intent i = new Intent (this, activity_search.class);
        startActivity(i);
    }

    public void navToList(View button){
        Intent i = new Intent (this, activity_list.class);
        startActivity(i);
    }

    public void navToInfo(View button){
        Intent i = new Intent (this, activity_info.class);
        startActivity(i);
    }
}
