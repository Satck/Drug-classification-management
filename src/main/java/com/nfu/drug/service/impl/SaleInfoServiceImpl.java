package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.SaleInfoMapper;
import com.nfu.drug.pojo.SaleInfo;
import com.nfu.drug.service.SaleInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 账单信息表 服务实现类
 * </p>
 *
 */
@Service
public class SaleInfoServiceImpl extends ServiceImpl<SaleInfoMapper, SaleInfo> implements SaleInfoService {


    @Resource
    private SaleInfoMapper saleInfoMapper;


    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品销售记录信息
     */
    @Override
    public IPage<SaleInfo> selectSaleInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<SaleInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<SaleInfo> page = new Page<>(pageNum,pageSize);
        return saleInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param saleInfo
     * @Description: 新增一条药品销售记录信息
     */
    @Override
    public int addSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.insert(saleInfo);
    }

    /**
     * @param saleInfo
     * @Description: 编辑修改一条药品销售记录信息
     */
    @Override
    public int editSaleInfo(SaleInfo saleInfo) {
        return saleInfoMapper.updateById(saleInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询药品销售记录的信息
     */
    @Override
    public SaleInfo querySaleInfoById(int id) {
        return saleInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除药品销售记录的信息
     */
    @Override
    public int deleteSaleInfoByID(int id) {
        return saleInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的药品销售记录信息
     */
    @Override
    public List<SaleInfo> querySaleInfoList() {
        return saleInfoMapper.selectList(null);
    }
}
