package com.nfu.drug.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfu.drug.pojo.DrugInInfo;

import java.util.List;

public interface DrugInInfoMapper extends BaseMapper<DrugInInfo> {

    int selectMaxID();

    List<DrugInInfo> drugInInfoListByDrugName(String dname);

    int updatebyDruginnum(DrugInInfo drugOutInfo);

    int updateDrugCountByDruginnum(DrugInInfo drugOutInfo);

    int selectDrugCountByDruginnum(String druginnum);

    int updateDrugRetuenByDruginnum(DrugInInfo drugInInfo);

    List<DrugInInfo> drugInInfoListByDrugCount();

    List<DrugInInfo> drugInInfoListOnly();

    int updateAddDrugCountByDruginnum(DrugInInfo drugInInfo);
}
