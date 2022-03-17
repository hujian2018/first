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
		RssAction rss=new RssAction();//生成rss
		System.out.println("任务开始");
		try {
			rss.testBuildObject(blogService.selectAll(),
								null,
								path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("任务结束");
	}

	public void setPath(String path) {
		this.path = path;
	}


}
