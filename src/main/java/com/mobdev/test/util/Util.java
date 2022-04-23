package com.mobdev.test.util;

public class Util {
    public static Integer getLocationIdByUrl(String urlLocation){
        String[] splitter = urlLocation.split("/");
        return Integer.parseInt(splitter[splitter.length-1]);
    }
}
