package com.sahilguptalive.jangidsmsenabler;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by sahilgupta on 19-03-2017.
 */

class AddressInfo {

    LatLng source;
    LatLng destinition;
    int numberOfSeats;
    String sourceAdd;
    String destAdd;

    public AddressInfo(LatLng source, LatLng destinition, int numberOfSeats) {
        this.source = source;
        this.destinition = destinition;
        this.numberOfSeats = numberOfSeats;
    }

    public AddressInfo(int numberOfSeats, String sourceAdd, String destAdd) {
        this.numberOfSeats = numberOfSeats;
        this.sourceAdd = sourceAdd;
        this.destAdd = destAdd;
    }

    public LatLng getSource() {
        return source;
    }

    public LatLng getDestinition() {
        return destinition;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getSourceAdd() {
        return sourceAdd;
    }


    public void setSourceAdd(String sourceAdd) {
        this.sourceAdd = sourceAdd;
    }

    public String getDestAdd() {
        return destAdd;
    }

    public void setDestAdd(String destAdd) {
        this.destAdd = destAdd;
    }
}
