package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.DrugProblemInfo;

import java.util.Date;
import java.util.List;


public interface DrugProblemInfoService extends IService<DrugProblemInfo> {

    /**
     * @Description: 分页查询问题药品信息
     */
    IPage<DrugProblemInfo> selectDrugProblemInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条问题药品信息
     */
    int addDrugProblemInfo(DrugProblemInfo drugProblemInfo);

    /**
     * @Description: 编辑修改一条问题药品信息
     */
    int editDrugProblemInfo(DrugProblemInfo drugProblemInfo);

    /**
     * @Description: 根据id来查询问题药品的信息
     */
    DrugProblemInfo queryDrugProblemInfoById(int id);

    /**
     * @Description: 根据id来删除问题药品的信息
     */
    int deleteDrugProblemInfoByID(int id);

    /**
     * @Description: 获取所有的问题药品信息
     */
    List<DrugProblemInfo> queryDrugProblemInfoList();

    int updateDrugProblemInfoBydrugInNum(String drugInNum, Date createTime);

}
