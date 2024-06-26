package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.BillInfo;

import java.util.List;

public interface BillInfoService extends IService<BillInfo> {
    /**
     * @Description: 分页查询账单信息

     */
    IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条账单信息
     */
    int addBillInfo(BillInfo billInfo);

    /**
     * @Description: 编辑修改一条账单信息
     */
    int editBillInfo(BillInfo billInfo);

    /**
     * @Description: 根据id来查询账单的信息
     */
    BillInfo queryBillInfoById(int id);

    /**
     * @Description: 根据id来删除账单的信息
     */
    int deleteBillInfoByID(int id);

    /**
     * @Description: 获取所有的账单信息
     */
    List<BillInfo> queryBillInfoList();

    /**
     * @Description: 根据供应商名字查询药品信息
     */
    List<BillInfo> queryDrugInfoListBySName(String sname);

    /**
     * @Description: 根据药品进货编码主键查询药品进货时进货数量
     */
    BillInfo selectCountByDrugInnum(String druginnum);
}
