package com.memuli.oysterhutadmin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.memuli.oysterhutadmin.dao.HutNewsMapper;
import com.memuli.oysterhutadmin.entity.HutNews;
import org.springframework.stereotype.Service;

@Service
public class HutNewsService extends ServiceImpl<HutNewsMapper,HutNews> {
    /**
     * 查询下一个序列值
     */
    public int selectSequence() {
        return baseMapper.selectSequence();
    }
}
