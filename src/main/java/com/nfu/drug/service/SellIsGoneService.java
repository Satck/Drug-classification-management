package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.SellIsGone;


public interface SellIsGoneService extends IService<SellIsGone> {

    /**
     * @Description: 分页查询药品入库登记记账
     */
    IPage<SellIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param);

    /**
     * @Description: 将数据插入药品售完信息表
     */
    int insert(SellIsGone sellIsGone);

    /**
     * @Description: 删除一个药品售完信息记录
     */
    int deleteSellIsGoneByID(Integer id);

}
