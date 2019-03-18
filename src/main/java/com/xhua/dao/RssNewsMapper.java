package com.xhua.dao;

import com.xhua.model.RssNews;
import com.xhua.model.RssNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RssNewsMapper {
    int countByExample(RssNewsExample example);

    int deleteByExample(RssNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RssNews record);

    int insertSelective(RssNews record);

    List<RssNews> selectByExampleWithBLOBs(RssNewsExample example);

    List<RssNews> selectByExample(RssNewsExample example);

    RssNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RssNews record, @Param("example") RssNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") RssNews record, @Param("example") RssNewsExample example);

    int updateByExample(@Param("record") RssNews record, @Param("example") RssNewsExample example);

    int updateByPrimaryKeySelective(RssNews record);

    int updateByPrimaryKeyWithBLOBs(RssNews record);

    int updateByPrimaryKey(RssNews record);
}