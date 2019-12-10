package com.yyh.tdhy.mapper;

import com.yyh.tdhy.po.InPromotion;
import com.yyh.tdhy.po.InPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InPromotionMapper {
    int countByExample(InPromotionExample example);

    int deleteByExample(InPromotionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InPromotion record);

    int insertSelective(InPromotion record);

    List<InPromotion> selectByExample(InPromotionExample example);

    InPromotion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InPromotion record, @Param("example") InPromotionExample example);

    int updateByExample(@Param("record") InPromotion record, @Param("example") InPromotionExample example);

    int updateByPrimaryKeySelective(InPromotion record);

    int updateByPrimaryKey(InPromotion record);
}