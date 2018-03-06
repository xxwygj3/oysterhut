package com.memuli.oysterhutadmin.config;

import com.memuli.oysterhutadmin.entity.SysPermissionInit;
import com.memuli.oysterhutadmin.service.SysPermissionInitService;
import com.memuli.oysterhutadmin.shiro.MyShiroRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//配置shiro
@Configuration
public class ShiroConfig {
    @Autowired(required = false)
    SysPermissionInitService sysPermissionInitService;
    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * <p>
     * Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403.html");
        // 拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
//        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMap.put("/login", "anon");
////        filterChainDefinitionMap.put("/ajaxLogin", "anon");
//        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
////        filterChainDefinitionMap.put("/logout", "logout");
////        filterChainDefinitionMap.put("/add", "perms[权限添加]");
        //过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 (这是一个坑呢，一不小心代码就不好使了)
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
        filterChainDefinitionMap.put("/index.html", "authc");
        //静态资源
        filterChainDefinitionMap.put("/bootstrap/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/login.html", "anon");
        filterChainDefinitionMap.put("/403.html", "anon");
        filterChainDefinitionMap.put("/getJpgCode", "anon");
        filterChainDefinitionMap.put("/loginIn", "anon");
        filterChainDefinitionMap.put("/loginOut", "anon");

//        filterChainDefinitionMap.put("/**", "anon");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        System.out.println("Shiro拦截器工厂类注入成功");
//        // 权限控制map.
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        // 从数据库获取
//        List<SysPermissionInit> list = sysPermissionInitService.selectAll();
//        for (SysPermissionInit sysPermissionInit : list) {
//            filterChainDefinitionMap.put(sysPermissionInit.getUrl(),
//                    sysPermissionInit.getPermissionInit());
//        }
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myShiroRealm());
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * 身份认证realm; (这个需要自己写，账号密码校验；权限等)
     *
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }

    /**
     * cookie对象;
     * @return
     */
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(2592000);
        return simpleCookie;
    }

    /**
     * cookie管理对象;记住我功能
     * @return
     */
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
}
