package com.example.designer2.recyclerview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.widget.Toast;



import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerviewAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonPlaceHolder service = RetrofitConnection.getRetrofitInstance().create(JsonPlaceHolder.class);

        retrofit2.Call<List<People>> call = service.getAllPeople();
        call.enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(retrofit2.Call<List<People>> call, Response<List<People>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());

            }

            @Override
            public void onFailure(retrofit2.Call<List<People>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,"Something Wrong",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void generateDataList(List<People> peopleList){
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RecyclerviewAdapter(this,peopleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}



