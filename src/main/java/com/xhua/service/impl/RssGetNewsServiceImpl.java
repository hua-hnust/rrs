package com.xhua.service.impl;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.xhua.dao.RssNewsMapper;
import com.xhua.dao.RssXmlMapper;
import com.xhua.model.RssNews;
import com.xhua.model.RssXml;
import com.xhua.model.RssXmlExample;
import com.xhua.service.RssGetNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * Created by Administrator on 2019/3/14.
 */
@Service("rssGetNewsService")
public class RssGetNewsServiceImpl implements RssGetNewsService {

    @Autowired
    private RssXmlMapper rssXmlMapper;

    @Autowired
    private RssNewsMapper rssNewsMapper;

    //每天早上6点触发
    @Scheduled(cron = "0 0 6 * * ?")
    @Override
    public void getRssNews() {

        RssXmlExample example = new RssXmlExample();
        example.createCriteria().andSourceIdEqualTo(1);

       List<RssXml> list = rssXmlMapper.selectByExample(example);

       for (RssXml rssXml:list){
           String url = rssXml.getRssUrl();

           try {

               URL rssUrl = new URL(url);
               SyndFeedInput input = new SyndFeedInput();
               SyndFeed feed = null;
               URLConnection conn;
               conn = rssUrl.openConnection();
               String content_encoding = conn.getHeaderField("Content-Encoding");

               if (content_encoding != null && content_encoding.contains("gzip")) {
                   System.out.println("conent encoding is gzip");
                   GZIPInputStream gzin = new GZIPInputStream(conn
                           .getInputStream());
                   feed = input.build(new XmlReader(gzin));
               } else {
                   feed = input.build(new XmlReader(conn.getInputStream()));
               }

               List<SyndEntry> entries = feed.getEntries();
               RssNews rssNews = new RssNews();

               for (SyndEntry entry:entries){
                   rssNews.setTitle(entry.getTitle());
                   rssNews.setAuthor(entry.getAuthor());
                   Long time = entry.getPublishedDate().getTime();
                   rssNews.setPublishedDate(time.toString());
                   rssNews.setContent(entry.getDescription().getValue());
                   rssNews.setLink(entry.getLink());
                   rssNews.setGetTime(System.currentTimeMillis());
                   rssNews.setTypeId(rssXml.getTypeId());
                   rssNews.setSourceId(rssXml.getSourceId());
                   rssNews.setGetUrl(rssXml.getId());
                   rssNewsMapper.insertSelective(rssNews);
               }
           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (FeedException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }
}
