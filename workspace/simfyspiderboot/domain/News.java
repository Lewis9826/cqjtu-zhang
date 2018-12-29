package edu.cqjtu.zhang.simfyspiderboot.domain;

import javax.persistence.*;

/**
 * @author Lewis
 */
@Table(name = "ss_name")
@Entity
public class News {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsId;
    private String title;
    private String url;
    @Column(length = 102400)
    private String content;
    @Column(length = 10240)
    private String summary;

    public int getNewsId() { return newsId; }

    public void setNewsId(int newsId) { this.newsId = newsId; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    //alt+insert

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
