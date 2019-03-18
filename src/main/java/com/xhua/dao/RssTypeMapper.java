package com.xhua.dao;

import com.xhua.model.RssType;
import com.xhua.model.RssTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RssTypeMapper {
    int countByExample(RssTypeExample example);

    int deleteByExample(RssTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RssType record);

    int insertSelective(RssType record);

    List<RssType> selectByExample(RssTypeExample example);

    RssType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RssType record, @Param("example") RssTypeExample example);

    int updateByExample(@Param("record") RssType record, @Param("example") RssTypeExample example);

    int updateByPrimaryKeySelective(RssType record);

    int updateByPrimaryKey(RssType record);
}