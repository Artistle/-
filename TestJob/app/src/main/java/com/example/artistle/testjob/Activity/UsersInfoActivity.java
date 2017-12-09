package com.example.artistle.testjob.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.artistle.testjob.Adapter.InfoAdapter;
import com.example.artistle.testjob.App;
import com.example.artistle.testjob.Model.InfoModel;
import com.example.artistle.testjob.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UsersInfoActivity extends AppCompatActivity {
    private List<InfoModel> info;
    private RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_info_activity);

        info = new ArrayList<InfoModel>();

        rv = (RecyclerView) findViewById(R.id.info_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        InfoAdapter adapter = new InfoAdapter(info);
        rv.setAdapter(adapter);


        App.getInfoUsers().getInfo(1).enqueue(new Callback<List<InfoModel>>() {
        @Override
        public void onResponse(Call<List<InfoModel>> call, Response<List<InfoModel>> response) {
            info.addAll(response.body());
            rv.getAdapter().notifyDataSetChanged();
        }

        @Override
        public void onFailure(Call<List<InfoModel>> call, Throwable t) {

        }
    });

    }
}
