package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.ReturnGoodsInfo;

import java.util.List;


public interface ReturnGoodsInfoService extends IService<ReturnGoodsInfo> {
    /**
     * @Description: 分页查询药品退货记录信息
     */
    IPage<ReturnGoodsInfo> selectReturnGoodsInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条药品退货记录信息
     */
    int addReturnGoodsInfo(ReturnGoodsInfo returnDoodsInfo);

    /**
     * @Description: 编辑修改一条药品退货记录信息
     */
    int editReturnGoodsInfo(ReturnGoodsInfo returnDoodsInfo);

    /**
     * @Description: 根据id来查询药品退货记录的信息
     */
    ReturnGoodsInfo queryReturnGoodsInfoById(int id);

    /**
     * @Description: 根据id来删除药品退货记录的信息
     */
    int deleteReturnGoodsInfoByID(int id);

    /**
     * @Description: 获取所有的药品退货记录信息
     */
    List<ReturnGoodsInfo> queryReturnGoodsInfoList();

}
