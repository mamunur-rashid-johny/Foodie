package com.example.rashid.foodie.Login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
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

public class Signin extends AppCompatActivity implements View.OnClickListener {
    private TextView tvnotreg;
    private EditText uemail,upass;
    private Button btn_signin;
    private ProgressDialog progessdialog;
    private FirebaseAuth firbaseauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        init();

        firbaseauth=FirebaseAuth.getInstance();
        if (firbaseauth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getBaseContext(), Menu.class));
        }
        progessdialog=new ProgressDialog(this);

        btn_signin.setOnClickListener(this);
        tvnotreg.setOnClickListener(this);
    }

    private void init() {
        tvnotreg=(TextView)findViewById(R.id.tv_notreg);
        uemail=(EditText)findViewById(R.id.ed_email);
        upass=(EditText)findViewById(R.id.ed_pass);
        btn_signin= (Button) findViewById(R.id.btn_sign);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_sign:
               userlogin();
                break;
            case R.id.tv_notreg:

                startActivity(new Intent(this,Signup.class));
        }

    }

    private void userlogin() {

        String email=uemail.getText().toString().trim();
        String password=upass.getText().toString().trim();

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

        progessdialog.setMessage("Login! Please wait...");
        progessdialog.show();

        firbaseauth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            progessdialog.dismiss();
                            finish();
                            startActivity(new Intent(getBaseContext(), FoodMenu.class));
                        }
                        else {
                            Toast.makeText(getBaseContext(),"Error! Try Again..",Toast.LENGTH_SHORT).show();

                        }
                        progessdialog.dismiss();

                    }
                });

    }
}
