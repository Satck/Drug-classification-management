package com.nfu.drug.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.pojo.DrugInInfo;
import com.nfu.drug.pojo.DrugInfo;
import com.nfu.drug.pojo.InsellDrugInfo;
import com.nfu.drug.pojo.OutOrInInfo;
import com.nfu.drug.service.DrugInInfoService;
import com.nfu.drug.service.DrugInfoService;
import com.nfu.drug.service.InsellDrugInfoService;
import com.nfu.drug.service.OutOrInInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 * 出库 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/outOrInInfo")
public class OutOrInInfoController {

    @Autowired
    private OutOrInInfoService outorininfoService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Autowired
    private DrugInInfoService drugInInfoService;

    @Autowired
    private InsellDrugInfoService insellDrugInfoService;

    /**
     * @Description: 转向药品出库页面
     */
    @RequestMapping
    public String outOrInInfo() {
        return "/outOrInInfo";
    }


    /**
     * @Description: 转向分页查询药品出库页面
     */
    @RequestMapping("/outOrInInfoQueryPage")
    @ResponseBody
    public Object outOrInInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<OutOrInInfo> iPage = outorininfoService.selectOutOrInInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品出库新增页面
     */
    @RequestMapping("/outOrInInfoPage")
    public String outOrInInfoPage() {

        return "/outOrInInfoPage";
    }


    /**
     * @Description: 转向药品出库添加页面
     */
    @RequestMapping("/outOrInInfoAdd")
    @ResponseBody
    public Object outOrInInfoAdd(OutOrInInfo outorininfo) {
        try {
            if (outorininfo.getType().equals("入库")) {
                //更新药品信息里面的库存
                outorininfo.setType("非供应商进货：入库");
                drugInfoService.updateAddStock(outorininfo.getCount(), outorininfo.getDname());
                //增加药品库存里的数量
                DrugInInfo drugInInfo = new DrugInInfo();
                drugInInfo.setDruginnum(outorininfo.getDruginnum());
                drugInInfo.setDrugcount(outorininfo.getCount());
                int i = drugInInfoService.updateAddDrugCountByDruginnum(drugInInfo);
                if (i == 0) {
                    return ResultMapUtil.getUpdateStockFail();
                }
            } else if (outorininfo.getType().equals("出库")) {
                //检查药品信息里面的库存，如果库存小于出库数量，则这一单无法输出。
                int stock = drugInInfoService.selectDrugCountByDruginnum(outorininfo.getDruginnum());
                if (stock < outorininfo.getCount()) {
                    return ResultMapUtil.getStockLess();
                }
                outorininfo.setType("发出药品销售：出库");
                //减少药品库存里的数量
                DrugInInfo drugInInfo = new DrugInInfo();
                drugInInfo.setDruginnum(outorininfo.getDruginnum());
                drugInInfo.setDrugcount(outorininfo.getCount());
                int i = drugInInfoService.updatereduceDrugCountByDruginnum(drugInInfo);
                if (i == 0) {
                    return ResultMapUtil.getUpdateStockFail();
                }
                DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(outorininfo.getDname());
                //新增药品在售信息表,如果此前已经出库过当前批号的药品，则更新药品在售信息表
                InsellDrugInfo insellDrugInfo = new InsellDrugInfo();
                InsellDrugInfo insellDrugInfo1 = insellDrugInfoService.selectDrugCountByDruginnum(outorininfo.getDruginnum());
                insellDrugInfo.setDname(outorininfo.getDname());
                insellDrugInfo.setInnum(outorininfo.getDruginnum());
                insellDrugInfo.setSellcount(outorininfo.getCount());
                insellDrugInfo.setWarranty(Integer.valueOf(drugInfo.getWarrenty()));
                insellDrugInfo.setPtime(new Date());
                if (insellDrugInfo1 != null) {
                    //如果不为空，则更新在售信息表的数据
                    insellDrugInfoService.updateDrugCountByDruginnum(insellDrugInfo);
                } else {
                    //如果为空，则插入在售信息表的数据
                    int insert = insellDrugInfoService.insert(insellDrugInfo);
                    if (insert == 0) {
                        return ResultMapUtil.getUpdateInSellFail();
                    }
                }
            }
            outorininfo.setCreateTime(new Date());
            int i = outorininfoService.addOutOrInInfo(outorininfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品出库编辑页面
     */
    @RequestMapping("/outOrInInfoQueryById")
    public String outOrInInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        OutOrInInfo outorininfo = outorininfoService.queryOutOrInInfoById(id);
        model.addAttribute("obj",outorininfo);
        return "/outOrInInfoPage";
    }


    /**
     * @Description: 修改一个药品出库
     */
    @RequestMapping("/outOrInInfoEdit")
    @ResponseBody
    public Object outOrInInfoEdit(OutOrInInfo outorininfo) {
        try {
            int i = outorininfoService.editOutOrInInfo(outorininfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品出库
     */
    @RequestMapping("/outOrInInfoDelById")
    @ResponseBody
    public Object outOrInInfoDelById(Integer id){
        try {
            int i = outorininfoService.deleteOutOrInInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

}

