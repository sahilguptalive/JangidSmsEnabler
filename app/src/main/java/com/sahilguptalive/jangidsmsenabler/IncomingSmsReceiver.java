package com.sahilguptalive.jangidsmsenabler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

/**
 * Created by sahilgupta on 19-03-2017.
 */

public class IncomingSmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null
                || intent.getExtras() == null
                || !intent.getExtras().containsKey("pdus")) {
            return;
        }
        Object[] pdus = (Object[]) intent.getExtras().get("pdus");
        for (int i = 0; i < pdus.length; i++) {
            SmsMessage smsMessage = SmsMessage.createFromPdu(((byte[]) pdus[i]));
            String sender = smsMessage.getDisplayOriginatingAddress();
            if (sender.equals("+919540665161")) {
                new SmsClassifyParseClass(context).parse(smsMessage);
            }
        }
    }
}
