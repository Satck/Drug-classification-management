package com.nfu.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfu.drug.pojo.BillInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface BillInfoMapper extends BaseMapper<BillInfo> {

    List<BillInfo> queryDrugInfoListBySName(@Param("sName") String sname);

    BillInfo selectCountByDrugInnum(@Param("druginnum") String druginnum);
}
