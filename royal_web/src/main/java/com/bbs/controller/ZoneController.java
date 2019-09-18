package com.bbs.controller;

import com.bbs.domain.BbsZoneTable;
import com.bbs.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/zone")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    //查询所有版块
    @RequestMapping("/findAll.do")
    public @ResponseBody
    List<BbsZoneTable> findAll() throws Exception {
        List<BbsZoneTable> bbsZoneTableList = zoneService.findAll();
        return bbsZoneTableList;
    }
}
