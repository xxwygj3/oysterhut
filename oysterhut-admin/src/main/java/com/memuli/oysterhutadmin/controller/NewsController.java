package com.memuli.oysterhutadmin.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.memuli.oysterhutadmin.entity.HutNews;
import com.memuli.oysterhutadmin.service.HutNewsService;
import com.memuli.oysterhutadmin.util.RespData;
import com.memuli.oysterhutadmin.util.ResultInfo;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class NewsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    private HutNewsService hutNewsService;

    @GetMapping("/news/all")
    public RespData allNews(Page<HutNews> page){
        LOGGER.info("NewsController.addNews (新增新闻) Request Parameters:");
        RespData respData = new RespData();
        try {
//            Page<HutNews> hutNewsPage=new Page<HutNews>(1,10);
            page = hutNewsService.selectPage(page);
            respData.addObject("newsList",page);
            respData.setResultInfo(new ResultInfo(200,"分页查询新闻列表成功"));
        }catch (Exception e){
            respData.setResultInfo(new ResultInfo(500,e.getMessage()));
        }
        LOGGER.info("NewsController.addNews (新增新闻) Response parameter:"+ respData.toJsonString());
        return respData;
    }

//    @PostMapping("/news/add")
//    public Map<String,Object> addNews(@RequestParam(value = "newsfile", required = false) MultipartFile[] newsfile, HttpServletRequest request){
//        LOGGER.info("NewsController.addNews (新增新闻) Request Parameters:");
//        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
//        try {
//            HutNews hutNews = new HutNews();
//            boolean result = hutNewsService.insert(hutNews);
//            if(resu
//                resultMap.put("status",200);
//                resultMap.put("message","新增新闻成功");
//            }else{
//                resultMap.put("status",500);
//                resultMap.put("message","新增新闻失败");
//            }
//        }catch (Exception e){
//            resultMap.put("status",500);
//            resultMap.put("message",e.getMessage());
//        }
//        LOGGER.info("NewsController.addNews (新增新闻) Response parameter:"+ JSONObject.fromObject(resultMap).toString());
//        return resultMap;
//    }
}
