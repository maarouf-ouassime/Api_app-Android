package com.example.apirest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apirest.Model.Task;
import com.example.apirest.Utils.Apis;
import com.example.apirest.Utils.TaskService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskActivity extends AppCompatActivity {
    TaskService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);

        TextView idtas=(TextView)findViewById(R.id.Id);
        EditText txtId=(EditText)findViewById(R.id.txtId);
        TextView noms=(TextView)findViewById(R.id.Tasks);
        final EditText txtNoms=(EditText)findViewById(R.id.txtTasks);
        TextView descriptions=(TextView)findViewById(R.id.Descriptions);
        final EditText txtDescriptions=(EditText)findViewById(R.id.txtDescriptions);

        Button btnSave=(Button)findViewById(R.id.btnSave);
        Button btnReturn=(Button)findViewById(R.id.btnReturn);
        Button btnDelete=(Button)findViewById(R.id.btnDelete);


        Bundle bundle=getIntent().getExtras();
        final String id = bundle.getString("ID");
        String nom=bundle.getString("NOM");
        String ape=bundle.getString("DESCRIPTION");

        txtId.setText(id);
        txtNoms.setText(nom);
        txtDescriptions.setText(ape);
        if(id.trim().length()==0||id.equals("")){
            idtas.setVisibility(View.INVISIBLE);
            txtId.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task p=new Task();
                p.setNom(txtNoms.getText().toString());
                p.setDescription(txtDescriptions.getText().toString());
                if(id.trim().length()==0||id.equals("")){
                    addTask(p);
                    Intent intent =new Intent(TaskActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    updateTask(p,Integer.valueOf(id));
                    Intent intent =new Intent(TaskActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteTask(Integer.valueOf(id));
                Intent intent =new Intent(TaskActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TaskActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
   // public void addTask(Task p){
    public void addTask(Task p){
        service= Apis.getTaskService();
        Call<Task>call=service.addTask(p);
        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                if(response.isSuccessful()){
                    Toast.makeText(TaskActivity.this,"ajouté avec succès",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(TaskActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void updateTask(Task p, int id){
        service= Apis.getTaskService();
        Call<Task>call=service.updateTask(p,id);
        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                if(response.isSuccessful()){
                    Toast.makeText(TaskActivity.this,"Mis à jour avec succés",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(TaskActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void deleteTask(int id){
        service=Apis.getTaskService();
        Call<Task>call=service.deleteTask(id);
        call.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                if(response.isSuccessful()){
                    Toast.makeText(TaskActivity.this,"L'enregistrement a été supprimé",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
        Intent intent =new Intent(TaskActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
