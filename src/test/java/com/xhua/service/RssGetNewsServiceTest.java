package com.xhua.service;

import com.xhua.RrsApplication;
import com.xhua.dao.RssNewsMapper;
import com.xhua.model.RssNews;
import com.xhua.model.RssNewsExample;
import com.xhua.util.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RrsApplication.class)
@WebAppConfiguration
@TestPropertySource(locations = "classpath:application.yml")
public class RssGetNewsServiceTest {

    @Autowired
    private RssGetNewsService rssGetNewsService;

//    private RssNewsMapper rssNewsMapper = SpringUtils.getBean(RssNewsMapper.class);

    @Test
    public void test(){

        new ClassPathXmlApplicationContext("");

        RssNewsExample example = new RssNewsExample();

        example.createCriteria().andSourceIdEqualTo(2);

//        List<RssNews> list  = rssNewsMapper.selectByExample(example);

        rssGetNewsService.getRssNews();
    }
}
