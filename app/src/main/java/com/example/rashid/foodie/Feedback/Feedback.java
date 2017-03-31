package com.example.rashid.foodie.Feedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.rashid.foodie.Login.Signin;
import com.example.rashid.foodie.R;
import com.google.firebase.auth.FirebaseAuth;

public class Feedback extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_activity);

        firebaseAuth=FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.op_sout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(getBaseContext(), Signin.class));
                break;
            case R.id.op_feed:
                Toast.makeText(getBaseContext(),"Your are on FeedBack section",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
            return super.onOptionsItemSelected(item);
        }
}

