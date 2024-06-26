package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.DrugInfo;

import java.util.List;

/**
 * <p>
 * 药品信息 服务类
 * </p>
 *
 * @author ZCJ
 * @since 2022-03-01
 */
public interface DrugInfoService extends IService<DrugInfo> {

    /** 
    * @Description: 分页查询药品数据
    */
    IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param);


    /**
    * @Description: 新增一条药品信息
    */
    int addDrugInfo(DrugInfo druginfo);

    /**
    * @Description: 修改一条药品信息
    */
    int editDrugInfo(DrugInfo druginfo);

    /**
    * @Description: 根据主键ID来查询一个药品对象
    */
    DrugInfo queryDrugInfoById(int id);

    /**
    * @Description: 根据主键ID来删除一个药品对象
    */
    int deleteDrugInfoByID(int id);

    /**
     * @Description: 查询所有药品的列表
     */
    List<DrugInfo> queryDrugInfoList();


    /**
     * @Description: 修改药品的库存（添加）
     */
    int updateAddStock(int count, String dname);

    /**
     * @Description: 修改药品的库存（减少）
     */
    int updateReduceStock(int count, String dname);

    /**
     * @Description: 查询药品的库存
     */
    int selectStock(String dname);

    /**
     * @Description: 根据药品名字查询药品信息
     */
    DrugInfo selectDrugInfoByDname(String dname);

    /**
     * @Description: 根据供应商名称获取所有的药品名称
     */
    List<DrugInfo> drugInfoListBySName(String sName);
}
