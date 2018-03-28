package com.memuli.oysterhutadmin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.memuli.oysterhutadmin.dao.HutCommentMapper;
import com.memuli.oysterhutadmin.dao.HutNewsMapper;
import com.memuli.oysterhutadmin.entity.HutComment;
import com.memuli.oysterhutadmin.entity.HutNews;
import org.springframework.stereotype.Service;

@Service
public class HutCommentService extends ServiceImpl<HutCommentMapper,HutComment> {

}
