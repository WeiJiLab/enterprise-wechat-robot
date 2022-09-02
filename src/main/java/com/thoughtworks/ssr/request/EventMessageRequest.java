package com.thoughtworks.ssr.request;

public class EventMessageRequest {
    private String msgtype;
    private String key;

    public EventMessageRequest() {
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
