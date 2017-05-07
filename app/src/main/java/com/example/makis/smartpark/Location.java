package com.example.makis.smartpark;

/**
 * Created by makis on 7/5/2017.
 */

public class Location {
    Double Lat;
    Double Log;

    public Location() {
        Lat = 0.0;
        Log = 0.0;
    }

    public Location(Double LatArg, Double LogArg) {
        Lat = LatArg;
        Log = LogArg;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLog() {
        return Log;
    }

    public void setLog(Double log) {
        Log = log;
    }
}
