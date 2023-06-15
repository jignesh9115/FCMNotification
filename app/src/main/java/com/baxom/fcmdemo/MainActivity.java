package com.baxom.fcmdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);

        /*if (getIntent() != null) {
            Log.d(TAG, "messageBody: " + getIntent().getStringExtra("messageBody"));
            tv.setText(getIntent().getStringExtra("messageBody"));
            Toast.makeText(this, "messageBody...>" + getIntent().getStringExtra("messageBody"), Toast.LENGTH_LONG).show();
        }*/

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                        return;
                    }
                    // Get new FCM registration token
                    String token = task.getResult();
                    // Log and toast
                    //String msg = getString(R.string.msg_token_fmt, token);
                    Log.d(TAG, "token : " + token);
                });
    }
}