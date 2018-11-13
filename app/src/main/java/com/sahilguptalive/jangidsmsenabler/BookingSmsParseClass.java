package com.sahilguptalive.jangidsmsenabler;

import android.content.Context;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by sahilgupta on 19-03-2017.
 */

class BookingSmsParseClass extends SmsParseClass {

    private static final char SPACE = ' ';

    public BookingSmsParseClass(Context mContext) {
        super(mContext);
    }

    @Override
    public void parse(SmsMessage smsMessage) {
        String messageBody = smsMessage.getMessageBody();
        messageBody = removeExtraSpaces(messageBody);
        String[] split = messageBody.split(" ", 4);
        String numberOfSeats = split[1];
        String currentLocationDest = split[2];
        String destinationAddress = split[3];
        PrepareAddress prepareAddress
                = new PrepareAddress(mContext,
                currentLocationDest, destinationAddress, numberOfSeats);
        String displayOriginatingAddress = smsMessage.getDisplayOriginatingAddress();
        AddressInfo addressInfo = prepareAddress.parse();
        new TwilioManager()
                .sendSmsForBooked(mContext
                        , displayOriginatingAddress
                        , addressInfo);
        Log.i("tag", "hello");
    }

    private String removeExtraSpaces(String textShared) {
        char[] charArr = textShared.toCharArray();
        char[] charArrFinal = new char[charArr.length];
        char lastChar = '\n';
        int index = 0;
        for (char ch : charArr) {
            if (ch != SPACE || lastChar != SPACE) {
                charArrFinal[index++] = ch;
            }
            lastChar = ch;
        }
        boolean isSpaceInBeg = false;
        if (charArrFinal[0] == SPACE) {
            isSpaceInBeg = true;
        }
        boolean isSpaceInEnd = false;
        if (charArrFinal[index - 1] == SPACE) {
            isSpaceInEnd = true;
        }
        return String.valueOf(charArrFinal, isSpaceInBeg ? 1 : 0, index - (isSpaceInEnd ? 1 : 0) + (isSpaceInBeg ? 1 : 0));
    }
}
