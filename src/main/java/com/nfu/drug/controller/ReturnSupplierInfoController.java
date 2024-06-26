package com.nfu.drug.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.pojo.DrugInInfo;
import com.nfu.drug.pojo.DrugInfo;
import com.nfu.drug.pojo.ReturnSupplierInfo;
import com.nfu.drug.service.DrugInInfoService;
import com.nfu.drug.service.DrugInfoService;
import com.nfu.drug.service.ReturnSupplierInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 退回给供应商表 前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/returnSupplierInfo")
public class ReturnSupplierInfoController {

    @Autowired
    private ReturnSupplierInfoService returnSupplierInfoService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Autowired
    private DrugInInfoService drugInInfoService;


    /**
     * @Description: 转向药品退货给供应商信息页面
     */
    @RequestMapping
    public String returnSupplierInfo() {
        return "/returnSupplierInfo";
    }


    /**
     * @Description: 转向分页查询药品退货给供应商信息页面
     */
    @RequestMapping("/returnSupplierInfoQueryPage")
    @ResponseBody
    public Object returnSupplierInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<ReturnSupplierInfo> iPage = returnSupplierInfoService.selectReturnSupplierInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品退货给供应商信息新增页面
     */
    @RequestMapping("/returnSupplierInfoPage")
    public String returnSupplierInfoPage() {

        return "/returnSupplierInfoPage";
    }


    /**
     * @Description: 转向药品退货给供应商信息添加页面
     */
    @RequestMapping("/returnSupplierInfoAdd")
    @ResponseBody
    public Object returnSupplierInfoAdd(ReturnSupplierInfo returnSupplierInfo) {
        try {
            System.out.println(returnSupplierInfo);
            DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(returnSupplierInfo.getDname());
            returnSupplierInfo.setSupplierName(drugInfo.getSupplier());
            int i = returnSupplierInfoService.addReturnSupplierInfo(returnSupplierInfo);
            DrugInInfo drugOutInfo = new DrugInInfo();
            drugOutInfo.setName(returnSupplierInfo.getDname());
            drugOutInfo.setSupplier(returnSupplierInfo.getSupplierName());
            drugOutInfo.setWarranty(drugInfo.getWarrenty());
            drugOutInfo.setDruginnum(returnSupplierInfo.getDruginnum());
            drugOutInfo.setDrugretuen(returnSupplierInfo.getDcount());
            drugOutInfo.setDrugoutprice(returnSupplierInfo.getDcount() * drugInfo.getPrice());
            drugOutInfo.setOuttime(returnSupplierInfo.getCreateTime());
            int j = drugInInfoService.updatebyDruginnum(drugOutInfo);
            //更新药品信息里面的库存
            int l = drugInfoService.updateReduceStock(returnSupplierInfo.getDcount(), returnSupplierInfo.getDname());
            if (l == 0) {
                return ResultMapUtil.getFailUpdateDrugInfo();
            }
            int k = 0;
            if (i == 1 && j == 1) {
                k = 1;
            }
            return ResultMapUtil.returnSupplierResultMap(k);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向药品退货给供应商信息编辑页面
     */
    @RequestMapping("/returnSupplierInfoQueryById")
    public String returnSupplierInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        ReturnSupplierInfo returnSupplierInfo = returnSupplierInfoService.queryReturnSupplierInfoById(id);
        model.addAttribute("obj",returnSupplierInfo);
        return "/returnSupplierInfoPage";
    }


    /**
     * @Description: 修改一个药品退货给供应商信息
     */
    @RequestMapping("/returnSupplierInfoEdit")
    @ResponseBody
    public Object returnSupplierInfoEdit(ReturnSupplierInfo returnSupplierInfo) {
        try {
            int i = returnSupplierInfoService.editReturnSupplierInfo(returnSupplierInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个药品退货给供应商信息
     */
    @RequestMapping("/returnSupplierInfoDelById")
    @ResponseBody
    public Object returnSupplierInfoDelById(Integer id){
        try {
            int i = returnSupplierInfoService.deleteReturnSupplierInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}

