package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.SaleInfo;

import java.util.List;


public interface SaleInfoService extends IService<SaleInfo> {
    /**
     * @Description: 分页查询药品销售记录信息
     */
    IPage<SaleInfo> selectSaleInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条药品销售记录信息
     */
    int addSaleInfo(SaleInfo saleInfo);

    /**
     * @Description: 编辑修改一条药品销售记录信息
     */
    int editSaleInfo(SaleInfo saleInfo);

    /**
     * @Description: 根据id来查询药品销售记录的信息
     */
    SaleInfo querySaleInfoById(int id);

    /**
     * @Description: 根据id来删除药品销售记录的信息
     */
    int deleteSaleInfoByID(int id);

    /**
     * @Description: 获取所有的药品销售记录信息
     */
    List<SaleInfo> querySaleInfoList();

}
