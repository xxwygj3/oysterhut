package com.memuli.oysterhutadmin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.memuli.oysterhutadmin.entity.HutNews;

/**
 * Mapper 接口
 */
public interface HutNewsMapper extends BaseMapper<HutNews> {
    /**
     * 查询下一个序列值
     */
    int selectSequence();
}
