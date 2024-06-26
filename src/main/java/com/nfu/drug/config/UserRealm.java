package com.nfu.drug.config;

import com.nfu.drug.pojo.User;
import com.nfu.drug.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @Description: 权限认证
*/
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
    * @Description: 登录认证
    */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User queryUser = new User();
        queryUser.setUserName(username);
        //根据用户名查询用户是否存在
        User user = userService.queryUserByUserName(queryUser);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
