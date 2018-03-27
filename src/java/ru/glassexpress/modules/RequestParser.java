package ru.glassexpress.modules;

import java.util.Date;
import java.util.HashMap;
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
    public Date getDateValue(String key){
        Date date = new Date();
        date.setTime(Long.parseLong(requestMap.get(key)));
        return date;
    }

    public long getLongValue(String key){

        return Long.parseLong(requestMap.get(key));
    }

    public String getStringValue(String key){
        String decoded=requestMap.get(key);

        return decoded;
    }

    public  float getFloatValue(String key){
        return Float.parseFloat(requestMap.get(key));
    }
}
