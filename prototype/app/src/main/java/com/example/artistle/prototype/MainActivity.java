package com.example.artistle.prototype;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.artistle.prototype.adapter.RVadapter;
import com.example.artistle.prototype.drawDTO.itemDto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int c = R.color.white;

    FloatingActionButton FAB;
    private List<itemDto> item;
    RVadapter adapter;
    RecyclerView rv;
    private RecyclerView.LayoutManager mLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AppBar();
        Fab();
        mLayout = new LinearLayoutManager(this);
        rv.setLayoutManager(mLayout);

        rv = (RecyclerView)findViewById(R.id.recyclerView);
        adapter = new RVadapter(item);
        rv.setAdapter(adapter);
        initializa();
    }

    private void Fab() {
    }

  /*  @SuppressLint("ResourceAsColor")
    private void AppBar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        appBar = (AppBarLayout)findViewById(R.id.appbar);
        toolbar.setTitle("Elite Tattoo");
        toolbar.setTitleTextColor(c);
    }*/
    private void initializa(){
        item = new ArrayList<>();
        item.add(new itemDto("r","r",1));
        item.add(new itemDto("r","r",1));
        item.add(new itemDto("r","r",1));
        item.add(new itemDto("r","r",1));
    }

}
