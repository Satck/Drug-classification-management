package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.ReturnGoodsInfoMapper;
import com.nfu.drug.pojo.ReturnGoodsInfo;
import com.nfu.drug.service.ReturnGoodsInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 收到退货表 服务实现类
 * </p>
 *
 */
@Service
public class ReturnGoodsInfoServiceImpl extends ServiceImpl<ReturnGoodsInfoMapper, ReturnGoodsInfo> implements ReturnGoodsInfoService {

    @Resource
    private ReturnGoodsInfoMapper returnGoodsInfoMapper;
    
    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品退货记录信息
     */
    @Override
    public IPage<ReturnGoodsInfo> selectReturnGoodsInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<ReturnGoodsInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<ReturnGoodsInfo> page = new Page<>(pageNum,pageSize);
        return returnGoodsInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param returnGoodsInfo
     * @Description: 新增一条药品退货记录信息
     */
    @Override
    public int addReturnGoodsInfo(ReturnGoodsInfo returnGoodsInfo) {
        return returnGoodsInfoMapper.insert(returnGoodsInfo);
    }

    /**
     * @param returnGoodsInfo
     * @Description: 编辑修改一条药品退货记录信息
     */
    @Override
    public int editReturnGoodsInfo(ReturnGoodsInfo returnGoodsInfo) {
        return returnGoodsInfoMapper.updateById(returnGoodsInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询药品退货记录的信息
     */
    @Override
    public ReturnGoodsInfo queryReturnGoodsInfoById(int id) {
        return returnGoodsInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除药品退货记录的信息
     */
    @Override
    public int deleteReturnGoodsInfoByID(int id) {
        return returnGoodsInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的药品退货记录信息
     */
    @Override
    public List<ReturnGoodsInfo> queryReturnGoodsInfoList() {
        return returnGoodsInfoMapper.selectList(null);
    }
}
