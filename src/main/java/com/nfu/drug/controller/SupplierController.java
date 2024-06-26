package com.nfu.drug.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.pojo.Supplier;
import com.nfu.drug.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;


    /**
     * @Description: 转向供应商页面
     */
    @RequestMapping
    public String supplier() {
        return "/supplier";
    }


    /**
     * @Description: 转向分页查询供应商页面
     */
    @RequestMapping("/supplierQueryPage")
    @ResponseBody
    public Object supplierQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");



        try {
            IPage<Supplier> iPage = supplierService.selectSupplierPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }


    }


    /**
     * @Description: 转向供应商新增页面
     */
    @RequestMapping("/supplierPage")
    public String supplierPage() {

        return "/supplierPage";
    }


    /**
     * @Description: 转向供应商添加页面
     */
    @RequestMapping("/supplierAdd")
    @ResponseBody
    public Object supplierAdd(Supplier supplier) {
        try {
            supplier.setCreateTime(new Date());
            int i = supplierService.addSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }


    /**
     * @Description: 转向供应商编辑页面
     */
    @RequestMapping("/supplierQueryById")
    public String supplierQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Supplier supplier = supplierService.querySupplierById(id);
        model.addAttribute("obj", supplier);
        return "/supplierPage";
    }


    /**
     * @Description: 修改一个供应商
     */
    @RequestMapping("/supplierEdit")
    @ResponseBody
    public Object supplierEdit(Supplier supplier) {
        try {
            int i = supplierService.editSupplier(supplier);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
    * @Description: 删除供应商
    */
    @RequestMapping("/supplierDelById")
    @ResponseBody
    public Object supplierDelById(Integer id){
        try {
            int i = supplierService.deleteSupplierByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }


    /**
    * @Description: 获取所有的厂商名称
    */
    @RequestMapping("/supplierList")
    @ResponseBody
    public Object supplierList() {
        List<Supplier> supplierList = supplierService.querySupplierList();
        return ResultMapUtil.getHashMapList(supplierList);
    }
}

