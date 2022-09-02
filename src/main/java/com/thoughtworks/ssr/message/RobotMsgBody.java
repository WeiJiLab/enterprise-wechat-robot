package com.thoughtworks.ssr.message;

import org.json.JSONObject;

/**
 * 机器人消息接口
 */
public interface RobotMsgBody {
    /**
     * 获取消息类型
     *
     * @return 消息类型
     */
    String getType();

    /**
     * 校验
     */
    void valid();

    /**
     * 构建 数据
     *
     * @return 数据
     */
    JSONObject buildBody();

    /**
     * 发送数据
     */
    void send(String key);
}

