package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button btn, signUpButton;
    CheckBox rememberMeCheckBox;
    ImageView lockIcon;
    TextView forgotPasswordTextView;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.emailbox);
        password = findViewById(R.id.passwordbox);
        btn = findViewById(R.id.mybtn);
        signUpButton = findViewById(R.id.signUpButton);
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);
        lockIcon = findViewById(R.id.lockIcon);
        forgotPasswordTextView = findViewById(R.id.forgotPasswordTextView);

        firebaseAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your login logic here if needed
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to SignupActivity after a successful signup
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        forgotPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPasswordClicked();
            }
        });
    }

    public void signUpClicked() {
        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString().trim(),
                password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void forgotPasswordClicked() {
        Toast.makeText(MainActivity.this, "Forgot Password What Can I DO! Recognise or Sleep:)", Toast.LENGTH_LONG).show();
    }
}
