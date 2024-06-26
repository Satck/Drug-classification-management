package com.nfu.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfu.drug.pojo.DrugProblemInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


@Mapper
@Repository
public interface DrugProblemInfoMapper extends BaseMapper<DrugProblemInfo> {


    int updateDrugProblemInfoBydrugInNum(@Param("druginnum") String drugInNum, @Param("createtime") Date createTime);
}
