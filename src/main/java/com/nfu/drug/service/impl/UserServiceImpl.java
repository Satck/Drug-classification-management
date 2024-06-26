package com.nfu.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nfu.drug.pojo.BillInfo;
import com.nfu.drug.pojo.User;
import com.nfu.drug.mapper.UserMapper;
import com.nfu.drug.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
    * @Description: 根据用户名查询用户对象
     */
    @Override
    public User queryUserByUserName(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", user.getUserName());
        return userMapper.selectOne(wrapper);
    }

    @Override
    public String selectUser() {
        return userMapper.selectUser();
    }

    @Override
    public void updateStatus(String username) {
        userMapper.updateStatus(username);
    }

    @Override
    public void clean() {
        userMapper.cleanStatus();
    }

    @Override
    public String inSellDrug() {
        return userMapper.inSellDrug();
    }

    @Override
    public String stockNum() {
        return userMapper.stockNum();
    }

    @Override
    public String inSellDrugType() {
        return userMapper.inSellDrugType();
    }

    @Override
    public String allProblemDrugNum() {
        return userMapper.allProblemDrugNum();
    }

    @Override
    public String allReturnDrugNum() {
        return userMapper.allReturnDrugNum();
    }

    @Override
    public String drugAllNum() {
        return userMapper.drugAllNum();
    }


    @Override
    public IPage<User> selectUserPage(int pageNum, int pageSize, String param) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("user_name", param);
        }
        Page<User> page = new Page<>(pageNum,pageSize);
        return userMapper.selectPage(page,queryWrapper);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int editUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int deleteUserByID(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public List<User> queryUserList() {
        return userMapper.selectList(null);
    }

    @Override
    public List<User> queryUserListByUserName(String username) {
        return userMapper.queryUserListByUsername(username);
    }
}
