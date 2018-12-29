package edu.cqjtu.zhang.simfyspiderboot.service.spider;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * 存储未访问及已访问的URL
 * @author Lewis
 */

@Component
public class LinkStore {

	/**
	 * 已访问的
	 */

	private Set<String> visitedLinks = new HashSet<>();
	/**
	 * 未访问的
	 */

	private Queue<String> unVisitedLinkQueue = new LinkedList<>();
	public void addUnVisitLink(String url) {
		System.out.println("添加未访问"+url);
		if(url!=null&&!visitedLinks.contains(url)&&!unVisitedLinkQueue.contains(url)) {
			unVisitedLinkQueue.add(url);
		}

	}
	public void addVisited(String url) {
		System.out.println("添加已访问"+url);
		visitedLinks.add(url);
	}
	/**
	 * 确认该url是否被访问
	 */

	public boolean isVisited(String url){
		return visitedLinks.contains(url);
	}
	public boolean isunVisited(String url) {
		return unVisitedLinkQueue.contains(url);
	}
	/**
	 * 未访问的连接队列是否为空
	 */

	public boolean isUnVisitedEmpty(){
		return unVisitedLinkQueue.isEmpty();
	}

	public String getFirst() {
		return unVisitedLinkQueue.poll();
		
	}
	
	
}
