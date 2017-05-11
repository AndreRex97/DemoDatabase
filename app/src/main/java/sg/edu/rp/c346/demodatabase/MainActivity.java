package sg.edu.rp.c346.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView lvTasks;
    ArrayList<Task> TaskList = new ArrayList<Task>();
    TaskAdapter caTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnGetTasks = (Button) findViewById(R.id.btnGetTasks);
        tvResults = (TextView) findViewById(R.id.tvResults);
        lvTasks = (ListView) findViewById(R.id.lvTasks);
        caTask = new TaskAdapter(this, R.layout.row, TaskList);
        lvTasks.setAdapter(caTask);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the DBHelper object, passing in the

                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the DBHelper object, passing in the

                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Task> data = db.getTaskContent();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++){
                    Log.d("Database Content", i + ". " + data.get(i));
                    txt += i + ". " + data.get(i).getDescription() + "\n";
                    TaskList.add(new Task(data.get(i).getId(), data.get(i).getDescription(), data.get(i).getDate()));

                }
                tvResults.setText(txt);
                caTask.notifyDataSetChanged();
            }
        });
    }
}
