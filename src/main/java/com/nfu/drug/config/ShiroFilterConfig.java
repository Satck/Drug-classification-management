package com.nfu.drug.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
* @Description: 权限控制shiro配置类
*/
@Configuration
public class ShiroFilterConfig {

    /**
    * @Description: 创建过滤工程bean
    */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //加入shiro内置过滤器，实现权限相关的拦截器
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/static/**", "anon");//anon,无须登录即可访问；authc,需登录才可以访问。
        filterMap.put("/login", "anon");
        filterMap.put("/toLogin", "anon");
        filterMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //不登录自动转向的页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录后自动转向的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        return shiroFilterFactoryBean;
    }

    /**
    * @Description: 权限管理
    */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }
    /**
    * @Description: 创建realm，认证用
    */
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
    * @Description: thymeleaf整合shiro
    */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }



}
