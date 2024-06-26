package com.nfu.drug.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.pojo.BillInfo;
import com.nfu.drug.pojo.Supplier;
import com.nfu.drug.pojo.User;
import com.nfu.drug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserManagementController {
    @Autowired
    private UserService userService;

    //转向
    @RequestMapping
    public String User(){
        return "/User";
    }

    //分页查询
    @RequestMapping("/userQueryPage")
    @ResponseBody
    public Object userQueryPage(String param, @RequestParam(value = "page",defaultValue = "1") int pageNum, @RequestParam(value = "limit",defaultValue = "10") int pageSize) {
        try {
            IPage<User> iPage = userService.selectUserPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    //转向新增页
    @RequestMapping("userPage")
    public Object userPage(){
        return "/UserPage";
    }

    //转向添加页
    @RequestMapping("/userAdd")
    @ResponseBody
    public Object userAdd(User user) {
        try {
            int i = userService.addUser(user);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }

    }

    //转向编辑
    @RequestMapping("/userQueryById")
    public String userQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        User user = userService.queryUserById(id);
        model.addAttribute("obj", user);
        return "/UserPage";
    }

    //修改一个
    @RequestMapping("/userEdit")
    @ResponseBody
    public Object userEdit(User user) {
        try {
            int i = userService.editUser(user);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    //删除
    @RequestMapping("/userDelById")
    @ResponseBody
    public Object userDelById(Integer id){
        try {
            int i = userService.deleteUserByID(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    //获取名称
    @RequestMapping("/userList")
    @ResponseBody
    public Object userList() {
        List<User> users = userService.queryUserList();
        return ResultMapUtil.getHashMapList(users);
    }
}
