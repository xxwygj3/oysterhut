package com.memuli.oysterhutweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.memuli.oysterhutweb.entity.HutComment;

/**
 * Mapper 接口
 */
public interface HutCommentMapper extends BaseMapper<HutComment> {
    /**
     * 查询下一个序列值
     */
    int selectSequence();
}
