package com.example.wassan.sudhaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    private static final int tl = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_submit = (Button) findViewById(R.id.submit);
        button_submit.setOnClickListener(this);
    }
    /*@Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"Paused",tl).show();
        Log.i("sudhaar","application paused");
    }*/
    /*@Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"Stopped",tl).show();
        Log.i("sudhaar","application stopped");
    }*/
    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Started",tl).show();
        Log.i("sudhaar","application started");
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"Welcome back",tl).show();
        Log.i("sudhaar","Resumed");
    }

    /*@Override
    protected void onSaveInstanceState(Bundle OutState) {
        super.onResume();
        Toast.makeText(this,"Saved instance",tl).show();
        Log.i("sudhaar","application saved instance");
    }*/
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.submit:
                Intent intent = new Intent(this,CaseActivity.class);
                intent.setAction(Intent.ACTION_SEND);
                startActivity(intent);
        }
    }
}
