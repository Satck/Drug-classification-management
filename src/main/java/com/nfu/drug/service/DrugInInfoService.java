package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.DrugInInfo;

import java.util.List;


public interface DrugInInfoService extends IService<DrugInInfo> {
    /**
     * @Description: 分页查询药品入库登记记账
     */
    IPage<DrugInInfo> selectDrugInInfoPage(int pageNum, int pageSize, String param);


    /**
     * @Description: 新增一条药品入库登记记账信息
     */
    int addDrugInInfo(DrugInInfo drugInInfo);

    /**
     * @Description: 修改一条药品入库登记记账信息
     */
    int editDrugInInfo(DrugInInfo drugInInfo);

    /**
     * @Description: 根据主键ID来查询一个药品入库登记记账对象
     */
    DrugInInfo queryDrugInInfoById(int id);

    /**
     * @Description: 根据主键ID来删除一个药品入库登记记账对象
     */
    int deleteDrugInInfoByID(int id);

    /**
     * @Description: 查询所有药品入库登记记账的药品名字（去重）
     */
    List<DrugInInfo> queryDrugInInfoList();


    /**
     * @Description: 查询药品进货表中最大的ID
     */
    int selectMaxID();

    /**
     * @Description: 新增药品进货表
     */
    int insert(DrugInInfo drugInInfo);

    /**
     * @Description: 获取所有的药品进货的进货编码
     */
    List<DrugInInfo> drugInInfoListByDrugName(String dname);

    /**
     * @Description: 更新药品进货单的数据通过药品单号
     */
    int updatebyDruginnum(DrugInInfo drugOutInfo);

    /**
     * @Description: 根据进货编号来更新库存（减少）
     */
    int updatereduceDrugCountByDruginnum(DrugInInfo drugOutInfo);

    /**
     * @Description: 根据药品进货批号来查询药品数量
     */
    int selectDrugCountByDruginnum(String druginnum);

    /**
     * @Description: 获取所有药品库存为零的药品
     */
    List<DrugInInfo> drugInInfoListByDrugCount();

    /**
     * @Description: 获取所有的药品进货记录的药品名字（去重）
     */
    List<DrugInInfo> drugInInfoListOnly();

    /**
     * @Description: 根据进货编号来更新库存（增加）
     */
    int updateAddDrugCountByDruginnum(DrugInInfo drugInInfo);
}
