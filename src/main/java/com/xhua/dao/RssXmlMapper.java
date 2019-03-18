package com.xhua.dao;

import com.xhua.model.RssXml;
import com.xhua.model.RssXmlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RssXmlMapper {
    int countByExample(RssXmlExample example);

    int deleteByExample(RssXmlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RssXml record);

    int insertSelective(RssXml record);

    List<RssXml> selectByExample(RssXmlExample example);

    RssXml selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RssXml record, @Param("example") RssXmlExample example);

    int updateByExample(@Param("record") RssXml record, @Param("example") RssXmlExample example);

    int updateByPrimaryKeySelective(RssXml record);

    int updateByPrimaryKey(RssXml record);
}