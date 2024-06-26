package com.nfu.drug.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.common.OrderCoderUtil;
import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.pojo.BillInfo;
import com.nfu.drug.pojo.DrugInInfo;
import com.nfu.drug.pojo.DrugInfo;
import com.nfu.drug.pojo.OutOrInInfo;
import com.nfu.drug.service.BillInfoService;
import com.nfu.drug.service.DrugInInfoService;
import com.nfu.drug.service.DrugInfoService;
import com.nfu.drug.service.OutOrInInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/billInfo")
public class BillInfoController {
    @Autowired
    private BillInfoService billInfoService;

    @Autowired
    private DrugInfoService drugInfoService;

    @Autowired
    private DrugInInfoService drugInInfoService;

    @Autowired
    private OutOrInInfoService outOrInInfoService;

    /**
     * @Description: 转向账单信息页面
     */
    @RequestMapping
    public String billInfo() {
        return "/billInfo";
    }


    /**
     * @Description: 转向分页查询账单信息页面
     */
    @RequestMapping("/billInfoQueryPage")
    @ResponseBody
    public Object billInfoQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<BillInfo> iPage = billInfoService.selectBillInfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 转向账单信息新增页面
     */
    @RequestMapping("/billInfoPage")
    public String billInfoPage() {

        return "/billInfoPage";
    }


    /**
     * @Description: 转向药品进货信息添加页面
     */
    @RequestMapping("/billInfoAdd")
    @ResponseBody
    public Object billInfoAdd(BillInfo billInfo) {
        try {
            //获取药的信息
            DrugInfo drugInfo = drugInfoService.selectDrugInfoByDname(billInfo.getDname());
            //获取药品进货信息中最大的id
            int id = drugInInfoService.selectMaxID();
            //添加账单并同时更新药品库存信息
            DrugInInfo drugInInfo = new DrugInInfo();
            drugInInfo.setName(drugInfo.getName());
            drugInInfo.setSupplier(drugInfo.getSupplier());
            drugInInfo.setWarranty(drugInfo.getWarrenty());
            drugInInfo.setDruginnum(OrderCoderUtil.getOrderCode((long) id));
            drugInInfo.setDruginprice(billInfo.getCount() * billInfo.getTotal());
            drugInInfo.setDrugcount(billInfo.getCount());
            drugInInfo.setIntime(billInfo.getBuyTime());
            int insert = drugInInfoService.insert(drugInInfo);
            billInfo.setDruginnum(drugInInfo.getDruginnum());
            billInfo.setSname(drugInfo.getSupplier());
            billInfo.setTotal(drugInInfo.getDruginprice());
            //更新药品库存信息并同时更新药品信息的库存
            int i1 = drugInfoService.updateAddStock(drugInInfo.getDrugcount(), drugInfo.getName());
            if (i1 == 0) {
                return ResultMapUtil.getFailInsertDrugInfo();
            }
            if (insert == 0) {
                return ResultMapUtil.getFailInsertDrugInInfo();
            }
            //插入药品入库信息
            OutOrInInfo outOrInInfo = new OutOrInInfo();
            outOrInInfo.setDname(drugInfo.getName());
            outOrInInfo.setType("从供应商进货：入库");
            outOrInInfo.setCount(billInfo.getCount());
            outOrInInfo.setOperator("谢炜程");
            outOrInInfo.setCreateTime(billInfo.getBuyTime());
            outOrInInfo.setDruginnum(drugInInfo.getDruginnum());
            int i2 = outOrInInfoService.addOutOrInInfo(outOrInInfo);
            if (i2 == 0) {
                return ResultMapUtil.getFailInsertOutOrIn();
            }
            int i = billInfoService.addBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultMapUtil.getHashMapException(e);

        }

    }


    /**
     * @Description: 转向账单信息编辑页面
     */
    @RequestMapping("/billInfoQueryById")
    public String billInfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        BillInfo billInfo = billInfoService.queryBillInfoById(id);
        model.addAttribute("obj",billInfo);
        return "/billInfoPage";
    }


    /**
     * @Description: 修改一个药品进货信息
     */
    @RequestMapping("/billInfoEdit")
    @ResponseBody
    public Object billInfoEdit(BillInfo billInfo) {
        try {
            int i = billInfoService.editBillInfo(billInfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 删除一个账单信息
     */
    @RequestMapping("/billInfoDelById")
    @ResponseBody
    public Object billInfoDelById(Integer id) {
        try {
            int i = billInfoService.deleteBillInfoByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
     * @Description: 获取所有的药品名称
     */
    @RequestMapping("/billInfoList")
    @ResponseBody
    public Object drugInfoList(String sname) {
        List<BillInfo> billInfoList = billInfoService.queryDrugInfoListBySName(sname);
        return ResultMapUtil.getHashMapList(billInfoList);
    }


}

