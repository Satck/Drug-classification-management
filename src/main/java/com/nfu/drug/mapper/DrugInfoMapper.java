package com.nfu.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfu.drug.pojo.DrugInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DrugInfoMapper extends BaseMapper<DrugInfo> {

    /**
     * @Description: 更新药品的库存
     */
    int updateAddStock(@Param("count") int count, @Param("dName") String dName);

    int updateReduceStock(@Param("count") int count, @Param("dName") String dName);

    int selectStock(@Param("dName") String dName);

    DrugInfo selectDrugInfoByDname(@Param("dName") String dName);

    List<DrugInfo> drugInfoListBySName(@Param("sName") String sName);

}
