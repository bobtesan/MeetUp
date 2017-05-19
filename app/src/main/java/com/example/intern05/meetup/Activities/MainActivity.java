package com.example.intern05.meetup.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intern05.meetup.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button registerB;
    private Button loginB;

    private TextView email;
    private TextView password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        pb = (ProgressBar) findViewById(R.id.progBar);
        pb.setVisibility(View.GONE);

        loginB = (Button) findViewById(R.id.loginB);
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                pb.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            pb.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this,"Logged in",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(MainActivity.this, EventActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Connection error", Toast.LENGTH_SHORT).show();
                            pb.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        registerB = (Button) findViewById(R.id.registerB);
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }
}
