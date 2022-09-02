package com.thoughtworks.ssr.message;
import java.util.StringJoiner;

/**
 * 图片类型 消息
 */
public class RobotImgMsg extends AbstractRobotMsgBody<RobotImgMsg> {

    private static final long serialVersionUID = 226886523705169544L;

    /**
     * 图片 base64
     */
    private String base64;
    /**
     * 图片 md5
     */
    private String md5;

    public RobotImgMsg() {
        super(MessageType.IMAGE.name().toLowerCase());
    }

    public String getBase64() {
        return base64;
    }

    public RobotImgMsg base64(String base64) {
        this.base64 = base64;
        return this;
    }

    public String getMd5() {
        return md5;
    }

    public RobotImgMsg md5(String md5) {
        this.md5 = md5;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RobotImgMsg.class.getSimpleName() + "[", "]")
                .add("base64='" + base64 + "'")
                .add("md5='" + md5 + "'")
                .toString();
    }

    @Override
    public void valid() {
        if (base64 == null || base64.isEmpty()) {
            throw new IllegalArgumentException("base64 empty");
        }

        if (md5 == null || md5.isEmpty()) {
            throw new IllegalArgumentException("md5 empty");
        }
    }
}
