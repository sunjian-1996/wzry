package com.bbs.controller;

import com.bbs.service.DianzanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class DianzanController {
    @Autowired
    private DianzanService dianzanService;


}
