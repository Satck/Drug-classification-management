package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfu.drug.mapper.BillInfoMapper;
import com.nfu.drug.pojo.BillInfo;
import com.nfu.drug.service.BillInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BillInfoServiceImpl extends ServiceImpl<BillInfoMapper, BillInfo> implements BillInfoService {

    @Resource
    private BillInfoMapper billInfoMapper;


    /**
     * @Description: 分页查询账单信息
     */
    @Override
    public IPage<BillInfo> selectBillInfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<BillInfo> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            //根据供应商名称精确查询
            queryWrapper.like("sname", param);
        }
        Page<BillInfo> page = new Page<>(pageNum,pageSize);
        return billInfoMapper.selectPage(page,queryWrapper);
    }

    /**
     * @Description: 新增一条账单信息
     */
    @Override
    public int addBillInfo(BillInfo billInfo) {
        return billInfoMapper.insert(billInfo);
    }

    /**
     * @Description: 编辑修改一条账单信息
     */
    @Override
    public int editBillInfo(BillInfo billInfo) {
        return billInfoMapper.updateById(billInfo);
    }

    /**
     * @Description: 根据id来查询账单的信息
     */
    @Override
    public BillInfo queryBillInfoById(int id) {
        return billInfoMapper.selectById(id);
    }

    /**
     * @Description: 根据id来删除账单的信息
     */
    @Override
    public int deleteBillInfoByID(int id) {
        return billInfoMapper.deleteById(id);
    }

    /**
     * @Description: 获取所有的账单信息
     */
    @Override
    public List<BillInfo> queryBillInfoList() {
        return billInfoMapper.selectList(null);
    }

    /**
     * @Description: 根据供应商名字查询药品信息
     */
    @Override
    public List<BillInfo> queryDrugInfoListBySName(String sname) {
        return billInfoMapper.queryDrugInfoListBySName(sname);
    }

    /**
     * @Description: 根据药品进货编码主键查询药品进货时进货数量
     */
    @Override
    public BillInfo selectCountByDrugInnum(String druginnum) {
        return billInfoMapper.selectCountByDrugInnum(druginnum);
    }
}
