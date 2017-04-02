package com.example.rashid.foodie.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rashid.foodie.R;
import com.example.rashid.foodie.Ui.FoodMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private TextView tvreg;
    private EditText suemail,supass;
    private Button btn_signup;
    private ProgressDialog progessdialog;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();

        progessdialog=new ProgressDialog(this);
        firebaseauth=FirebaseAuth.getInstance();

        //initialization the views


        //set onclicklistener to button and textview

        btn_signup.setOnClickListener(this);
        tvreg.setOnClickListener(this);
    }

    private void init() {
        tvreg=(TextView)findViewById(R.id.tv_reg);
        suemail=(EditText)findViewById(R.id.ed_emailsu);
        supass=(EditText)findViewById(R.id.ed_passu);
        btn_signup= (Button) findViewById(R.id.btn_signup);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_signup:
                register();
                break;
            case R.id.tv_reg:

                startActivity(new Intent(getBaseContext(),Signin.class));
                break;
            default:
                break;
        }

    }

    private void register() {
        String email=suemail.getText().toString().trim();
        String password=supass.getText().toString().trim();

        //check the field is empty or not
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email.",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password.",Toast.LENGTH_SHORT).show();
            return;
        }

        //firebase authentication

        progessdialog.setMessage("Registering user...");
        progessdialog.show();

        firebaseauth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    progessdialog.dismiss();

                    Toast.makeText(getBaseContext(),"Registarion is Successful.",Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getBaseContext(),Signin.class));
                }
                else {
                    Toast.makeText(getBaseContext(),"Registarion isn't Successful! Try again.",Toast.LENGTH_SHORT).show();
                }
                progessdialog.dismiss();

            }
        });

    }
}
