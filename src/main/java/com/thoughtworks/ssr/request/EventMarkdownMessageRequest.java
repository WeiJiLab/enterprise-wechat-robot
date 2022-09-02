package com.thoughtworks.ssr.request;

public class EventMarkdownMessageRequest extends EventMessageRequest {
    private String content;


    public EventMarkdownMessageRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
