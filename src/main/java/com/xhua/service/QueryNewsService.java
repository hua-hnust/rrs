package com.xhua.service;

import com.xhua.model.RssNews;
import com.xhua.model.RssType;

import java.util.List;

/**
 * Created by Administrator on 2019/3/14.
 */
public interface QueryNewsService {

    List<RssType> queryRssNewsType(Integer sourceId);

    List<RssNews> queryRssNews(Integer typeId,Integer page,Integer size);
}
