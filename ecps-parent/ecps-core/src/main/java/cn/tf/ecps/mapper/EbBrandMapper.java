package cn.tf.ecps.mapper;

import cn.tf.ecps.po.EbBrand;
import cn.tf.ecps.po.EbBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EbBrandMapper {
    int countByExample(EbBrandExample example);

    int deleteByExample(EbBrandExample example);

    int deleteByPrimaryKey(Long brandId);

    int insert(EbBrand record);

    int insertSelective(EbBrand record);

    List<EbBrand> selectByExample(EbBrandExample example);

    EbBrand selectByPrimaryKey(Long brandId);

    int updateByExampleSelective(@Param("record") EbBrand record, @Param("example") EbBrandExample example);

    int updateByExample(@Param("record") EbBrand record, @Param("example") EbBrandExample example);

    int updateByPrimaryKeySelective(EbBrand record);

    int updateByPrimaryKey(EbBrand record);
}