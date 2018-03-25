package com.memuli.oysterhutadmin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Optional;
import com.memuli.oysterhutadmin.constant.ResultCode;
import com.memuli.oysterhutadmin.entity.HutNews;
import com.memuli.oysterhutadmin.entity.SysUser;
import com.memuli.oysterhutadmin.util.HandleException;
import com.memuli.oysterhutadmin.util.RespData;
import com.memuli.oysterhutadmin.util.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@RestController
public class NewsController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    //分页查询新闻列表
    @GetMapping("/news/getNewsList")
    public RespData getNewsList(@RequestParam (value = "offset",defaultValue = "1")Integer offset, @RequestParam (value = "limit",defaultValue = "10")Integer limit) {
        LOGGER.info("NewsController.getNewsList (分页查询新闻列表) Request Parameters:+{'offset':" + offset + ",'limit':" + limit + "}");
        RespData respData = new RespData();
        try {
            //当前页码:pageIndex = offset/limit+1;limit每页的个数,offset分页时数据的偏移量
            Integer pageIndex = (offset + limit) / limit;
            Page<HutNews> page = new Page<HutNews>(pageIndex, limit);
            EntityWrapper<HutNews> wrapper = new EntityWrapper<HutNews>();
            wrapper.orderBy("state",true);//状态升序
            wrapper.orderBy("display_order",true);//显示顺序升序
            wrapper.orderBy("create_time",false);//创建时间降序
            page = hutNewsService.selectPage(page, wrapper);
            respData.addObject("total", page.getTotal());
            respData.addObject("rows", page.getRecords());
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (Exception e) {
            LOGGER.error("NewsController.getNewsList (分页查询新闻列表) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("NewsController.getNewsList (分页查询新闻列表) Response parameter:" + respData.toJsonString());
        return respData;
    }

    //新增或编辑新闻
    @PostMapping("/news/addAndUpdateNews")
    public RespData addAndUpdateNews(@RequestParam(value = "newsfile", required = false) MultipartFile[] newsfile,
                                     @RequestParam(value = "optType") String optType,
                                     HttpServletRequest request) {
        LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻) Request Parameters:+{'optType':" + optType + "}");
        RespData respData = new RespData();
        try {
            //获取当前用户信息
            SysUser loginUser = getCurrentUser();
            if (null == loginUser) {
                throw new HandleException(new ResultInfo(ResultCode.CODE_005, msa.getMessage(ResultCode.CODE_005)));
            }
            HutNews hutNews = getHutNewsEntity(loginUser, newsfile, request, optType);
            hutNewsService.insertOrUpdate(hutNews);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (HandleException hle) {
            LOGGER.error("NewsController.addAndUpdateNews (新增或编辑新闻) HandleException",hle);
            respData.setResultInfo(hle.getResultInfo());
        } catch (Exception e) {
            LOGGER.error("NewsController.addAndUpdateNews (新增或编辑新闻) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻) Response parameter:" + respData.toJsonString());
        return respData;
    }

    private HutNews getHutNewsEntity(SysUser user, MultipartFile[] files, HttpServletRequest request, String optType) throws Exception {
        HutNews hutNews = new HutNews();
        if ("1".equals(optType)) {//编辑
            hutNews.setId(Integer.valueOf(request.getParameter("id")));
            hutNews.setModifyBy(user.getNickname());//修改人
            hutNews.setModifyTime(new Date());//修改时间
        }else if ("0".equals(optType)){//新增
            LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻)：开始获取数据库序列值");
            Integer hutNewsId = hutNewsService.selectSequence();
            LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻)：获取数据库序列值成功，值为"+hutNewsId);
            hutNews.setId(hutNewsId);
            hutNews.setCreateBy(user.getNickname());//创建人
            hutNews.setCreateTime(new Date());//创建时间
        }
        hutNews.setNewsType("1001");//类型1001新闻动态
        hutNews.setTitle(request.getParameter("title"));//标题
        if (Optional.fromNullable(files).isPresent()) {//如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    hutNews.setImgUrl(getRequestImgUrl(files,request,"news/"));//图片地址
                }
            }
        }
        hutNews.setSummary(request.getParameter("summary"));//简介
        hutNews.setContent(request.getParameter("content"));//内容
        hutNews.setDisplayOrder(Integer.valueOf(request.getParameter("order")));//显示顺序
        hutNews.setState(request.getParameter("state"));//状态8有效、9无效
        hutNews.setSourceType(Integer.valueOf(request.getParameter("sourceType")));//来源类型
        hutNews.setSourceDesc(request.getParameter("sourceDesc"));//来源描述
        return hutNews;
    }
}
