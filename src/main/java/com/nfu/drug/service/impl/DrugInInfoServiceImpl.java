package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.DrugInInfoMapper;
import com.nfu.drug.pojo.DrugInInfo;
import com.nfu.drug.service.DrugInInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DrugInInfoServiceImpl extends ServiceImpl<DrugInInfoMapper, DrugInInfo> implements DrugInInfoService {

    @Resource
    private DrugInInfoMapper drugInInfoMapper;

    /**
     * @Description: 分页查询药品入库登记记账
     */
    @Override
    public IPage<DrugInInfo> selectDrugInInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<DrugInInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<DrugInInfo> page = new Page<>(pageNum, pageSize);
        return drugInInfoMapper.selectPage(page, queryWrapper);
    }

    /**
     * @Description: 新增一条药品入库登记记账信息
     */
    @Override
    public int addDrugInInfo(DrugInInfo drugInInfo) {
        return drugInInfoMapper.insert(drugInInfo);
    }

    /**
     * @Description: 修改一条药品入库登记记账信息
     */
    @Override
    public int editDrugInInfo(DrugInInfo drugInInfo) {
        return drugInInfoMapper.updateById(drugInInfo);
    }

    /**
     * @Description: 根据主键ID来查询一个药品入库登记记账对象
     */
    @Override
    public DrugInInfo queryDrugInInfoById(int id) {
        return drugInInfoMapper.selectById(id);
    }

    /**
     * @Description: 根据主键ID来删除一个药品入库登记记账对象
     */
    @Override
    public int deleteDrugInInfoByID(int id) {
        return drugInInfoMapper.deleteById(id);
    }

    /**
     * @Description: 查询所有药品入库登记记账的列表
     */
    @Override
    public List<DrugInInfo> queryDrugInInfoList() {
        return drugInInfoMapper.selectList(null);
    }

    /**
     * @Description: 查询药品进货表中最大的ID
     */
    @Override
    public int selectMaxID() {
        return drugInInfoMapper.selectMaxID();
    }

    /**
     * @Description: 新增药品进货表
     */
    @Override
    public int insert(DrugInInfo drugInInfo) {
        return drugInInfoMapper.insert(drugInInfo);
    }

    /**
     * @Description: 获取所有的药品进货的进货编码
     */
    @Override
    public List<DrugInInfo> drugInInfoListByDrugName(String dname) {
        return drugInInfoMapper.drugInInfoListByDrugName(dname);
    }

    /**
     * @Description: 更新药品进货单的数据通过药品单号
     */
    @Override
    public int updatebyDruginnum(DrugInInfo drugOutInfo) {
        int i = drugInInfoMapper.selectDrugCountByDruginnum(drugOutInfo.getDruginnum());
        int j = 0;
        if (i >= drugOutInfo.getDrugretuen()) {
            j = drugInInfoMapper.updatebyDruginnum(drugOutInfo);
        }
        return j;
    }

    /**
     * @Description: 根据进货编号来更新库存(减少库存)
     */
    @Override
    public int updatereduceDrugCountByDruginnum(DrugInInfo drugOutInfo) {
        return drugInInfoMapper.updateDrugCountByDruginnum(drugOutInfo);
    }

    /**
     * @Description: 根据进货编号来更新库存
     */
    @Override
    public int selectDrugCountByDruginnum(String druginnum) {
        return drugInInfoMapper.selectDrugCountByDruginnum(druginnum);
    }

    /**
     * @Description: 获取所有药品库存为零的药品
     */
    @Override
    public List<DrugInInfo> drugInInfoListByDrugCount() {
        return drugInInfoMapper.drugInInfoListByDrugCount();
    }

    /**
     * @Description: 获取所有的药品进货记录的药品名字（去重）
     */
    @Override
    public List<DrugInInfo> drugInInfoListOnly() {
        return drugInInfoMapper.drugInInfoListOnly();
    }

    /**
     * @Description: 根据进货编号来更新库存（增加）
     */
    @Override
    public int updateAddDrugCountByDruginnum(DrugInInfo drugInInfo) {
        return drugInInfoMapper.updateAddDrugCountByDruginnum(drugInInfo);
    }

}
