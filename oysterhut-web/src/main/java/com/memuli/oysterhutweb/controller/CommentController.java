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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    //分页查询评论列表
    @GetMapping("/comment/getCommentList")
    public RespData getCommentList(@RequestParam(value = "offset",defaultValue = "1")Integer offset, @RequestParam (value = "limit",defaultValue = "10")Integer limit) {
        LOGGER.info("CommentController.getCommentList (分页查询评论列表) Request Parameters:+{'offset':" + offset + ",'limit':" + limit + "}");
        RespData respData = new RespData();
        try {
            //当前页码:pageIndex = offset/limit+1;limit每页的个数,offset分页时数据的偏移量
            Integer pageIndex = (offset + limit) / limit;
            Page<HutComment> page = new Page<HutComment>(pageIndex, limit);
            EntityWrapper<HutComment> wrapper = new EntityWrapper<HutComment>();
            wrapper.orderBy("cmt_time",false);//评论时间降序
            page = hutCommentService.selectPage(page, wrapper);
            respData.addObject("total", page.getTotal());
            respData.addObject("rows", page.getRecords());
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (Exception e) {
            LOGGER.error("CommentController.getCommentList (分页查询评论列表) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("CommentController.getCommentList (分页查询评论列表) Response parameter:" + respData.toJsonString());
        return respData;
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
