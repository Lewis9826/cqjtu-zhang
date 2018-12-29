package edu.cqjtu.zhang;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;

/**
 * 对页面内容的封装
 * @author Lewis
 *
 */
public class Page {

    private byte[] content;
    private String url;
    private Document doc;
    private String html;
    private String contentType;
    private String charset;


    public Page(byte[] content,String url,String contentType){
        this.content=content;
        this.contentType=contentType;
        this.url=url;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDoc(Document doc) {
        this.doc =doc;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * 返回网页的源码字符串
     * @return 网页的源码字符串
     */
    public String getHtml(){
        if(html!=null){
            return html;
        }
        if(content == null){
            return null;
        }
        if(charset==null){
            charset = CharsetDetector.guessEncoding(content);
        }
        try {
            this.html = new String(content,charset);
            return html;
        }catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
            return null;
        }

    }

    /**
     * 得到文档
     * @return
     */
    public Document getDoc() {
        if(doc !=null){
            return doc;
        }
        try {
            this.doc = Jsoup.parse(getHtml(),url);
            return doc;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
