package com.memuli.oysterhutadmin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.base.Optional;
import com.memuli.oysterhutadmin.constant.ResultCode;
import com.memuli.oysterhutadmin.entity.HutRotatePic;
import com.memuli.oysterhutadmin.entity.SysUser;
import com.memuli.oysterhutadmin.util.HandleException;
import com.memuli.oysterhutadmin.util.MyDate;
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
public class RotatePicController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RotatePicController.class);
    private final static String URL_HTTP_HEAD = "http://";
    private final static String URL_HTTPS_HEAD = "https://";

    //分页查询轮换图列表
    @GetMapping("/rotatePic/getRotatePicList")
    public RespData getRotatePicList(@RequestParam(value = "offset", defaultValue = "1") Integer offset,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        LOGGER.info("RotatePicController.getRotatePicList (分页查询轮换图列表) Request Parameters:+{'offset':" + offset + ",'limit':" + limit + "}");
        RespData respData = new RespData();
        try {
            //当前页码:pageIndex = offset/limit+1;limit每页的个数,offset分页时数据的偏移量
            Integer pageIndex = (offset + limit) / limit;
            Page<HutRotatePic> page = new Page<HutRotatePic>(pageIndex, limit);
            EntityWrapper<HutRotatePic> wrapper = new EntityWrapper<HutRotatePic>();
            wrapper.orderBy("state", true);//状态升序
            wrapper.orderBy("display_order", true);//显示顺序升序
            wrapper.orderBy("create_time", false);//创建时间降序
            page = hutRotatePicService.selectPage(page,wrapper);
            respData.addObject("total", page.getTotal());
            respData.addObject("rows", page.getRecords());
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (Exception e) {
            LOGGER.error("RotatePicController.getRotatePicList (分页查询轮换图列表) Exception", e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("RotatePicController.getRotatePicList (分页查询轮换图列表) Response parameter:" + respData.toJsonString());
        return respData;
    }

    //新增或编辑轮换图
    @PostMapping("/rotatePic/addAndUpdateRotatePic")
    public RespData addAndUpdateRotatePic(@RequestParam(value = "rotatePicfile", required = false) MultipartFile[] rotatePicfile,
                                     @RequestParam(value = "optType") String optType,
                                     HttpServletRequest request) {
        LOGGER.info("RotatePicController.addAndUpdateNews (新增或编辑轮换图) Request Parameters:+{'optType':" + optType + "}");
        RespData respData = new RespData();
        try {
            //获取当前用户信息
            SysUser loginUser = getCurrentUser();
            if (null == loginUser) {
                throw new HandleException(new ResultInfo(ResultCode.CODE_005, msa.getMessage(ResultCode.CODE_005)));
            }
            HutRotatePic hutRotatePic = getEntity(loginUser, rotatePicfile, request, optType);
            hutRotatePicService.insertOrUpdate(hutRotatePic);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_000, msa.getMessage(ResultCode.CODE_000)));
        } catch (HandleException hle) {
            LOGGER.error("RotatePicController.addAndUpdateRotatePic (新增或编辑轮换图) HandleException",hle);
            respData.setResultInfo(hle.getResultInfo());
        } catch (Exception e) {
            LOGGER.error("RotatePicController.addAndUpdateRotatePic (新增或编辑轮换图) Exception",e);
            respData.setResultInfo(new ResultInfo(ResultCode.CODE_999, msa.getMessage(ResultCode.CODE_999)));
        }
        LOGGER.info("RotatePicController.addAndUpdateRotatePic (新增或编辑轮换图) Response parameter:" + respData.toJsonString());
        return respData;
    }

    private HutRotatePic getEntity(SysUser user, MultipartFile[] files, HttpServletRequest request, String optType) throws Exception {
        HutRotatePic hutRotatePic = new HutRotatePic();
        if ("1".equals(optType)) {//编辑
            hutRotatePic.setId(Integer.valueOf(request.getParameter("id")));
            hutRotatePic.setModifyBy(user.getNickname());//修改人
            hutRotatePic.setModifyTime(new Date());//修改时间
        }else if ("0".equals(optType)){//新增
            LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻)：开始获取数据库序列值");
            Integer hutRotatePicId = hutRotatePicService.selectSequence();
            LOGGER.info("NewsController.addAndUpdateNews (新增或编辑新闻)：获取数据库序列值成功，值为"+hutRotatePicId);
            hutRotatePic.setId(hutRotatePicId);
            hutRotatePic.setCreateBy(user.getNickname());//创建人
            hutRotatePic.setCreateTime(new Date());//创建时间
        }
        hutRotatePic.setRotatePictureType("2001");//类型2001首页轮换图片
        hutRotatePic.setName(request.getParameter("name"));//名称
        if (Optional.fromNullable(files).isPresent()) {//如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    hutRotatePic.setImgUrl(getRequestImgUrl(files,request,"rotatePic/"));//图片地址
                }
            }
        }
        hutRotatePic.setLinkUrl(getCompleteUrl(request.getParameter("linkUrl")));//链接地址
        hutRotatePic.setDisplayOrder(Integer.valueOf(request.getParameter("order")));//显示顺序
        hutRotatePic.setState(request.getParameter("state"));//状态8有效、9无效
        String expireTime = request.getParameter("expireTime");
        hutRotatePic.setExpireTime(MyDate.stringToDate(expireTime,"yyyy-MM-dd HH:mm:ss"));//到期时间
        return hutRotatePic;
    }

    //添加url协议头
    private static String getCompleteUrl(String url){
        if(!url.startsWith(URL_HTTP_HEAD) && !url.startsWith(URL_HTTPS_HEAD)){
            return URL_HTTP_HEAD.concat(url);
        }
        return url;
    }
}
