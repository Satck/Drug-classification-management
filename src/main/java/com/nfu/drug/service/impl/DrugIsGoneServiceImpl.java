package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.DrugIsGoneMapper;
import com.nfu.drug.pojo.DrugIsGone;
import com.nfu.drug.service.DrugIsGoneService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 */
@Service
public class DrugIsGoneServiceImpl extends ServiceImpl<DrugIsGoneMapper, DrugIsGone> implements DrugIsGoneService {


    @Resource
    private DrugIsGoneMapper drugIsGoneMapper;

    /**
     * @Description: 分页查询药品入库登记记账
     */
    @Override
    public IPage<DrugIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugIsGone> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<DrugIsGone> page = new Page<>(pageNum, pageSize);
        return drugIsGoneMapper.selectPage(page, queryWrapper);
    }

    /**
     * @Description: 将数据插入药品售完信息表
     */
    @Override
    public int insert(DrugIsGone drugIsGone) {
        return drugIsGoneMapper.insert(drugIsGone);
    }

    /**
     * @Description: 删除一个药品售完信息记录
     */
    @Override
    public int deleteDrugIsGoneByID(Integer id) {
        return drugIsGoneMapper.deleteById(id);
    }
}
