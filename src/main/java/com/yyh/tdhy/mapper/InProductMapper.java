package com.yyh.tdhy.mapper;

import com.yyh.tdhy.po.InProduct;
import com.yyh.tdhy.po.InProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InProductMapper {
    int countByExample(InProductExample example);

    int deleteByExample(InProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InProduct record);

    int insertSelective(InProduct record);

    List<InProduct> selectByExample(InProductExample example);

    InProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InProduct record, @Param("example") InProductExample example);

    int updateByExample(@Param("record") InProduct record, @Param("example") InProductExample example);

    int updateByPrimaryKeySelective(InProduct record);

    int updateByPrimaryKey(InProduct record);
}