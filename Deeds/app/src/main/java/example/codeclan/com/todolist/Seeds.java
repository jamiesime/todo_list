package example.codeclan.com.todolist;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 13/11/2017.
 */

public class Seeds {

    public static void seedTasks() {

        Task deed1 = new Task("clean room", new Date(), "gotta get the room nice and clean", Priority.ESSENTIAL, DeedType.TEST, true);

        deed1.save();

    }




}
