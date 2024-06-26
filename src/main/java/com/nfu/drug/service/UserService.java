package com.nfu.drug.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nfu.drug.pojo.User;
import com.nfu.drug.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface UserService extends IService<User> {

    User queryUserByUserName(User user);

    String selectUser();

    void updateStatus(String username);

    void clean();

    String inSellDrug();

    String stockNum();

    String inSellDrugType();

    String allProblemDrugNum();

    String allReturnDrugNum();

    String drugAllNum();



    /**
     * @Description: 分页查询用户信息
     */
    IPage<User> selectUserPage(int pageNum, int pageSize, String param);

    /**
     * @Description: 新增一条用户信息
     */
    int addUser(User User);

    /**
     * @Description: 编辑修改一条用户信息
     */
    int editUser(User User);

    /**
     * @Description: 根据id来查询用户的信息
     */
    User queryUserById(int id);

    /**
     * @Description: 根据id来删除用户的信息
     */
    int deleteUserByID(int id);

    /**
     * @Description: 获取所有的用户信息
     */
    List<User> queryUserList();

    /**
     * @Description: 根据供应商名字查询药品信息
     */
    List<User> queryUserListByUserName(String sname);
}
