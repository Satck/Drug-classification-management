package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.InsellDrugInfo;

import java.util.List;


public interface InsellDrugInfoService extends IService<InsellDrugInfo> {
    /**
     * @Description: 分页查询药品入库登记记账
     */
    IPage<InsellDrugInfo> selectInsellDrugInfoPage(int pageNum, int pageSize, String param);


    /**
     * @Description: 新增一条药品入库登记记账信息
     */
    int addInsellDrugInfo(InsellDrugInfo insellDrugInfo);

    /**
     * @Description: 修改一条药品入库登记记账信息
     */
    int editInsellDrugInfo(InsellDrugInfo insellDrugInfo);

    /**
     * @Description: 根据主键ID来查询一个药品入库登记记账对象
     */
    InsellDrugInfo queryInsellDrugInfoById(int id);

    /**
     * @Description: 根据主键ID来删除一个药品入库登记记账对象
     */
    int deleteInsellDrugInfoByID(int id);

    /**
     * @Description: 查询所有药品入库登记记账的列表
     */
    List<InsellDrugInfo> queryInsellDrugInfoList();


    /**
     * @Description: 查询药品在售信息表中最大的ID
     */
    int selectMaxID();

    /**
     * @Description: 新增药品在售信息表
     */
    int insert(InsellDrugInfo insellDrugInfo);

    /**
     * @Description: 获取所有的药品在售信息的进货编码
     */
    List<InsellDrugInfo> insellDrugInfoListByDrugName(String dname);

    /**
     * @Description: 更新药品在售信息单的数据通过药品单号(增加库存)
     */
    int updatebyDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 更新药品在售信息单的数据通过药品单号(增加减少)
     */
    int updatebyDruginnumReduce(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 根据进货编号来更新库存
     */
    int updateDrugCountByDruginnum(InsellDrugInfo drugOutInfo);

    /**
     * @Description: 根据药品在售信息批号来查询药品信息
     */
    InsellDrugInfo selectDrugCountByDruginnum(String druginnum);

    /**
     * @Description: 获取所有药品库存为零的药品
     */
    List<InsellDrugInfo> drugInInfoListByDrugCount();
}
