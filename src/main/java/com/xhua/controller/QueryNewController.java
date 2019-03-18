package com.xhua.controller;

import com.xhua.model.RssNews;
import com.xhua.model.RssType;
import com.xhua.service.QueryNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/3/14.
 */
@RestController
@RequestMapping("/news")
public class QueryNewController {

    @Autowired
    private QueryNewsService queryNewsService;

    @ResponseBody
    @RequestMapping(value = "/queryNewsType",method = RequestMethod.GET)
    public List<RssType> queryNewsType(@RequestParam(value = "sourceId") Integer sourceId){
        List<RssType> list = queryNewsService.queryRssNewsType(sourceId);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/queryNews",method = RequestMethod.GET)
    public List<RssNews> queryNews(Integer typeId,Integer page,Integer size){
        List<RssNews> list = queryNewsService.queryRssNews(typeId,page,size);
        return list;
    }
}
