package com.androidexample.broadcastreceiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BroadcastNewSms extends Activity {


    TextView txt;
    IncomingSms incomingSms = new IncomingSms();
    public static BroadcastNewSms ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.androidexample_broadcast_newsms);

        //incomingSms = new IncomingSms();


        txt = (TextView) findViewById(R.id.txt);

        Button btnActivate = (Button) findViewById(R.id.btnActivate);

        btnActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BroadcastNewSms.this.registerReceiver(incomingSms, new IntentFilter("android.intent.action.MAIN"));
                //android.intent.action.MAIN
                //android.intent.action.TIME_TICK
            }
        });


        Button btnDeactivate = (Button) findViewById(R.id.btnDeactivate);
        btnDeactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadcastNewSms.this.unregisterReceiver(incomingSms);
            }
        });
        ins = this;
    }


    @Override
    protected void onStart() {
        super.onStart();

    }
}
