package com.thoughtworks.ssr.message;

import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class AbstractRobotMsgBody<E extends AbstractRobotMsgBody<E>> implements Serializable, RobotMsgBody {

    private static final long serialVersionUID = -1505247293923991188L;

    /**
     * 发送消息地址
     */
    protected static final String SEND_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/webhook/send";

    private String type;

    public AbstractRobotMsgBody(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public JSONObject buildBody() {
        valid();

        var jsonBody = new JSONObject();
        jsonBody.put("msgtype", getType());
        var message = new JSONObject(this);
        message.remove("type");
        jsonBody.put(getType(), message);
        return jsonBody;
    }

    @Override
    public void send(String key) {

        var jsonBody = buildBody();
        try {

            var request = HttpRequest.newBuilder()
                    .uri(URI.create(SEND_MESSAGE_URL + "?key=" + key))
                    .setHeader("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody.toString()))
                    .build();

            var response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public enum MessageType {
        /**
         * 文本
         */
        TEXT,
        /**
         * MARKDOWN
         */
        MARKDOWN,
        /**
         * 图片
         */
        IMAGE,
        /**
         * 图文
         */
        NEWS
    }
}
