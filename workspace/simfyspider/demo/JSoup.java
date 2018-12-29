package edu.cqjtu.zhang.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class JSoup {
    public static void main(String[] args) {
        try {
            //访问网页并将返回结果处理成java对象
            Document document = Jsoup.connect("https://juejin.im/").get();
            //从java对象中找出我们想要的元素
            Elements elements = document.select(".info-box .title");
            //查看元素
            for (Element e : elements) {
                System.out.println(e.text() + ":" + e.absUrl("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
