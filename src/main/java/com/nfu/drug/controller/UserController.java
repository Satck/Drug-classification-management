package com.nfu.drug.controller;

import com.nfu.drug.common.ResultMapUtil;
import com.nfu.drug.mapper.UserMapper;
import com.nfu.drug.pojo.User;
import com.nfu.drug.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;



@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    /**
     * @Description: 转向登录页面
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }

    /**
    * @Description: 判断用户是否成功
    */
    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public Object toLogin(String username, String password,Integer type) {

        if (username == null || password == null) {
            return ResultMapUtil.getHashMapLogin("验证失败,用户名密码不准确", "2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultMapUtil.getHashMapLogin("验证失败,用户名不存在", "3");
        } catch (IncorrectCredentialsException e) {
            return ResultMapUtil.getHashMapLogin("验证失败,密码不准确", "4");
        }

        String str = userMapper.selectType(username);
        Integer i = Integer.parseInt(str);
        if (!Objects.equals(i, type)){
            return ResultMapUtil.getHashMapLogin("验证失败,用户类型错误", "5");
        }

        userService.updateStatus(username);

        return ResultMapUtil.getHashMapLogin("验证成功","1");
    }


    /**
     * @Description: 转向首页页面
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/index1")
    public String index1() {
        return "/index1";
    }

    @RequestMapping(value = "/index2")
    public String index2() {
        return "/index2";
    }
    
    /** 
    * @Description: 退出登录
    */

    @RequestMapping(value = "/logout")
    public String logout() {
        userService.clean();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }



}
