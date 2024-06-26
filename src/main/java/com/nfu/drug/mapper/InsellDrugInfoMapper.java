package com.nfu.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfu.drug.pojo.InsellDrugInfo;

import java.util.List;


public interface InsellDrugInfoMapper extends BaseMapper<InsellDrugInfo> {


    int selectMaxID();


    /**
     * @Description: 根据药品的名称获取药品的批号
     */
    List<InsellDrugInfo> insellDrugInfoListByDrugName(String dname);

    int updatebyDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 更新药品在售信息的库存（增加）
     */
    int updateDrugCountByDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 根据药品在售信息批号来查询药品信息
     */
    InsellDrugInfo selectDrugCountByDruginnum(String druginnum);

    /**
     * @Description: 更新药品在售信息的库存（退货）
     */
    int updatebyDruginnumReduce(InsellDrugInfo drugOutInfo);

    List<InsellDrugInfo> drugInInfoListByDrugCount();
}
