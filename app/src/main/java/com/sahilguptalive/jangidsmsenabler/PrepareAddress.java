package com.sahilguptalive.jangidsmsenabler;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

/**
 * Created by sahil gupta on 19-03-2017.
 */

class PrepareAddress {
    private final String mCurrentLocation;
    private final String mDestination;
    private int mNumberOfSeats;
    private final Context mContext;

    public PrepareAddress(Context context, String currentLocationDest, String destinationAddress, String numberOfSeats) {
        mContext = context;
        mCurrentLocation = currentLocationDest;
        mDestination = destinationAddress;
        try {
            mNumberOfSeats = Integer.parseInt(numberOfSeats);
        } catch (NumberFormatException nfe) {
            mNumberOfSeats = 1;
        }
    }

    public AddressInfo parse() {
        LatLng destinationLocation = getLocationFromAddress(mDestination);
        LatLng sourceLocation = Mnemonics.MnemonicsMap.get(mCurrentLocation.toUpperCase());
        //TODO: check if destinition and source
        return new AddressInfo(mNumberOfSeats, mCurrentLocation, mDestination);
    }

    public LatLng getLocationFromAddress(String strAddress) {

        Geocoder coder = new Geocoder(mContext);
        List<Address> address;
        LatLng p1 = null;

        try {
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }
            Address location = address.get(0);
            location.getLatitude();
            location.getLongitude();

            p1 = new LatLng(location.getLatitude() * 1E6,
                    location.getLongitude() * 1E6);

            return p1;
        } catch (IOException e) {
        }
        return null;
    }

}
