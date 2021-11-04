package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText email;
    EditText pass;
    Button btn1;
    Button signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hvhjgfjhfvjdc");

        email=(EditText) findViewById(R.id.editTextTextEmailAddress);
        pass=(EditText) findViewById(R.id.editTextTextPassword);
        btn1=(Button) findViewById(R.id.Signup);
        mAuth=FirebaseAuth.getInstance();

        onClick();

    }

    void onClick()
    {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg();
            }
        });

    }

     void reg(){
       String emailTxt=email.getText().toString();
        String passTxt=pass.getText().toString();

        if(!emailTxt.isEmpty()&&!passTxt.isEmpty()) {

            mAuth.createUserWithEmailAndPassword(emailTxt, passTxt).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        System.out.println(task);
//                    Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent send = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(send);

//                    updateUI(user);
                    } else {
                        System.out.println(task);
                        Toast.makeText(MainActivity.this, task.getException().getMessage(),
                                Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

        else {
            Toast.makeText(MainActivity.this, "Email or password is missing",
                    Toast.LENGTH_SHORT).show();
        }
        }


        void signin()
        {
            String emailTxt=email.getText().toString();
            String passTxt=pass.getText().toString();

        }








}