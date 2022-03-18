/*  1:   */
package com.blog.controller.admin;
/*  2:   */
/*  3:   */

import com.blog.entity.Blog;
/*  4:   */ import com.blog.entity.BlogType;
/*  5:   */ import com.blog.entity.Blogger;
/*  6:   */ import com.blog.entity.Link;
/*  7:   */ import com.blog.service.*;
/*  8:   */
/*  9:   */
/* 10:   */
/* 11:   */ import com.blog.util.ResponseUtil;
/* 12:   */ import java.util.List;
/* 13:   */ import javax.annotation.Resource;
/* 14:   */ import javax.servlet.ServletContext;
/* 15:   */ import javax.servlet.http.HttpServletRequest;
/* 16:   */ import javax.servlet.http.HttpServletResponse;
/* 17:   */ import com.rss.RssAction;
import net.sf.json.JSONObject;
/* 18:   */ import org.springframework.stereotype.Controller;
/* 19:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 20:   */ import org.springframework.web.context.WebApplicationContext;
/* 21:   */ import org.springframework.web.servlet.support.RequestContextUtils;

/* 22:   */
/* 23:   */
@Controller
/* 24:   */
@RequestMapping({"/admin/system"})
/* 25:   */ public class SystemAdminController
        /* 26:   */ {
    /* 27:   */
    @Resource
    /* 28:   */ private BloggerService bloggerService;
    /* 29:   */
    @Resource
    /* 30:   */ private BlogTypeService blogTypeService;
    /* 31:   */
    @Resource
    /* 32:   */ private BlogService blogService;
    /* 33:   */
    @Resource
    /* 34:   */ private LinkService linkService;

    /* 35:   */
    /* 36:   */
    @RequestMapping({"/refreshSystem"})
    /* 37:   */ public String refreshSystem(HttpServletResponse response, HttpServletRequest request)
    /* 38:   */     throws Exception
    /* 39:   */ {
        /* 40:55 */
        ServletContext application = RequestContextUtils.getWebApplicationContext(request).getServletContext();
        /* 41:56 */
        Blogger blogger = this.bloggerService.find();
        /* 42:57 */
        blogger.setPassword(null);
        /* 43:58 */
        application.setAttribute("blogger", blogger);
        /* 44:   */
        /* 45:60 */
        List<BlogType> blogTypeCountList = this.blogTypeService.countList();
        /* 46:61 */
        application.setAttribute("blogTypeCountList", blogTypeCountList);
        /* 47:   */
        /* 48:63 */
        List<Blog> blogCountList = this.blogService.countList();
        /* 49:64 */
        application.setAttribute("blogCountList", blogCountList);
        /* 50:   */
        /* 51:66 */
        List<Link> linkList = this.linkService.list(null);
        /* 52:67 */
        application.setAttribute("linkList", linkList);
        /* 53:   */
        /* 54:69 */
        JSONObject result = new JSONObject();
        /* 55:70 */
        result.put("success", Boolean.valueOf(true));
        /* 56:71 */
        ResponseUtil.write(response, result);
        /* 57:72 */
        return null;
        /* 58:   */
    }

    @Resource
    private ResBlogService resBlogService;


    @RequestMapping({"/refreshSystemRss"})
    public String refreshSystemRss(HttpServletResponse response, HttpServletRequest request)
            throws Exception {
        RssAction rss=new RssAction();

        //String path="E:\\阅读器\\ROOT";
        String path="D:\\wonderful\\Blog\\src\\main\\webapp";
        try {
            List<Blog> blogs = resBlogService.selectAll();
            rss.testBuildObject(blogs, null,  path );
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject result = new JSONObject();
        result.put("success", Boolean.valueOf(true));
        ResponseUtil.write(response, result);
        return null;
    }

    /* 59:   */
}



/* Location:           D:\classes\

 * Qualified Name:     com.blog.controller.admin.SystemAdminController

 * JD-Core Version:    0.7.0.1

 */