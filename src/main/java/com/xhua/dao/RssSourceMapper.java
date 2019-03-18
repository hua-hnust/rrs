package com.xhua.dao;

import com.xhua.model.RssSource;
import com.xhua.model.RssSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RssSourceMapper {
    int countByExample(RssSourceExample example);

    int deleteByExample(RssSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RssSource record);

    int insertSelective(RssSource record);

    List<RssSource> selectByExample(RssSourceExample example);

    RssSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RssSource record, @Param("example") RssSourceExample example);

    int updateByExample(@Param("record") RssSource record, @Param("example") RssSourceExample example);

    int updateByPrimaryKeySelective(RssSource record);

    int updateByPrimaryKey(RssSource record);
}