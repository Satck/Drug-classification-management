package com.nfu.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.pojo.DrugInInfo;
import com.nfu.drug.service.DrugInInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/drugInInfo")
public class DrugInInfoController {

    @Autowired
    private DrugInInfoService drugininfoService;


    /**
     * @Description: 转向药品进货记录页面
     */
    @RequestMapping
    public String drugInInfo() {

        return "/drugInInfo";
    }


    /**
     * @Description: 转向分页查询药品进货记录页面
     */
    @RequestMapping("/drugInInfoQueryPage")
    @ResponseBody
    public Object drugInInfoQueryPage(String param, @RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "limit", defaultValue = "10") int pageSize) {
        try {
            IPage<DrugInInfo> iPage = drugininfoService.selectDrugInInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品进货记录新增页面
     */
    //@RequestMapping("/drugInInfoPage")
    //public String drugInInfoPage() {
    //
    //    return "/drugInInfoPage";
    //}


    /**
     * @Description: 转向药品进货记录添加页面
     */
    @RequestMapping("/drugInInfoAdd")
    @ResponseBody
    public Object drugInInfoAdd(DrugInInfo drugininfo) {
        try {
            int i = drugininfoService.addDrugInInfo(drugininfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向药品进货记录编辑页面
     */
//    @RequestMapping("/drugInInfoQueryById")
//    public String drugInInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
//        DrugInInfo druginfo = drugininfoService.queryDrugInInfoById(id);
//        model.addAttribute("obj", druginfo);
//        return "/drugInInfoPage";
//    }


    /**
     * @Description: 修改一个药品进货记录
     */
    @RequestMapping("/drugInInfoEdit")
    @ResponseBody
    public Object drugInInfoEdit(DrugInInfo druginfo) {
        try {
            int i = drugininfoService.editDrugInInfo(druginfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品进货记录
     */
    @RequestMapping("/drugInInfoDelById")
    @ResponseBody
    public Object drugInInfoDelById(Integer id) {
        try {
            int i = drugininfoService.deleteDrugInInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 获取所有的药品进货记录名称
     */
    @RequestMapping("/drugInInfoList")
    @ResponseBody
    public Object drugInInfoList() {
        List<DrugInInfo> drugList = drugininfoService.queryDrugInInfoList();
        return ResultMapUtil.getHashMapList(drugList);
    }

    /**
     * @Description: 获取所有的药品进货记录的药品名字（去重）
     */
    @RequestMapping("/drugInInfoListOnly")
    @ResponseBody
    public Object drugInInfoListOnly() {
        List<DrugInInfo> drugList = drugininfoService.drugInInfoListOnly();
        return ResultMapUtil.getHashMapList(drugList);
    }

    /**
     * @Description: 获取所有的药品进货的进货编码
     */
    @RequestMapping("/drugInInfoListByDrugName")
    @ResponseBody
    public Object drugInInfoListByDrugName(String dname) {
        List<DrugInInfo> drugList = drugininfoService.drugInInfoListByDrugName(dname);
        return ResultMapUtil.getHashMapList(drugList);
    }


}

