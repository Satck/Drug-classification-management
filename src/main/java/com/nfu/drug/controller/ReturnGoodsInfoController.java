package com.nfu.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.pojo.DrugInfo;
import com.nfu.drug.pojo.InsellDrugInfo;
import com.nfu.drug.pojo.ReturnGoodsInfo;
import com.nfu.drug.service.DrugInfoService;
import com.nfu.drug.service.InsellDrugInfoService;
import com.nfu.drug.service.ReturnGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 * 收到退货表 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/returnGoodsInfo")
public class ReturnGoodsInfoController {

    @Autowired
    private ReturnGoodsInfoService returnGoodsInfoService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Autowired
    private InsellDrugInfoService insellDrugInfoService;


    /**
     * @Description: 转向药品退货信息页面
     */
    @RequestMapping
    public String returnGoodsInfo() {
        return "/returnGoodsInfo";
    }


    /**
     * @Description: 转向分页查询药品退货信息页面
     */
    @RequestMapping("/returnGoodsInfoQueryPage")
    @ResponseBody
    public Object returnGoodsInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<ReturnGoodsInfo> iPage = returnGoodsInfoService.selectReturnGoodsInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品退货信息新增页面
     */
    @RequestMapping("/returnGoodsInfoPage")
    public String returnGoodsInfoPage() {

        return "/returnGoodsInfoPage";
    }


    /**
     * @Description: 转向药品退货信息添加页面
     */
    @RequestMapping("/returnGoodsInfoAdd")
    @ResponseBody
    public Object returnGoodsInfoAdd(ReturnGoodsInfo returnGoodsInfo) {
        try {
            DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(returnGoodsInfo.getDname());
            returnGoodsInfo.setTotal(returnGoodsInfo.getCount() * drugInfo.getPrice());
            returnGoodsInfo.setOperateTime(new Date());
            //更新药品在售信息表的库存
            InsellDrugInfo insellDrugInfo1 = insellDrugInfoService.selectDrugCountByDruginnum(returnGoodsInfo.getInnum());
            if (insellDrugInfo1.getSellnum() < returnGoodsInfo.getCount()) {
                return ResultMapUtil.getFailUpdateReturnForCount();
            }
            InsellDrugInfo insellDrugInfo = new InsellDrugInfo();
            insellDrugInfo.setSellcount(returnGoodsInfo.getCount());
            insellDrugInfo.setReturnnum(returnGoodsInfo.getCount());
            insellDrugInfo.setInprice(returnGoodsInfo.getTotal());
            insellDrugInfo.setInnum(returnGoodsInfo.getInnum());
            int i1 = insellDrugInfoService.updatebyDruginnumReduce(insellDrugInfo);
            if (i1 == 0) {
                return ResultMapUtil.getFailUpdateInSell();
            }
            int i = returnGoodsInfoService.addReturnGoodsInfo(returnGoodsInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向药品退货信息编辑页面
     */
    @RequestMapping("/returnGoodsInfoQueryById")
    public String returnGoodsInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        ReturnGoodsInfo returnGoodsInfo = returnGoodsInfoService.queryReturnGoodsInfoById(id);
        model.addAttribute("obj",returnGoodsInfo);
        return "/returnGoodsInfoPage";
    }


    /**
     * @Description: 修改一个药品退货信息
     */
    @RequestMapping("/returnGoodsInfoEdit")
    @ResponseBody
    public Object returnGoodsInfoEdit(ReturnGoodsInfo returnGoodsInfo) {
        try {
            int i = returnGoodsInfoService.editReturnGoodsInfo(returnGoodsInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品退货信息
     */
    @RequestMapping("/returnGoodsInfoDelById")
    @ResponseBody
    public Object returnGoodsInfoDelById(Integer id){
        try {
            int i = returnGoodsInfoService.deleteReturnGoodsInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}

