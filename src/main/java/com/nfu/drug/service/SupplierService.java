package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.pojo.Supplier;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface SupplierService extends IService<Supplier> {

    /**
    * @Description: 分页查询供应商数据
    */
    IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param);


    /**
    * @Description: 新增一条供应商信息
    */
    int addSupplier(Supplier supplier);

    /**
    * @Description: 修改一条供应商信息
    */
    int editSupplier(Supplier supplier);

    /**
    * @Description: 根据主键ID来查询一个供应商对象
    */
    Supplier querySupplierById(int id);

    /**
    * @Description: 根据主键ID来删除一个供应商对象
    */
    int deleteSupplierByID(int id);

    /**
    * @Description: 查询所有供应商的列表
    */
    List<Supplier> querySupplierList();



}
