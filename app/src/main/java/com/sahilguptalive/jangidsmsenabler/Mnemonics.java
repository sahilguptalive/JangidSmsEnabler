package com.sahilguptalive.jangidsmsenabler;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Created by sahilgupta on 19-03-2017.
 */

public class Mnemonics {


    public static final HashMap<String, LatLng> MnemonicsMap = new HashMap<>();

    static {
        MnemonicsMap.put("IFC", new LatLng(28.472165, 77.0703233));
    }


}
