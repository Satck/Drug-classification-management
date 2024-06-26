package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nfu.drug.pojo.DrugIsGone;


public interface DrugIsGoneService extends IService<DrugIsGone> {

    /**
     * @Description: 分页查询药品入库登记记账
     */
    IPage<DrugIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param);

    /**
     * @Description: 将数据插入药品售完信息表
     */
    int insert(DrugIsGone drugIsGone);

    /**
     * @Description: 删除一个药品售完信息记录
     */
    int deleteDrugIsGoneByID(Integer id);
}
