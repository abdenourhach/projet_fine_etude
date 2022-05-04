package com.example.user__admin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    TextView txt_signup;
    EditText login_email, login_password;
    TextView signIn_btn;
    FirebaseAuth auth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        auth = FirebaseAuth.getInstance();
        txt_signup = findViewById(R.id.txt_signup);
        signIn_btn = findViewById(R.id.signin_btn);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);




        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String email = login_email.getText().toString();
                String password = login_password.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    progressDialog.dismiss();
                    Toast.makeText(com.example.user__admin.login.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                } else if (!email.matches(emailPattern)) {
                    progressDialog.dismiss();
                    login_email.setError("Envalid Email");
                    Toast.makeText(com.example.user__admin.login.this, "Envalid Email", Toast.LENGTH_SHORT).show();
                }
                else if (password.length() < 6) {
                    progressDialog.dismiss();
                    login_password.setError("Envalid Password");
                    Toast.makeText(com.example.user__admin.login.this, "Please enter valid password", Toast.LENGTH_SHORT).show();
                }
                else {
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                startActivity(new Intent(com.example.user__admin.login.this, MainActivity.class));
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(com.example.user__admin.login.this, "Error in login", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            }
            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.user__admin.login.this, registre.class));
            }
        });
}

}