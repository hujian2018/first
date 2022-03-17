package com.rss;

import com.blog.service.ResBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.TimerTask;

public class RssTimerTasks extends TimerTask {

	@Resource
	private ResBlogService blogService;

	
	private String path;

	public void run() {
		RssAction rss=new RssAction();//����rss
		System.out.println("����ʼ");
		try {
			rss.testBuildObject(blogService.selectAll(),
								null,
								path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�������");
	}

	public void setPath(String path) {
		this.path = path;
	}


}
