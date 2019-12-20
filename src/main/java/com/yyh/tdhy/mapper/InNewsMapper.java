package com.yyh.tdhy.mapper;

import com.yyh.tdhy.po.InNews;
import com.yyh.tdhy.po.InNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InNewsMapper {
    int countByExample(InNewsExample example);

    int deleteByExample(InNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InNews record);

    int insertSelective(InNews record);

    List<InNews> selectByExample(InNewsExample example);

    InNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InNews record, @Param("example") InNewsExample example);

    int updateByExample(@Param("record") InNews record, @Param("example") InNewsExample example);

    int updateByPrimaryKeySelective(InNews record);

    int updateByPrimaryKey(InNews record);
}