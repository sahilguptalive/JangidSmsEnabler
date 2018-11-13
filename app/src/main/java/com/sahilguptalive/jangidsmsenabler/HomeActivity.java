package com.sahilguptalive.jangidsmsenabler;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    private IncomingSmsReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        receiver = new IncomingSmsReceiver();
        this.registerReceiver(receiver
                ,new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(receiver);
    }
}
