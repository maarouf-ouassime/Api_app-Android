package com.example.apirest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.apirest.Model.Task;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {

    private Context context;
    private  List<Task> tasks;

    public TaskAdapter(@NonNull Context context, int resource, @NonNull List<Task> objects) {
        super(context, resource, objects);
        this.context=context;
        this.tasks =objects;
    }

    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=layoutInflater.inflate(R.layout.content_main,parent,false);

        TextView txtidPersona=(TextView)rowView.findViewById(R.id.IdTask);
        TextView txtNombre=(TextView)rowView.findViewById(R.id.Nom);;
        TextView txtApellidos=(TextView)rowView.findViewById(R.id.Description);;

        txtidPersona.setText(String.format("ID:%d", tasks.get(position).getId()));
        txtNombre.setText(String.format("NOM:%s", tasks.get(position).getNom()));
        txtApellidos.setText(String.format("DESCRIPTION: %s", tasks.get(position).getDescription()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(context, TaskActivity.class);
               intent.putExtra("ID",String.valueOf(tasks.get(position).getId()));
               intent.putExtra("NOM", tasks.get(position).getNom());
                intent.putExtra("DESCRIPTION", tasks.get(position).getDescription());
               context.startActivity(intent);
            }
        });
        return rowView;

    }

}
