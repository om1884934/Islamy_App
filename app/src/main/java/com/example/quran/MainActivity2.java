package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private BroadcastReceiver broadcastReceiver;
    private SharedPreferences Sp;
    private TextView Sora;
    private EditText SoraNum;
    private Button button4;
    private String soraStr,sora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        broadcastReceiver = new NetworkChangeReceiver();
        registerNetworkBroadcastReceiver();

        Sora = findViewById(R.id.Sora);
        button4 = findViewById(R.id.button4);
        SoraNum = findViewById(R.id.SoraNum);

        Sp = getSharedPreferences("SoraInfo", Context.MODE_PRIVATE);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soraStr = SoraNum.getText().toString();
                SharedPreferences.Editor editor = Sp.edit();
                editor.putString("sora",soraStr);
                editor.commit();
                Intent i = new Intent(MainActivity2.this,MainActivity2.class);
                startActivity(i);
            }
        });

        SharedPreferences Sp = getApplicationContext().getSharedPreferences("SoraInfo",Context.MODE_PRIVATE);
        sora = Sp.getString("sora","");
        Sora.setText(sora);


        // Set background image
        getWindow().setBackgroundDrawableResource(R.drawable.background_image);

        // Button 1 - Go to Activity 1 and trigger notification
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start NotificationService to show the notification
                Intent serviceIntent = new Intent(MainActivity2.this, NotificationService.class);
                startService(serviceIntent);
                // Navigate to Swr_Activity
                Intent intent = new Intent(MainActivity2.this, Swr_Activity.class);
                startActivity(intent);
            }
        });
        // Button 2 - Go to Activity 2
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Duaa_Activity.class);
                startActivity(intent);
            }
        });


    Button button3 = findViewById(R.id.button3);
     button3.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        Intent intent = new Intent(MainActivity2.this, SongActivity.class);
        startActivity(intent);
    }
    });
}
    private void registerNetworkBroadcastReceiver() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
    protected void unregisterNetwork(){
        try {
            unregisterReceiver(broadcastReceiver);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    protected void onDestroy(){
        super.onDestroy();
        unregisterNetwork();
    }
}
