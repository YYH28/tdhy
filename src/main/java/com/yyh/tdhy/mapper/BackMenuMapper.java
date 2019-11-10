package com.yyh.tdhy.mapper;

import com.yyh.tdhy.po.BackMenu;
import com.yyh.tdhy.po.BackMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackMenuMapper {
    int countByExample(BackMenuExample example);

    int deleteByExample(BackMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BackMenu record);

    int insertSelective(BackMenu record);

    List<BackMenu> selectByExample(BackMenuExample example);

    BackMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BackMenu record, @Param("example") BackMenuExample example);

    int updateByExample(@Param("record") BackMenu record, @Param("example") BackMenuExample example);

    int updateByPrimaryKeySelective(BackMenu record);

    int updateByPrimaryKey(BackMenu record);
}