package com.rss;

import com.blog.entity.Blog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SuppressWarnings({})
public class RssAction{


	@SuppressWarnings("unchecked")
	public void testBuildObject(List one, List two, String path) {
		try {
			RssBuilder builder = new RssBuilder();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 循环遍历数据库记录生成Rss中的Item项
			for(int i=0;i<one.size();i++){
				Blog rs=(Blog)one.get(i);
				ChannelEItem item = new ChannelEItem();
				item.setTitle(rs.getTitle());
				item.setLink(rs.getId()+".html");
				item.setDescription(rs.getContent());
//				item.setPubDate(format.parse(rs.getTime()));
				item.setPubDate(rs.getReleaseDate());
				item.setCategory("我的文章");
				item.setAuthor(rs.getBlogType().getTypeName());
				item.setEnclosure("www.dukai168.cn");
				builder.createItems(item);
			}
//			for(int i=0;i<two.size();i++){
//				Img img=(Img)two.get(i);
//				ChannelImage image=new ChannelImage();
//				image.setTitle(img.getImgdesc());
//				image.setDescription(img.getImginfo());
//				image.setUrl(img.getImgurl()+"/s"+img.getImgname());
//				image.setLink("imgShow.action?id="+img.getId());
//				builder.createChannelImage(image);
//			}

			// 建立Rss的Channel信息
			builder.createChannel("测试个人博客-测试","http://localhost:8090/blog/articles/", "测试","zh-cn", new Date(), "测试");

			builder.buildChannel(path+"\\rss.xml");
		} catch (Exception e) {
			System.out.println("this is in error");
			System.out.println(e.getMessage());
		}
	}

//	public String execute() throws Exception {
//		this.testBuildObject();
//		return SUCCESS;
//	}

}
