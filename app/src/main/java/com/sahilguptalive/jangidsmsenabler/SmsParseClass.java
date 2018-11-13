package com.sahilguptalive.jangidsmsenabler;

import android.content.Context;
import android.telephony.SmsMessage;

/**
 * Created by sahilgupta on 19-03-2017.
 */

abstract class SmsParseClass {

    protected final Context mContext;

    public SmsParseClass(Context context) {
        mContext = context;
    }

    public abstract void parse(SmsMessage smsMessage);
}
