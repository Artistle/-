package com.example.artistle.firebasedatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListTasks extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();

    //FirebaseListAdapter mAdapter;

    private EditText ET_new_task;
    private Button Btn_new_task;

    //ListView ListUserTasks;

    private  static class TaskViewHolder extends RecyclerView.ViewHolder{

        TextView mTitleTask;
        Button mDel;

        public TaskViewHolder(View itemView) {
            super(itemView);
            mTitleTask = (TextView) itemView.findViewById(R.id.tv_title_task);
            mDel = (Button) itemView.findViewById(R.id.btn_del);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tasks);

        //ListUserTasks = (ListView) findViewById(R.id.discr_for_task);

        myRef = FirebaseDatabase.getInstance().getReference();

        /*mAdapter = new FirebaseListAdapter <String>(this,
                String.class,
                android.R.layout.simple_list_item_1,myRef.child(user.getUid()).child("Tasks")) {
            @Override
            protected void populateView(View v, String s, int position) {
                TextView text = (TextView) v.findViewById(android.R.id.text1);
                text.setText(s);
            }
        };
        ListUserTasks.setAdapter(mAdapter);
        ListUserTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    myRef.child(user.getUid()).child("Tasks").child("" + position).removeValue();
                    DatabaseReference itemRef = mAdapter.getRef(position);
                    itemRef.removeValue();
            }
        });*/

        //Добавление данных в firebase database
        Btn_new_task = (Button) findViewById(R.id.btn_add);
        ET_new_task = (EditText) findViewById(R.id.et_new_tasks);

        Btn_new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child(
                        user.getUid()).child("Tasks").
                        push().
                        setValue(ET_new_task.getText().toString());
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_list_tasks);

        FirebaseRecyclerAdapter<String,TaskViewHolder> adapter;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new FirebaseRecyclerAdapter<String, TaskViewHolder>(
                String.class,
                R.layout.task_layout,
                TaskViewHolder.class,
                myRef.child(user.getUid()).child("Tasks")
        ) {

            @Override
            public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
                //del
            }

            @Override
            protected void onBindViewHolder(TaskViewHolder holder, int position, String model) {
                //del
            }

            @Override
            protected void populateViewHolder(TaskViewHolder viewHolder, String title,final int position) {
                viewHolder.mTitleTask.setText(title);
                viewHolder.mDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseReference itemRef = getRef(position);
                        itemRef.removeValue();
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
    }
}
