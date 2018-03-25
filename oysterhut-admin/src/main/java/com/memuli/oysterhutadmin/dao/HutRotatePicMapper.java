package com.memuli.oysterhutadmin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.memuli.oysterhutadmin.entity.HutRotatePic;

/**
 * Mapper 接口
 */
public interface HutRotatePicMapper extends BaseMapper<HutRotatePic> {
    /**
     * 查询下一个序列值
     */
    int selectSequence();
}
