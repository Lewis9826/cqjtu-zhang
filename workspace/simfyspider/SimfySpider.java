package edu.cqjtu.zhang;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Set;

public class SimfySpider {
	PageVisitor visitor = new PageVisitor();
	
	PageParser parser = new PageParser();
	PageRepository repo = new PageRepositoryImpl();
	
	public void crawling(String seed) {
		LinkStore linkStore = new LinkStore();
		linkStore.addUnVisitLink(seed);
		while (!linkStore.isUnVisitedEmpty()) {
			//访问页面
			String url = linkStore.getFirst();
			Page page = visitor.visit(url);
			//得到链接，存入未访问队列
			Set<String> links = parser.getLinks(page,".nav");
			for(String s:links) {
				linkStore.addUnVisitLink(s);
			}

			Elements elements = parser.getTargetElements(page, ".channel-new-list li a");
			for (Element e:elements){
				Element element = e.select(" a").first();
				String title = element.text();
				String newsUrl = element.absUrl("href");
				String content = null;
				Page contentPage = visitor.visit(newsUrl);
				Elements contentElements = parser.getTargetElements(contentPage,"#text_Content p");
				if (contentElements!=null&&contentElements.size()>0){
					content = contentElements.first().text();
				}
				System.out.println(title+" : "+newsUrl+" : "+content);
			}
			linkStore.addVisited(url);
			//保存文件
			repo.save(page);
		}
	}
}
