package com.xhua.controller;

import com.xhua.service.RssGetNewsService;
import com.xhua.service.impl.RssGetNewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/3/14.
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private RssGetNewsService rssGetNewsService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/testGetNews")
    public String test(){
        rssGetNewsService.getRssNews();
        return "success";
    }

}
