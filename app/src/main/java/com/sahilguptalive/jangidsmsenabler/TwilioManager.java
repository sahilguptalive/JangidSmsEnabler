package com.sahilguptalive.jangidsmsenabler;

import android.content.Context;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by sahilgupta on 19-03-2017.
 */

class TwilioManager {
    private final static String ACCOUNT_SID = "ACa16b1056de3a21c42777041783f9c661";
    private final static String AUTH_TOKEN = "c02cc8760979b477f38ff3b5c46a0c22";

    public void sendSmsForBooked(Context mContext
            , String displayOriginatingAddress
            , final AddressInfo parse) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();

                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody body = RequestBody.create(mediaType, "To=%2B919540665161&From=%2B18609464152&MessagingServiceSid=MG03f8d7c0824d91c0de19633e03c6e4fb&Body=" + "You ride booked from:" + parse.getSourceAdd() + " to " + parse.getDestAdd() + " for " + parse.getNumberOfSeats() + " seat(s).");
                Request request = new Request.Builder()
                        .url("https://api.twilio.com/2010-04-01/Accounts/ACa16b1056de3a21c42777041783f9c661/Messages.json")
                        .post(body)
                        .addHeader("aca16b1056de3a21c42777041783f9c661", "c02cc8760979b477f38ff3b5c46a0c22")
                        .addHeader("authorization", "Basic QUNhMTZiMTA1NmRlM2EyMWM0Mjc3NzA0MTc4M2Y5YzY2MTpjMDJjYzg3NjA5NzliNDc3ZjM4ZmYzYjVjNDZhMGMyMg==")
                        .addHeader("cache-control", "no-cache")
                        .addHeader("postman-token", "b01eee7d-f42c-8a5a-4d29-fa6f75cce06b")
                        .addHeader("content-type", "application/x-www-form-urlencoded")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


//    public void sendSmsForBooked(Context mContext
//            , String displayOriginatingAddress
//            , final AddressInfo parse) {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                OkHttpClient client = new OkHttpClient();
//
//                MediaType mediaType = MediaType.parse("application/x--form-urlencoded");
//                RequestBody body = RequestBody.create(mediaType, "To=%2B919540665161&From=%2B18609464152&MessagingServiceSid=MG03f8d7c0824d91c0de19633e03c6e4fb&Body=" + "You ride booked from:" + parse.getSource() + " to " + parse.getDestinition() + " for " + parse.getNumberOfSeats() + " seat(s).");
//                Request request = new Request.Builder()
//                        .url("https://api.twilio.com/2010-04-01/Accounts/ACa16b1056de3a21c42777041783f9c661/Messages.json")
//                        .post(body)
//                        .build();
//
//                try {
//                    Response response = client.newCall(request).execute();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
}
