package edu.cqjtu.zhang;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        SimfySpider ss = new SimfySpider();
        ss.crawling("http://news.cqjtu.edu.cn/list.jsp?urltype=tree.TreeTempUrl&wbtreeid=1021");
    }
}
