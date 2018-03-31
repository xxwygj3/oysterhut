package com.memuli.oysterhutweb.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.memuli.oysterhutweb.dao.HutCommentMapper;
import com.memuli.oysterhutweb.dao.HutCommentUserMapper;
import com.memuli.oysterhutweb.entity.HutComment;
import com.memuli.oysterhutweb.entity.HutCommentUser;
import org.springframework.stereotype.Service;

@Service
public class HutCommentUserService extends ServiceImpl<HutCommentUserMapper,HutCommentUser> {
    /**
     * 查询下一个序列值
     */
    public int selectSequence() {
        return baseMapper.selectSequence();
    }
}
