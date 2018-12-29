package edu.cqjtu.zhang.simfyspiderboot.service.spider;

import edu.cqjtu.zhang.simfyspiderboot.dal.NewsRepository;
import edu.cqjtu.zhang.simfyspiderboot.domain.News;
import edu.cqjtu.zhang.simfyspiderboot.domain.Page;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Lewis
 */
@Service
public class SimfySpider {
	@Autowired
	PageVisitor visitor;

	@Autowired
	PageParser parser;

	@Autowired
	NewsRepository repo;

	public void crawling(String seed) {
		List<News> newsList = new ArrayList<>();
		//初始化LinkStore
		LinkStore linkStore = new LinkStore();
		//把种子URL加入未访问队列
		linkStore.addUnVisitLink(seed);
		while(!linkStore.isUnVisitedEmpty()) {
			/**
			 * 得到链接
			 */

			String url = linkStore.getFirst();
			/**
			 * 访问页面
			 */
			Page page = visitor.visit(url);
			/**
			 * 得到链接，存入未访问队列
			 */
			Set<String> links = parser.getLinks(page,".nav_com li a");
			for(String s: links) {
				linkStore.addUnVisitLink(s);
			}
			// 得到需要的内容
			Elements elements = parser.getTargetElements(page,"[data-type=top]","[data-type=blog]");
			for (Element e :elements){
				Element element = e.select(".title a").first();
				News news = new News();
				news.setTitle(element.text());
				news.setUrl(element.absUrl("href"));

				Element summaryElement = e.select(".summary").first();
				news.setSummary(summaryElement.text());

				//获取内容页的操作
				String content;
				Page contentPage = visitor.visit(news.getUrl());
				Elements contentElements = parser.getTargetElements(contentPage,"article");
				if(contentElements!=null&&contentElements.size()>0){
					content = contentElements.first().html();
					news.setContent(content);
				}
				newsList.add(news);
				// System.out.println(news);
			}

			//添加已访问
			linkStore.addVisited(url);
			//保存文件
			repo.saveAll(newsList);
		}
	}
}
