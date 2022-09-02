package com.thoughtworks.ssr;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.google.gson.Gson;
import com.thoughtworks.ssr.request.EventImageMessageRequest;
import com.thoughtworks.ssr.request.EventMarkdownMessageRequest;
import com.thoughtworks.ssr.request.EventTextMessageRequest;
import org.json.JSONObject;

import java.util.Map;
import java.util.Objects;

public class WeChatTimeRobotHandler implements RequestHandler<Map<String, Object>, String> {
    private final static Gson gson = new Gson();

    @Override
    public String handleRequest(Map<String, Object> event, Context context) {
        LambdaLogger logger = context.getLogger();
        String jsonString = new JSONObject(event).toString();
        String msgType = event.get("msgtype").toString();
        logger.log("处理类型：" + msgType);
        handleEventMessage(msgType, jsonString);
        return "200 OK";
    }

    private void handleEventMessage(String msgType, String event) {
        if (msgType.isBlank()) {
            return;
        }
        if (Objects.equals("text", msgType)) {
            var request = gson.fromJson(event, EventTextMessageRequest.class);

            RobotMessages
                    .text(request.getContent())
                    .mentionedList(request.getMentionedList())
                    .mentionedMobileList(request.getMentionedList())
                    .send(request.getKey());
        } else if (Objects.equals("markdown", msgType)) {
            var request = gson.fromJson(event, EventMarkdownMessageRequest.class);

            RobotMessages
                    .markdown(request.getContent())
                    .send(request.getKey());

        } else if (Objects.equals("image", msgType)) {
            var request = gson.fromJson(event, EventImageMessageRequest.class);

            RobotMessages
                    .img(request.getBase64(), request.getMd5())
                    .send(request.getKey());
        }

    }
}