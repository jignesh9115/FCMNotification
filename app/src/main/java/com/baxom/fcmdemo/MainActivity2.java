package com.baxom.fcmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences preferences = getSharedPreferences("pref", MODE_PRIVATE);

        tv = findViewById(R.id.textView);

        if (getIntent() != null) {
            Log.d(TAG, "preferences : " + preferences.getString("messageBody", ""));
            Log.d(TAG, "messageBody: " + getIntent().getStringExtra("messageBody"));
            tv.setText(getIntent().getStringExtra("messageBody"));
            Toast.makeText(this, "messageBody...>" + getIntent().getStringExtra("messageBody"), Toast.LENGTH_LONG).show();
        }

    }
}