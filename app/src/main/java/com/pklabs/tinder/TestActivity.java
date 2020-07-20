package com.pklabs.tinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    public void secondButton(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("userSex"), Toast.LENGTH_SHORT).show();
        Log.i("userSex",intent.getStringExtra("userSex"));
    }
}
