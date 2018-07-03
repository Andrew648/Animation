package com.example.andrewlow.animation;

import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = findViewById(R.id.mess);
        final WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (wifi.isWifiEnabled()){
            t.setText("Wifi is on");
        }else{
            t.setText("Wifi is off");
            AlertDialog.Builder ts = new AlertDialog.Builder(this);
            ts.setMessage("Turn on wifi")
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            wifi.setWifiEnabled(true);
                        }
                    });

            AlertDialog ad = ts.create();
            ad.setTitle("Alert");
            ad.show();
        }
    }

    public void turnOn(){
        AlertDialog.Builder ts = new AlertDialog.Builder(this);
            ts.setMessage("Turn on wifi")
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog ad = ts.create();
            ad.setTitle("Alert");
            ad.show();
    }
}
