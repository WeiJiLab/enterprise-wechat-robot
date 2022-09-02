package com.thoughtworks.ssr.request;

public class EventImageMessageRequest extends EventMessageRequest {
    private String base64;
    private String md5;

    public EventImageMessageRequest() {
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
