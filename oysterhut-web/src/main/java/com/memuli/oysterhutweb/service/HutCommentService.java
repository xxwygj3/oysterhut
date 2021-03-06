package com.memuli.oysterhutweb.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.memuli.oysterhutweb.dao.HutCommentMapper;
import com.memuli.oysterhutweb.entity.HutComment;
import org.springframework.stereotype.Service;

@Service
public class HutCommentService extends ServiceImpl<HutCommentMapper,HutComment> {
    /**
     * 查询下一个序列值
     */
    public int selectSequence() {
        return baseMapper.selectSequence();
    }
}
