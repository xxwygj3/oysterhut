package com.memuli.oysterhutweb.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.memuli.oysterhutweb.constant.ResultCode;
import com.memuli.oysterhutweb.entity.HutComment;
import com.memuli.oysterhutweb.entity.HutCommentUser;
import com.memuli.oysterhutweb.util.HandleException;
import com.memuli.oysterhutweb.util.RespData;
import com.memuli.oysterhutweb.util.ResultInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CommentController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    //分页查询留言列表
    @GetMapping("/comment/getCommentList")
    public RespData getCommentList(@RequestParam(value = "current", defaultValue = "1") Integer current, @RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletRequest request) {
        LOGGER.info("CommentController.getCommentList (分页查询评论列表) Request Parameters:+{'current':" + current + ",'size':" + size + "}");
        RespData respData = new RespData();
        try {
            Page<HutComment> page = new Page<HutComment>(current, size);
            EntityWrapper<HutComment> wrapper = new EntityWrapper<HutComment>();
            wrapper.eq("topic_id", "给我留言");//主题ID
            wrapper.eq("cmt_type", "1");//类型1评论
            wrapper.eq("state","8");//状态8通过
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

    //给我留言
    @Transactional
    @PostMapping("/comment/createComment")
    public RespData createComment(HttpServletRequest request) {
        LOGGER.info("CommentController.createComment (给我留言) Request Parameters:开始");
        RespData respData = new RespData();
        try {
            String vcode = request.getParameter("vcode");
            if (StringUtils.isBlank(vcode)) {
                throw new HandleException(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001, "验证码"));
            }
            String content = request.getParameter("content");
            if (StringUtils.isBlank(content)) {
                throw new HandleException(ResultCode.CODE_001, msa.getMessage(ResultCode.CODE_001, "留言内容"));
            }
            HttpSession session = request.getSession(true);
            //转化成小写字母
            vcode = vcode.toLowerCase();
            String v = (String) session.getAttribute("_code");
            //还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
            session.removeAttribute("_come");
            if (!vcode.equals(v)) {
                throw new HandleException(ResultCode.CODE_002, msa.getMessage(ResultCode.CODE_002));
            }
            String nickName = request.getParameter("nickName");
            String email = request.getParameter("email");
            HutComment hutComment = getHutComment(nickName,content);
            boolean result1 = hutCommentService.insert(hutComment);
            HutCommentUser hutCommentUser = getHutCommentUser(request,hutComment.getCmtCode(),nickName,email);
            boolean result2 = hutCommentUserService.insert(hutCommentUser);
            if (!result1 || !result1) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                throw new HandleException(new ResultInfo(ResultCode.CODE_011, msa.getMessage(ResultCode.CODE_011, "留言")));
            }
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (HandleException hle) {
            LOGGER.error("CommentController.createComment (给我留言) HandleException", hle);
            respData.setResultInfo(hle.getResultInfo());
        } catch (Exception e) {
            LOGGER.error("CommentController.createComment (给我留言) Exception", e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("CommentController.createComment (给我留言) Response parameter:结束" + respData.toJsonString());
        return respData;
    }

    private HutComment getHutComment(String nickName,String content){
        HutComment hutComment = new HutComment();
        LOGGER.info("CommentController.createComment (给我留言) ：开始获取数据库序列值");
        Integer hutCommentId = hutCommentService.selectSequence();
        LOGGER.info("CommentController.createComment (给我留言) ：获取数据库序列值成功，值为" + hutCommentId);
        hutComment.setId(hutCommentId);
        hutComment.setCmtCode(createCommetCode(hutCommentId));
        hutComment.setCmtNickName(StringUtils.isNotBlank(nickName) ? nickName : "匿名");
        hutComment.setCmtType(1);//类型1评论
        hutComment.setTopicId("给我留言");//主题ID
        hutComment.setContent(content);//内容
        hutComment.setState("8");//状态8通过
        hutComment.setCmtTime(new Date());//评论时间
        hutComment.setServiceState("7");//客服回复状态7未回复
        return hutComment;
    }

    private HutCommentUser getHutCommentUser(HttpServletRequest request,String cmtCode,String nickName,String email){
        HutCommentUser hutCommentUser = new HutCommentUser();
        LOGGER.info("CommentController.createComment (给我留言) ：开始获取数据库序列值");
        Integer hutCommentUserId = hutCommentUserService.selectSequence();
        LOGGER.info("CommentController.createComment (给我留言) ：获取数据库序列值成功，值为" + hutCommentUserId);
        hutCommentUser.setId(hutCommentUserId);
        hutCommentUser.setCmtCode(cmtCode);
        hutCommentUser.setUserType(1);//用户类型1评论人
        hutCommentUser.setNickName(nickName);//昵称
        hutCommentUser.setEmail(email);//邮箱
        hutCommentUser.setUserIp(getRemoteAddress(request));//用户IP
        return hutCommentUser;
    }

    //生成交易流水号（XXX+YYMMDDHHmmSS+5位序列）
    private String createCommetCode(Integer seq) {
        StringBuffer cmtCode = new StringBuffer();
        cmtCode.append("CMT");
        cmtCode.append(getNowTimeTo("yyMMddHHmmSS"));// 追加yyMMddHHmmSS
        String seqLen = String.format("%05d", seq);// 调用数据库查询五位序列
        cmtCode.append(seqLen.substring(seqLen.length() - 5, seqLen.length()));//截取未五位
        return cmtCode.toString();
    }

    //获取当前系统时间
    private static String getNowTimeTo(String strFormat) {
        if (strFormat == null || StringUtils.isEmpty(strFormat)) {
            strFormat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        return dateFormat.format(new Date());
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
