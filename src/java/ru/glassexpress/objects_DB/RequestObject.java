package ru.glassexpress.objects_DB;

abstract class RequestObject {
    protected String reqType;
    protected String reqObj;

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public String getObjType() {
        return reqObj;
    }

    public void setObjType(String objType) {
        this.reqObj = objType;
    }
}
