package ru.glassexpress.modules;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParser {

    Map<String, String> requestMap;

    String req;
    public RequestParser() {
        //this.req=req;
        this.requestMap = new HashMap<String, String>();
    }

    public void parseRequest(String req){
        req=req.replace("?","");
        String[]requestQuery=req.split("&");
        String[] queryElement;
        for (int i = 0; i < requestQuery.length; i++) {
            queryElement =requestQuery[i].split("=");
            requestMap.put(queryElement[0],queryElement[1]);
        }

    }

    public int getIntValue(String key){

        return Integer.parseInt(requestMap.get(key));
    }

    public String getStringValue(String key){
        String decoded=requestMap.get(key);

        return decoded;
    }

    public  float getFloatValue(String key){
        return Float.parseFloat(requestMap.get(key));
    }
}
