package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.DrugInInfoMapper;
import com.nfu.drug.mapper.DrugProblemInfoMapper;
import com.nfu.drug.pojo.DrugInInfo;
import com.nfu.drug.pojo.DrugProblemInfo;
import com.nfu.drug.service.DrugProblemInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 问题药品表 服务实现类
 * </p>
 */
@Service
public class DrugProblemInfoServiceImpl extends ServiceImpl<DrugProblemInfoMapper, DrugProblemInfo> implements DrugProblemInfoService {

    @Resource
    private DrugProblemInfoMapper drugProblemInfoMapper;


    @Resource
    private DrugInInfoMapper drugInInfoMapper;


    /**
     * @param pageNum
     * @param pageSize
     * @param param
     * @Description: 分页查询问题药品信息
     */
    @Override
    public IPage<DrugProblemInfo> selectDrugProblemInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugProblemInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("dname", param);
        }
        Page<DrugProblemInfo> page = new Page<>(pageNum,pageSize);
        return drugProblemInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @param drugProblemInfo
     * @Description: 新增一条问题药品信息, 同时会减少药品的库存。
     */
    @Override
    public int addDrugProblemInfo(DrugProblemInfo drugProblemInfo) {
        //查询药品库存
        int drugcount = drugInInfoMapper.selectDrugCountByDruginnum(drugProblemInfo.getDruginnum());
        int i = 0;
        int j = 0;
        int insert = 0;
        if (drugcount >= drugProblemInfo.getDcount()) {
            DrugInInfo drugInInfo = new DrugInInfo();
            drugInInfo.setDruginnum(drugProblemInfo.getDruginnum());
            drugInInfo.setDrugcount(drugProblemInfo.getDcount());
            i = drugInInfoMapper.updateDrugCountByDruginnum(drugInInfo);
            j = drugInInfoMapper.updateDrugRetuenByDruginnum(drugInInfo);
            insert = drugProblemInfoMapper.insert(drugProblemInfo);
        }
        int flag = 0;
        if (i == 1 && insert == 1) {
            flag = 1;
        }
        return flag;
    }

    /**
     * @param drugProblemInfo
     * @Description: 编辑修改一条问题药品信息
     */
    @Override
    public int editDrugProblemInfo(DrugProblemInfo drugProblemInfo) {
        return drugProblemInfoMapper.updateById(drugProblemInfo);
    }

    /**
     * @param id
     * @Description: 根据id来查询问题药品的信息
     */
    @Override
    public DrugProblemInfo queryDrugProblemInfoById(int id) {
        return drugProblemInfoMapper.selectById(id);
    }

    /**
     * @param id
     * @Description: 根据id来删除问题药品的信息
     */
    @Override
    public int deleteDrugProblemInfoByID(int id) {
        return drugProblemInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的问题药品信息
     */
    @Override
    public List<DrugProblemInfo> queryDrugProblemInfoList() {
        return drugProblemInfoMapper.selectList(null);
    }

    @Override
    public int updateDrugProblemInfoBydrugInNum(String drugInNum, Date createTime) {
        return drugProblemInfoMapper.updateDrugProblemInfoBydrugInNum(drugInNum, createTime);
    }


}
