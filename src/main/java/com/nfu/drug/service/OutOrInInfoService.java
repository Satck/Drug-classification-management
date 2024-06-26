package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.OutOrInInfo;

import java.util.List;


public interface OutOrInInfoService extends IService<OutOrInInfo> {

    /** 
    * @Description: 分页查询药品出库信息
    */
    IPage<OutOrInInfo> selectOutOrInInfoPage(int pageNum, int pageSize, String param);

    /** 
    * @Description: 新增一条出库信息
    */
    int addOutOrInInfo(OutOrInInfo outorinInfo);

    /** 
    * @Description: 编辑修改一条出库信息
    */
    int editOutOrInInfo(OutOrInInfo outorinInfo);

    /** 
    * @Description: 根据id来查询药品出库的信息
    */
    OutOrInInfo queryOutOrInInfoById(int id);

    /** 
    * @Description: 根据id来删除出库的信息
    */
    int deleteOutOrInInfoByID(int id);

    /** 
    * @Description: 获取所有的出库信息
    */
    List<OutOrInInfo> queryOutOrInInfoList();
}
