package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017103 on 11/5/2017.
 */

public class TaskAdapter extends ArrayAdapter {
    private ArrayList<Task> tasks;
    private Context context;
    private TextView tvId, tvDesc, tvDate;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);

        tasks = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvId = (TextView) rowView.findViewById(R.id.tvID);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);

        Task currentType = tasks.get(position);
        tvId.setText(""+currentType.getId());
        tvDate.setText(currentType.getDate());
        tvDesc.setText(currentType.getDescription());
        return rowView;
    }
}
