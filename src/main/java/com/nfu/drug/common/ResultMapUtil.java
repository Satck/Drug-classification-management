package com.nfu.drug.common;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: 给前端返回json

 */

public class ResultMapUtil {

    /**
     * @Description: 登录返回结果

     */
    public static HashMap<String, Object> getHashMapLogin(String msg, String code) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", msg);
        resultMap.put("code", code);
        if ("1".equals(code)) {
            resultMap.put("icon", 1);
        } else {
            resultMap.put("icon", 3);
        }
        resultMap.put("anim", 4);
        return resultMap;
    }

    /**
    * @Description: 分页查询结果
    */
    public static HashMap<String, Object> getHashMapMysqlPage(IPage<?> Object) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", Object.getTotal());
        resultMap.put("data", Object.getRecords());
        return resultMap;
    }

    /**
    * @Description: 异常数据统一处理
     */
    public static HashMap<String, Object> getHashMapException(Exception e) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        resultMap.put("msg", e.getMessage());
        return resultMap;
    }

    /**
     * @Description: 出库时新增药品在售信息失败
     */
    public static HashMap<String, Object> getUpdateInSellFail() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "新增药品在售信息失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 出库时更新药品库存信息失败
     */
    public static HashMap<String, Object> getUpdateStockFail() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "更新药品库存信息失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 出库时库存不够抛出错误
     */
    public static HashMap<String, Object> getStockLess() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "保存失败,库存不够！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 插入药品进货单失败
     */
    public static HashMap<String, Object> getFailInsertDrugInInfo() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "保存失败,更新药品库存信息单失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 插入药品进货单失败
     */
    public static HashMap<String, Object> getFailInsertOutOrIn() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "保存失败,更新药品出库信息单失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 插入药品进货单失败
     */
    public static HashMap<String, Object> getFailInsertDrugInfo() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "保存失败,更新药品信息单失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 更新药品退货信息失败（减少）

     */
    public static HashMap<String, Object> getFailInsertReturnSupplier() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "保存失败,更新药品退货信息失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 当已退货药品继续点击退货
     */
    public static HashMap<String, Object> getisReturnSupplier() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "此药品已经退货！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 当已退货药品继续点击退货
     */
    public static HashMap<String, Object> getReturnSupplierSuccess(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 1) {
            resultMap.put("msg", "药品退货成功！");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        } else {
            resultMap.put("msg", "药品退货失败！");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        }
        return resultMap;
    }

    /**
     * @Description: 更新药品信息库存失败（减少）

     */
    public static HashMap<String, Object> getFailUpdateDrugInfo() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "保存失败,更新药品信息库存失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 更新药品在售信息库存失败
     */
    public static HashMap<String, Object> getFailUpdateInSell() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "更新药品在售信息库存失败！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 更新药品在售信息库存失败（销售）
     */
    public static HashMap<String, Object> getFailUpdateInSellForCount() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "销出数量不得大于在售数量！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 更新药品在售信息库存失败（销售）

     */
    public static HashMap<String, Object> getFailUpdateReturnForCount() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", "退货数量不得大于售出数量！");
        resultMap.put("code", 1);
        resultMap.put("icon", 5);
        resultMap.put("anim", 6);
        return resultMap;
    }

    /**
     * @Description: 判断是否新增保存成功药品信息

     */
    public static HashMap<String, Object> insertDrugInfo(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 0) {
            resultMap.put("msg", "保存失败,可能是药品信息中已存在此药品");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        } else {
            resultMap.put("msg", "保存成功");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        }
        return resultMap;
    }


    /**
     * @Description: 保存成功统一返回格式

     */
    public static HashMap<String, Object> getHashMapSave(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 0) {
            resultMap.put("msg", "保存失败");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        }else {
            resultMap.put("msg", "保存成功");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        }
        return resultMap;
    }

    /**
     * @Description: 删除成功统一返回格式

     */
    public static HashMap<String, Object> getHashMapDel(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 0) {
            resultMap.put("msg", "删除失败");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        }else {
            resultMap.put("msg", "删除成功");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        }
        return resultMap;
    }

    /**
    * @Description: 查询list统一返回格式

    */
    public static HashMap<String, Object> getHashMapList(List<?> list) {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", 0);
        if (list != null && list.size() > 0) {
            resultMap.put("msg", "");

        } else {
            resultMap.put("msg", "没有查询到数据");
        }
        resultMap.put("data", list);
        return resultMap;
    }

    /**
     * @Description: 保存药品退货登记记录
     */
    public static HashMap<String, Object> returnDrugSave(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 0) {
            resultMap.put("msg", "保存失败，可能是药品问题数量大于库存");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        } else {
            resultMap.put("msg", "保存成功");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        }
        return resultMap;
    }

    /**
     * @Description: 保存成功统一返回格式
     */
    public static HashMap<String, Object> returnSupplierResultMap(int i) {
        HashMap<String, Object> resultMap = new HashMap<>();
        if (i == 0) {
            resultMap.put("msg", "保存失败,退货数量大于药品库存");
            resultMap.put("code", 1);
            resultMap.put("icon", 5);
            resultMap.put("anim", 6);
        } else {
            resultMap.put("msg", "保存成功");
            resultMap.put("code", 0);
            resultMap.put("icon", 1);
            resultMap.put("anim", 4);
        }
        return resultMap;
    }


}
