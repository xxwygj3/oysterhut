package com.memuli.oysterhutadmin.shiro;

import com.memuli.oysterhutadmin.entity.SysPermission;
import com.memuli.oysterhutadmin.entity.SysRole;
import com.memuli.oysterhutadmin.entity.SysUser;
import com.memuli.oysterhutadmin.service.SysPermissionService;
import com.memuli.oysterhutadmin.service.SysRoleService;
import com.memuli.oysterhutadmin.service.SysUserService;
import com.memuli.oysterhutadmin.util.MyDES;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

//shiro身份校验核心类
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    //认证信息.(身份验证) : Authentication 是用来验证用户身份
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("nickname", name);
        //密码进行加密处理  明文为  password+name
        String paw = password + name;
        String pawDES = MyDES.encryptBasedDes(paw);
        map.put("pswd", pawDES);
        SysUser user = null;
        // 从数据库获取对应用户名密码的用户
        List<SysUser> userList = sysUserService.selectByMap(map);
        if (userList.size() != 0) {
            user = userList.get(0);
        }
        if (null == user) {
            throw new AccountException("账号或密码不正确！");
        } else if (user.getStatus() == 0) {//如果用户的status为禁用
            //抛出DisabledAccountException
            throw new DisabledAccountException("此帐号已经设置为禁止登录！");
        } else {//登录成功
            //更新登录时间 last login time
            user.setLastLoginTime(new Date());
            sysUserService.updateById(user);
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证方法：MyShiroRealm.doGetAuthenticationInfo()");
        SysUser token = (SysUser) SecurityUtils.getSubject().getPrincipal();
        Integer userId = token.getId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", userId);
        List<SysRole> roleList = sysRoleService.selectByMap(map);
        Set<String> roleSet = new HashSet<String>();
        for(SysRole role : roleList){
            roleSet.add(role.getType());
        }
        info.setRoles(roleSet);
        //测试
//        Set<String> roleSet = new HashSet<String>();
//        roleSet.add("100002");
//        info.setRoles(roleSet);
        //根据用户ID查询权限（permission），放入到Authorization里。
        List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
        Set<String> permissionSet = new HashSet<String>();
        for(SysPermission Permission : permissionList){
            permissionSet.add(Permission.getName());
        }
        info.setStringPermissions(permissionSet);
        //测试
//        Set<String> permissionSet = new HashSet<String>();
//        permissionSet.add("权限添加");
//        info.setStringPermissions(permissionSet);
        return info;
    }
}
