package com.sahilguptalive.jangidsmsenabler;

import android.content.Context;
import android.telephony.SmsMessage;

/**
 * Created by sahilgupta on 19-03-2017.
 */

class SmsClassifyParseClass extends SmsParseClass {


    public SmsClassifyParseClass(Context context) {
        super(context);
    }

    public void parse(SmsMessage smsMessage) {
        String body = smsMessage.getMessageBody();
        if (body != null) {
            if (body.toLowerCase().startsWith("book ")) {
                //it is a booking type
                new BookingSmsParseClass(mContext).parse(smsMessage);
            } else {
                //incorrect message
            }
        }
    }
}
