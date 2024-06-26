package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.ReturnSupplierInfo;

import java.util.List;


public interface ReturnSupplierInfoService extends IService<ReturnSupplierInfo> {

    /**
     * @Description: 分页查询药品退货记录信息
     */
    IPage<ReturnSupplierInfo> selectReturnSupplierInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条药品退货记录信息
     */
    int addReturnSupplierInfo(ReturnSupplierInfo returnSupplierInfo);

    /**
     * @Description: 编辑修改一条药品退货记录信息
     */
    int editReturnSupplierInfo(ReturnSupplierInfo returnSupplierInfo);

    /**
     * @Description: 根据id来查询药品退货记录的信息
     */
    ReturnSupplierInfo queryReturnSupplierInfoById(int id);

    /**
     * @Description: 根据id来删除药品退货记录的信息
     */
    int deleteReturnSupplierInfoByID(int id);

    /**
     * @Description: 获取所有的药品退货记录信息
     */
    List<ReturnSupplierInfo> queryReturnSupplierInfoList();

}
