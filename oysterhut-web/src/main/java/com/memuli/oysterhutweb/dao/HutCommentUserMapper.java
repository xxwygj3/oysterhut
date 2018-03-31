package com.memuli.oysterhutweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.memuli.oysterhutweb.entity.HutCommentUser;

/**
 * Mapper 接口
 */
public interface HutCommentUserMapper extends BaseMapper<HutCommentUser> {
    /**
     * 查询下一个序列值
     */
    int selectSequence();
}
