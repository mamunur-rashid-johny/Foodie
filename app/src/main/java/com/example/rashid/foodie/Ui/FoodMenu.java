package com.example.rashid.foodie.Ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rashid.foodie.Adapter.FoodAdapter;
import com.example.rashid.foodie.Feedback.Feedback;
import com.example.rashid.foodie.Login.Signin;
import com.example.rashid.foodie.Model.Food;
import com.example.rashid.foodie.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class FoodMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodmenu);

        firebaseAuth=FirebaseAuth.getInstance();

        recyclerView=(RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodAdapter=new FoodAdapter(Food.getItem(),this);
        recyclerView.setAdapter(foodAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId()){
             case R.id.op_sout:
                 firebaseAuth.signOut();
                 finish();
                 startActivity(new Intent(getBaseContext(), Signin.class));
                 break;
             case R.id.op_feed:
                 startActivity(new Intent(getBaseContext(), Feedback.class));
                 break;
             default:
                 break;

         }
        return super.onOptionsItemSelected(item);
    }
}
