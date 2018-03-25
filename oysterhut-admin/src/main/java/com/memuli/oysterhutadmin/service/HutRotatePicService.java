package com.memuli.oysterhutadmin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.memuli.oysterhutadmin.dao.HutRotatePicMapper;
import com.memuli.oysterhutadmin.entity.HutRotatePic;
import org.springframework.stereotype.Service;

@Service
public class HutRotatePicService extends ServiceImpl<HutRotatePicMapper,HutRotatePic>{
    /**
     * 查询下一个序列值
     */
    public int selectSequence() {
        return baseMapper.selectSequence();
    }
}
