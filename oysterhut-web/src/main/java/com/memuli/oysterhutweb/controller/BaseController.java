package com.memuli.oysterhutweb.controller;

import com.memuli.oysterhutweb.service.HutCommentService;
import com.memuli.oysterhutweb.util.MessageSourceAccessor;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    protected MessageSourceAccessor msa;
    @Autowired
    protected HutCommentService hutCommentService;

}
