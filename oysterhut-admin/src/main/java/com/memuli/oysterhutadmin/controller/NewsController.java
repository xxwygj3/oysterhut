package com.memuli.oysterhutadmin.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.memuli.oysterhutadmin.config.UploadConfig;
import com.memuli.oysterhutadmin.entity.HutNews;
import com.memuli.oysterhutadmin.service.HutNewsService;
import com.memuli.oysterhutadmin.util.RespData;
import com.memuli.oysterhutadmin.util.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import com.google.common.base.Optional;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class NewsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    private UploadConfig uploadConfig;
    @Autowired
    private HutNewsService hutNewsService;

    @GetMapping("/news/getNewsList")
    public RespData getNewsList(@RequestParam Integer offset, @RequestParam Integer limit) {
        LOGGER.info("NewsController.getNewsList (查询新闻列表) Request Parameters:+{'offset':" + offset + ",'limit':" + limit + "}");
        RespData respData = new RespData();
        try {
            if (offset == null && limit == null) {
                offset = 1;
                limit = 10;
            }
            //当前页码:pageIndex = offset/limit+1;limit每页的个数,offset分页时数据的偏移量
            Integer pageIndex = (offset + limit) / limit;
            Page<HutNews> page = new Page<HutNews>(pageIndex, limit);
            page = hutNewsService.selectPage(page, null);
            respData.addObject("total", page.getTotal());
            respData.addObject("rows", page.getRecords());
            respData.setResultInfo(new ResultInfo(200, "分页查询新闻列表成功"));
        } catch (Exception e) {
            respData.setResultInfo(new ResultInfo(500, e.getMessage()));
        }
        LOGGER.info("NewsController.getNewsList (查询新闻列表) Response parameter:" + respData.toJsonString());
        return respData;
    }

    //@RequestParam(value = "newsfile", required = false) MultipartFile[] newsfile,
    @PostMapping("/news/addAndUpdateNews")
    public RespData addAndUpdateNews(@RequestParam(value = "newsfile", required = false) MultipartFile[] newsfile,
                                     @RequestParam(value = "optType") String optType,
                                     HttpServletRequest request) {
        LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻) Request Parameters:+{'optType':"+optType+"}");
        RespData respData = new RespData();
        try {
            HutNews hutNews = getHutNewsEntity(newsfile,request,optType);
            if(hutNewsService.insertOrUpdate(hutNews)){
                respData.setResultInfo(new ResultInfo(200, "新增或编辑新闻成功"));
            }else{
                respData.setResultInfo(new ResultInfo(100, "新增或编辑新闻失败"));
            }
        } catch (Exception e) {
            respData.setResultInfo(new ResultInfo(500, e.getMessage()));
        }
        LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻) Response parameter:" + respData.toJsonString());
        return respData;
    }

    private HutNews getHutNewsEntity(MultipartFile[] newsfile,HttpServletRequest request,String optType) throws Exception{
        HutNews hutNews = new HutNews();
        if("1".equals(optType)){//编辑
            hutNews.setId(Integer.valueOf(request.getParameter("id")));
        }
        hutNews.setNewsType("1001");//类型1001新闻动态
        hutNews.setTitle(request.getParameter("title"));//标题
        if (Optional.fromNullable(newsfile).isPresent()) {//如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false
            for(MultipartFile newfile: newsfile){
                if(!newfile.isEmpty()){
//                        long size = 3 * 1024 * 1024;
//                        if (newsfile[0].getSize() > size) {
//                            respData.setResultInfo(new ResultInfo(100, "文件太大了"));
//                        }
                    StringBuffer pathStringBuffer = new StringBuffer(request.getSession().getServletContext().getRealPath("/"));
                    pathStringBuffer.append("news/addAndUpdateNews/");
                    String path = pathStringBuffer.toString();
                    String fileName = UUID.randomUUID().toString().replace("-", "");
                    if (newsfile[0].getContentType().equals("image/jpeg")) {
                        fileName += ".jpg";
                    } else if (newsfile[0].getContentType().equals("image/png")) {
                        fileName += ".png";
                    } else if (newsfile[0].getContentType().equals("image/gif")) {
                        fileName += ".gif";
                    } else if (newsfile[0].getContentType().equals("image/bmp")) {
                        fileName += ".bmp";
                    }
                    File dir = new File(path);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    File targetFile = new File(path, fileName);
                    // 写入文件
                    try {
                        newsfile[0].transferTo(targetFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // 保存文件上传路径
                    StringBuffer requestUrlStringBuffer = new StringBuffer(uploadConfig.getRequestUrl());
                    requestUrlStringBuffer.append("/news/addAndUpdateNews/").append(fileName);
                    String requestUrl =  requestUrlStringBuffer.toString();
                    hutNews.setImgUrl(requestUrl);//图片地址
                }
            }
        }
        //hutNews.setSummary();//简介
        hutNews.setContent(request.getParameter("content"));//内容
        hutNews.setDisplayOrder(Integer.valueOf(request.getParameter("order")));//显示顺序
        hutNews.setState(request.getParameter("state"));//状态8有效、9无效
        //hutNews.setCreateBy();//创建人
        //hutNews.setSourceType();//来源类型
        //hutNews.setSourceDesc();//来源描述
        return hutNews;
    }
}
