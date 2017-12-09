package com.example.artistle.message_chat_for_loading;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.doctoror.particlesdrawable.ParticlesDrawable;
import com.example.artistle.message_chat_for_loading.adapter.Message_adapter;
import com.example.artistle.message_chat_for_loading.dto.message_dto;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView mMessagelistView;
    private EditText mMessageEditText;
    private ImageButton mButtonMessageSend;
    private Message_adapter adapter;
    private RecyclerView recyclerView;


    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;
    private final ParticlesDrawable mDrawable = new ParticlesDrawable();

    private message_dto dto;
    List<message_dto> messages;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        messages = new ArrayList<>();

        //mMessagelistView = (ListView)findViewById(R.id.listView);
        mMessageEditText = (EditText)findViewById(R.id.edit_text);
        mButtonMessageSend = (ImageButton)findViewById(R.id.imageButton);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("message");
        recyclerView.setAdapter(adapter);

        if(childEventListener == null){
            childEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    message_dto message = dataSnapshot.getValue(message_dto.class);
                    //messages.add(dataSnapshot.getValue(message_dto.class));
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
            databaseReference.addChildEventListener(childEventListener);
        }
        //List<message_dto> messages = new ArrayList<>();
        adapter = new Message_adapter(messages);

        //mMessagelistView.setAdapter(adapter);
        recyclerView.setAdapter(adapter);
        mButtonMessageSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String m = mMessageEditText.getText().toString();
                message_dto mess = new message_dto(mMessageEditText.getText().toString());
                databaseReference.push().setValue(mess);
                mMessageEditText.setText("");
            }
        });
       mMessageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().length() > 0){
                    mButtonMessageSend.setEnabled(true);
                }else{
                    mButtonMessageSend.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /*public List<message_dto> create(){
        List<message_dto> messages = new ArrayList<>();
        messages.add(new message_dto(mMessageEditText.getText().toString()));
        messages.add(new message_dto("fffff"));

        return messages;
    }*/

    @Override
   protected void onDestroy() {
        if(childEventListener != null){
            databaseReference.removeEventListener(childEventListener);
            childEventListener = null;
        }
        super.onDestroy();
    }
}
