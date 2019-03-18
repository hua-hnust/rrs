package com.xhua.service.impl;

import com.github.pagehelper.PageHelper;
import com.xhua.dao.RssNewsMapper;
import com.xhua.dao.RssTypeMapper;
import com.xhua.model.RssNews;
import com.xhua.model.RssNewsExample;
import com.xhua.model.RssType;
import com.xhua.model.RssTypeExample;
import com.xhua.service.QueryNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/3/14.
 */
@Service("queryNewsService")
public class QueryNewsServiceImpl implements QueryNewsService {

    @Autowired
    private RssTypeMapper rssTypeMapper;

    @Autowired
    private RssNewsMapper rssNewsMapper;

    @Override
    public List<RssType> queryRssNewsType(Integer sourceId) {
        RssTypeExample example = new RssTypeExample();
        example.createCriteria().andSourceIdEqualTo(sourceId);
        return rssTypeMapper.selectByExample(example);
    }

    @Override
    public List<RssNews> queryRssNews(Integer typeId, Integer page, Integer size) {
        RssNewsExample example = new RssNewsExample();
        example.createCriteria().andTypeIdEqualTo(typeId);
        PageHelper.startPage(page,size);
        return rssNewsMapper.selectByExampleWithBLOBs(example);
    }
}
