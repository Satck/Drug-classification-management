package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.SellIsGoneMapper;
import com.nfu.drug.pojo.SellIsGone;
import com.nfu.drug.service.SellIsGoneService;
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
public class SellIsGoneServiceImpl extends ServiceImpl<SellIsGoneMapper, SellIsGone> implements SellIsGoneService {


    @Resource
    private SellIsGoneMapper sellIsGoneMapper;

    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品入库登记记账
     */
    @Override
    public IPage<SellIsGone> selectrugIsGonePage(int pageNum, int pageSize, String param) {
        QueryWrapper<SellIsGone> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<SellIsGone> page = new Page<>(pageNum, pageSize);
        return sellIsGoneMapper.selectPage(page, queryWrapper);
    }

    /**
     * @param sellIsGone
     * @Description: 将数据插入药品售完信息表
     */
    @Override
    public int insert(SellIsGone sellIsGone) {
        return sellIsGoneMapper.insert(sellIsGone);
    }

    /**
     * @param id
     * @Description: 删除一个药品售完信息记录
     */
    @Override
    public int deleteSellIsGoneByID(Integer id) {
        return sellIsGoneMapper.deleteById(id);
    }
}
