package com.example.artistle.firebasedatabase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private EditText ETMeil;
    private EditText ETPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, ListTasks.class);
                    startActivity(intent);

                } else {
                    // User is signed out

                }

            }
        };
        ETMeil = (EditText)findViewById(R.id.et_email);
        ETPassword = (EditText)findViewById(R.id.et_password);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_sign_in){
            Toast.makeText(MainActivity.this, "заебись", Toast.LENGTH_SHORT).show();
            SignIn(ETMeil.getText().toString(), ETPassword.getText().toString());
        }
        if(v.getId() == R.id.btn_registration){
            Registration(ETMeil.getText().toString(), ETPassword.getText().toString());
        }
    }

    public void SignIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, ListTasks.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "заебись", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "хуёво", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void Registration(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(MainActivity.this, ListTasks.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "регистрация хуёвая", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void onSignIn(View view){
        Toast.makeText(MainActivity.this, "заебись", Toast.LENGTH_SHORT).show();
        SignIn(ETMeil.getText().toString(), ETPassword.getText().toString());
    }
    public void onRegistration(View view){
        Registration(ETMeil.getText().toString(), ETPassword.getText().toString());

    }
}

