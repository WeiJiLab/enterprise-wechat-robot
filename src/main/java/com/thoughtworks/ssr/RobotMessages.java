package com.thoughtworks.ssr;

import com.thoughtworks.ssr.message.RobotImgArticleMsg;
import com.thoughtworks.ssr.message.RobotImgMsg;
import com.thoughtworks.ssr.message.RobotMarkdownMsg;
import com.thoughtworks.ssr.message.RobotTextMsg;

import java.util.List;

/**
 * 机器人消息构造工具
 */
public abstract class RobotMessages {
    /**
     * 纯文本
     *
     * @param content
     * 		文本
     *
     * @return RobotTextMsg
     */
    public static RobotTextMsg text(String content) {
        return new RobotTextMsg().content(content);
    }

    /**
     * 图片
     *
     * @param base64
     * 		图片base64
     * @param md5
     * 		图片md5
     *
     * @return RobotImgMsg
     */
    public static RobotImgMsg img(String base64, String md5) {
        return new RobotImgMsg().base64(base64).md5(md5);
    }

    /**
     * 图文消息
     *
     * @param articles
     * 		列表
     *
     * @return RobotImgArticleMsg
     */
    public static RobotImgArticleMsg imgArticle(List<RobotImgArticleMsg.Article> articles) {
        return new RobotImgArticleMsg().articles(articles);
    }

    /**
     * markdown 格式
     *
     * @param content
     * 		文本
     *
     * @return RobotMarkdownMsg
     */
    public static RobotMarkdownMsg markdown(String content) {
        return new RobotMarkdownMsg().content(content);
    }
}
