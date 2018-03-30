package com.memuli.oysterhutweb.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.memuli.oysterhutweb.constant.ResultCode;
import com.memuli.oysterhutweb.entity.HutComment;
import com.memuli.oysterhutweb.util.RespData;
import com.memuli.oysterhutweb.util.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CommentController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    //分页查询留言列表
    @GetMapping("/comment/getCommentList")
    public RespData getCommentList(@RequestParam (value = "current",defaultValue = "1")Integer current, @RequestParam (value = "size",defaultValue = "10")Integer size,HttpServletRequest request) {
        LOGGER.info("CommentController.getCommentList (分页查询评论列表) Request Parameters:+{'current':" + current + ",'size':" + size + "}");
        RespData respData = new RespData();
        try {
            Page<HutComment> page = new Page<HutComment>(current, size);
            EntityWrapper<HutComment> wrapper = new EntityWrapper<HutComment>();
            wrapper.eq("topic_id","留言");//主题ID
            wrapper.eq("topic_type","1");//主题类型1留言
            wrapper.eq("cmt_type","1");//类型1留言
            wrapper.orderBy("cmt_time", false);//评论时间降序
            page = hutCommentService.selectPage(page, wrapper);
            respData.addObject("total", page.getTotal());
            respData.addObject("rows", page.getRecords());
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (Exception e) {
            LOGGER.error("CommentController.getCommentList (分页查询评论列表) Exception", e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("CommentController.getCommentList (分页查询评论列表) Response parameter:" + respData.toJsonString());
        return respData;
    }

    //获取访问者IP地址
    private static String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (null == ip || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (null == ip || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ip || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        if (ip.length() > 128) {
            ip = ip.substring(0, 128);
        }
        return ip;
    }

//    //给我留言
//    @PostMapping("/comment/createComment")
//    public RespData modifyPwd(HttpServletRequest request) {
//        LOGGER.info("UserController.modifyPwd (修改密码) Request Parameters:开始");
//        RespData respData = new RespData();
//        try {
//            //获取当前用户信息
//            SysUser loginUser = getCurrentUser();
//            if (null == loginUser) {
//                throw new HandleException(new ResultInfo(ResultCode.CODE_005, msa.getMessage(ResultCode.CODE_005)));
//            }
//            String name = loginUser.getNickname();
//            String oldPwd = request.getParameter("oldPwd");
//            String newPwd = request.getParameter("newPwd");
//            String newPaw = newPwd + name;
//            String newPawMD5 = MyMD5.md5Sign(MyMD5.md5Sign(newPaw));//规则md5(md5(password+name))
//            checkPWD(loginUser, oldPwd, newPwd, newPawMD5);
//
//            SysUser user = new SysUser();
//            user.setPswd(newPawMD5);
//            EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
//            wrapper.eq("nickname", name);
//            wrapper.eq("status", 1);
//            boolean result = sysUserService.update(user, wrapper);
//            if(!result){
//                throw new HandleException(new ResultInfo(ResultCode.CODE_012, msa.getMessage(ResultCode.CODE_012,"密码")));
//            }
//            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
//        } catch (HandleException hle) {
//            LOGGER.error("UserController.modifyPwd (修改密码) HandleException", hle);
//            respData.setResultInfo(hle.getResultInfo());
//        } catch (Exception e) {
//            LOGGER.error("UserController.modifyPwd (修改密码) Exception", e);
//            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
//        }
//        LOGGER.info("UserController.modifyPwd (修改密码) Response parameter:结束");
//        return respData;
//    }

    /*//客服回复评论
    @PostMapping("/comment/replayComment")
    public RespData replayComment(HttpServletRequest request){
        LOGGER.info("CommentController.replayComment (客服回复评论) Request Parameters:");
        RespData respData = new RespData();
        try {
            //获取当前用户信息
            SysUser loginUser = getCurrentUser();
            if (null == loginUser) {
                throw new HandleException(new ResultInfo(ResultCode.CODE_005, msa.getMessage(ResultCode.CODE_005)));
            }
            HutComment hutComment = new HutComment();
            String id = request.getParameter("id");
            if(StringUtils.isBlank(id)){
                throw new HandleException(new ResultInfo(ResultCode.CODE_010, msa.getMessage(ResultCode.CODE_010,"id")));
            }
            String serviceContent = request.getParameter("serviceContent");
            if(StringUtils.isBlank(serviceContent)){
                throw new HandleException(new ResultInfo(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001,"客服回复内容")));
            }
            hutComment.setId(Integer.parseInt(id));
            hutComment.setServiceContent(serviceContent);
            hutComment.setServiceState("8");//8已回复
            hutComment.setServiceTime(new Date());//回复时间
            EntityWrapper<HutComment> wrapper = new EntityWrapper<HutComment>();
            wrapper.eq("id",id);
            wrapper.eq("service_state","7");//7未回复
            boolean result =hutCommentService.update(hutComment,wrapper);
            if(!result){
                throw new HandleException(new ResultInfo(ResultCode.CODE_012, msa.getMessage(ResultCode.CODE_012,"评论")));
            }
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (HandleException hle) {
            LOGGER.error("CommentController.replayComment (客服回复评论) HandleException",hle);
            respData.setResultInfo(hle.getResultInfo());
        } catch (Exception e) {
            LOGGER.error("CommentController.replayComment (客服回复评论) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("CommentController.replayComment (客服回复评论) Response parameter:" + respData.toJsonString());
        return respData;
    }*/

    /*//删除评论
    @PostMapping("/comment/delComment")
    public RespData delComment(HttpServletRequest request){
        LOGGER.info("CommentController.delComment (删除评论) Request Parameters:");
        RespData respData = new RespData();
        try {
            //获取当前用户信息
            SysUser loginUser = getCurrentUser();
            if (null == loginUser) {
                throw new HandleException(new ResultInfo(ResultCode.CODE_005, msa.getMessage(ResultCode.CODE_005)));
            }
            HutComment hutComment = new HutComment();
            String id = request.getParameter("id");
            if(StringUtils.isBlank(id)){
                throw new HandleException(new ResultInfo(ResultCode.CODE_010, msa.getMessage(ResultCode.CODE_010,"id")));
            }
            hutComment.setState("9");//9删除
            hutComment.setDelTime(new Date());
            hutComment.setDelBy(loginUser.getNickname());
            EntityWrapper<HutComment> wrapper = new EntityWrapper<HutComment>();
            wrapper.eq("id",id);
            wrapper.eq("state","8");//8通过
            boolean result = hutCommentService.update(hutComment,wrapper);
            if(!result){
                throw new HandleException(new ResultInfo(ResultCode.CODE_013, msa.getMessage(ResultCode.CODE_013,"评论")));
            }
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (HandleException hle) {
            LOGGER.error("CommentController.delComment (删除评论) HandleException",hle);
            respData.setResultInfo(hle.getResultInfo());
        } catch (Exception e) {
            LOGGER.error("CommentController.delComment (删除评论) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("CommentController.delComment (删除评论) Response parameter:" + respData.toJsonString());
        return respData;
    }*/
}
