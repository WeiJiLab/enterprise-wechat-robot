package com.thoughtworks.ssr.request;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EventTextMessageRequest extends EventMessageRequest {
    private String content;

    @SerializedName("mentioned_list")
    private List<String> mentionedList;

    @SerializedName("mentioned_mobile_list")
    private List<String> mentionedMobileList;

    public EventTextMessageRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getMentionedList() {
        return mentionedList;
    }

    public void setMentionedList(List<String> mentionedList) {
        this.mentionedList = mentionedList;
    }

    public List<String> getMentionedMobileList() {
        return mentionedMobileList;
    }

    public void setMentionedMobileList(List<String> mentionedMobileList) {
        this.mentionedMobileList = mentionedMobileList;
    }

}
