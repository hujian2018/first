package com.blog.service.impl;

import com.blog.dao.ResBlogDao;
import com.blog.entity.Blog;
import com.blog.service.ResBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("resBlogService")
public class ResBlogServiceImpl implements ResBlogService {

    @Autowired
    private ResBlogDao resBlogDao;

    @Override
    public List<Blog> selectAll() {
        return resBlogDao.selectAll();
    }
}
