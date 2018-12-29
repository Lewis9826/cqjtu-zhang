package edu.cqjtu.zhang.simfyspiderboot.web;

import edu.cqjtu.zhang.simfyspiderboot.service.spider.SimfySpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Lewis
 */
@Controller
public class CrawlingController {

    @Autowired
    private SimfySpider simfySpider;

    @RequestMapping("crawl")
    @ResponseBody
    public String crawl(String seed){
        simfySpider.crawling(seed);
        return "Success";
    }

}
