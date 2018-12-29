package edu.cqjtu.zhang;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;



/**
 * 解析网页，得到内容及链接
 * @author Lewis
 *
 */

public class PageParser {
	
	int i =0 ;
	
	public Set<String> getLinks(Page page,String cssSelector) {
		System.out.println("开始解析获得链接");
		Elements elements = page.getDoc().select(cssSelector);
		Set<String> links = new HashSet<>();
		for (Element e:elements){
			String link = e.absUrl("href");
			links.add(link);
		}
		return links;
	}

	/**
	 * 获得所有的目标元素
	 * @param page
	 * @param cssSelectors
	 * @return
	 */
	public Elements getTargetElements(Page page,String...cssSelectors){
		Elements result = new Elements();
		for (String s:cssSelectors){
			Elements elements = page.getDoc().select(s);
			if(elements!=null&&elements.size()>0){
				result.addAll(elements);
			}
		}
		return result;
	}

}
