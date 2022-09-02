package com.thoughtworks.ssr.message;

import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

/**
 * Markdown 消息
 */
public class RobotMarkdownMsg extends AbstractRobotMsgBody<RobotMarkdownMsg> {

    private static final long serialVersionUID = -5537849822091493142L;

    private static final int MAX_LENGTH = 4096;

    /**
     * markdown 内容
     */
    private String content;

    public RobotMarkdownMsg() {
        super(MessageType.MARKDOWN.name().toLowerCase());
    }

    public String getContent() {
        return content;
    }

    public RobotMarkdownMsg content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RobotMarkdownMsg.class.getSimpleName() + "[", "]")
                .add("content='" + content + "'")
                .toString();
    }

    @Override
    public void valid() {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("content empty");
        }

        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        if (bytes.length > MAX_LENGTH) {
            System.err.println("content too long:" + bytes.length);
        }

    }
}
