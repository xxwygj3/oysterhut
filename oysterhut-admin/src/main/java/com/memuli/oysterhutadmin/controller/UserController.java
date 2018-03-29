package com.memuli.oysterhutadmin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.memuli.oysterhutadmin.constant.ResultCode;
import com.memuli.oysterhutadmin.entity.SysUser;
import com.memuli.oysterhutadmin.util.HandleException;
import com.memuli.oysterhutadmin.util.MyMD5;
import com.memuli.oysterhutadmin.util.RespData;
import com.memuli.oysterhutadmin.util.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    //修改密码
    @PostMapping("/user/modifyPwd")
    public RespData modifyPwd(HttpServletRequest request) {
        LOGGER.info("UserController.modifyPwd (修改密码) Request Parameters:开始");
        RespData respData = new RespData();
        try {
            //获取当前用户信息
            SysUser loginUser = getCurrentUser();
            if (null == loginUser) {
                throw new HandleException(new ResultInfo(ResultCode.CODE_005, msa.getMessage(ResultCode.CODE_005)));
            }
            String name = loginUser.getNickname();
            String oldPwd = request.getParameter("oldPwd");
            String newPwd = request.getParameter("newPwd");
            String newPaw = newPwd + name;
            String newPawMD5 = MyMD5.md5Sign(MyMD5.md5Sign(newPaw));//规则md5(md5(password+name))
            checkPWD(loginUser, oldPwd, newPwd, newPawMD5);

            SysUser user = new SysUser();
            user.setPswd(newPawMD5);
            EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
            wrapper.eq("nickname", name);
            wrapper.eq("status", 1);
            boolean result = sysUserService.update(user, wrapper);
            if(!result){
                throw new HandleException(new ResultInfo(ResultCode.CODE_012, msa.getMessage(ResultCode.CODE_012,"密码")));
            }
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (HandleException hle) {
            LOGGER.error("UserController.modifyPwd (修改密码) HandleException", hle);
            respData.setResultInfo(hle.getResultInfo());
        } catch (Exception e) {
            LOGGER.error("UserController.modifyPwd (修改密码) Exception", e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("UserController.modifyPwd (修改密码) Response parameter:结束");
        return respData;
    }

    private void checkPWD(SysUser loginUser, String oldPwd, String newPwd, String newPawMD5) throws Exception {
        if (StringUtils.isBlank(oldPwd)) {
            throw new HandleException(new ResultInfo(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001, "当前（登录）密码")));
        }
        if (StringUtils.isBlank(newPwd)) {
            throw new HandleException(new ResultInfo(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001, "新的密码")));
        }
        //检查密码
        //密码进行加密处理  明文为  password+name
        String oldPaw = oldPwd + loginUser.getNickname();
        String oldPawMD5 = MyMD5.md5Sign(MyMD5.md5Sign(oldPaw));//规则md5(md5(password+name))
        if (loginUser.getPswd().compareTo(oldPawMD5) != 0) {
            throw new HandleException(new ResultInfo(ResultCode.CODE_006, msa.getMessage(ResultCode.CODE_006)));
        }
        if (loginUser.getPswd().compareTo(newPawMD5) == 0) {
            throw new HandleException(new ResultInfo(ResultCode.CODE_007, msa.getMessage(ResultCode.CODE_007)));
        }
    }
}
