package com.thoughtworks.ssr.message;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * 图文类型消息
 */
public class RobotImgArticleMsg extends AbstractRobotMsgBody<RobotImgArticleMsg> {
    private static final long serialVersionUID = -8809868668048069376L;

    private List<Article> articles;

    public RobotImgArticleMsg() {
        super(MessageType.NEWS.name().toLowerCase());
    }

    public RobotImgArticleMsg articles(List<Article> articles) {
        this.articles = articles;
        return this;
    }

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RobotImgArticleMsg.class.getSimpleName() + "[", "]")
                .add("articles=" + articles)
                .toString();
    }

    @Override
    public void valid() {
        if (articles == null || articles.isEmpty() || articles.size() > 8) {
            throw new IllegalArgumentException("articles illegal");
        }
        articles.forEach(article -> {
            var title = article.title;
            if (title == null || title.isEmpty()) {
                throw new IllegalArgumentException("title illegal");
            }

            var url = article.url;
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("url illegal");
            }
        });
    }

    public static class Article implements Serializable {
        private static final long serialVersionUID = -8312771647503114833L;

        /**
         * 标题
         */
        private String title;
        /**
         * 描述
         */
        private String description;
        /**
         * 点击后跳转的链接
         */
        private String url;
        /**
         * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图 1068*455，小图150*150。
         */
        private String picUrl;

        public Article() {
        }

        public Article(String title, String description, String url, String picUrl) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.picUrl = picUrl;
        }

        public String getTitle() {
            return title;
        }

        public Article setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public Article setDescription(String description) {
            this.description = description;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Article setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public Article setPicUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Article.class.getSimpleName() + "[", "]")
                    .add("title='" + title + "'")
                    .add("description='" + description + "'")
                    .add("url='" + url + "'")
                    .add("picUrl='" + picUrl + "'")
                    .toString();
        }
    }
}
