package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.OutOrInInfoMapper;
import com.nfu.drug.pojo.OutOrInInfo;
import com.nfu.drug.service.OutOrInInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 出库 服务实现类
 * </p>
 *
 * @author ZCJ
 * @since 2022-03-23
 */
@Service
public class OutOrInInfoServiceImpl extends ServiceImpl<OutOrInInfoMapper, OutOrInInfo> implements OutOrInInfoService {

    @Resource
    private OutOrInInfoMapper outOrInInfoMapper;
    
    
    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询药品出库信息
     */
    @Override
    public IPage<OutOrInInfo> selectOutOrInInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<OutOrInInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<OutOrInInfo> page = new Page<>(pageNum,pageSize);
        return outOrInInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param outorinInfo
     * @Description: 新增一条出库信息
     */
    @Override
    public int addOutOrInInfo(OutOrInInfo outorinInfo) {
        return outOrInInfoMapper.insert(outorinInfo);
    }

    /**
     * @param outorinInfo
     * @Description: 编辑修改一条出库信息
     */
    @Override
    public int editOutOrInInfo(OutOrInInfo outorinInfo) {
        return outOrInInfoMapper.updateById(outorinInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询药品出库的信息
     */
    @Override
    public OutOrInInfo queryOutOrInInfoById(int id) {
        return outOrInInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除出库的信息
     */
    @Override
    public int deleteOutOrInInfoByID(int id) {
        return outOrInInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的出库信息
     */
    @Override
    public List<OutOrInInfo> queryOutOrInInfoList() {
        return outOrInInfoMapper.selectList(null);
    }
}
