package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nfu.drug.pojo.DrugInfo;
import com.nfu.drug.mapper.DrugInfoMapper;
import com.nfu.drug.service.DrugInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements DrugInfoService {


    @Resource
    private DrugInfoMapper drugInfoMapper;


    /**
     * @Description: 分页查询药品数据
     */
    @Override
    public IPage<DrugInfo> selectDrugInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<DrugInfo> page = new Page<>(pageNum,pageSize);
        return drugInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @Description: 新增一条药品信息
     */
    @Override
    public int addDrugInfo(DrugInfo druginfo) {
        return drugInfoMapper.insert(druginfo);
    }

    /**
     * @Description: 修改一条药品信息
     */
    @Override
    public int editDrugInfo(DrugInfo druginfo) {
        return drugInfoMapper.updateById(druginfo);
    }

    /**
     * @Description: 根据主键ID来查询一个药品对象
     */
    @Override
    public DrugInfo queryDrugInfoById(int id) {
        return drugInfoMapper.selectById(id);
    }

    /**
     * @Description: 根据主键ID来删除一个药品对象
     */
    @Override
    public int deleteDrugInfoByID(int id) {
        return drugInfoMapper.deleteById(id);
    }

    /**
     * @Description: 查询所有药品的列表
     */
    @Override
    public List<DrugInfo> queryDrugInfoList() {
        return drugInfoMapper.selectList(null);
    }

    /**
     * @Description: 修改药品的库存（增加）
     */
    @Override
    public int updateAddStock(int count, String dname) {
        return drugInfoMapper.updateAddStock(count, dname);
    }

    /**
     * @Description: 修改药品的库存（减少）
     */
    @Override
    public int updateReduceStock(int count, String dname) {
        return drugInfoMapper.updateReduceStock(count, dname);
    }

    /**
     * @Description: 查询药品的库存
     */
    @Override
    public int selectStock(String dname) {
        return drugInfoMapper.selectStock(dname);
    }

    /**
     * @Description: 根据药品名字查询药品信息
     */
    @Override
    public DrugInfo selectDrugInfoByDname(String dname) {
        return drugInfoMapper.selectDrugInfoByDname(dname);
    }

    /**
     * @Description: 根据供应商名称获取所有的药品名称
     */
    @Override
    public List<DrugInfo> drugInfoListBySName(String sName) {
        return drugInfoMapper.drugInfoListBySName(sName);
    }


}
