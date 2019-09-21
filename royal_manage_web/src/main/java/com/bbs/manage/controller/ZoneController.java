package com.bbs.manage.controller;

import com.bbs.domain.BbsZoneapplyTable;
import com.bbs.service.ZoneService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/zoneApply")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;


    //版块管理分页及内容查询
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                   @RequestParam(name = "size",required = true,defaultValue = "4") int size,
                                   String zone,String senderName){
        ModelAndView mv = new ModelAndView();
       List<BbsZoneapplyTable> list = zoneService.findByPageAndTitle(page,size,zone,senderName);
        PageInfo pageInfo =new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("zone",zone);
        mv.addObject("senderName",senderName);
        mv.setViewName("ZonePage");
        return mv;
    }
    //同意开辟新版块，版块管理分页及内容查询
    @RequestMapping("/changeStatus1.do")
    public ModelAndView changeStatus1(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                   @RequestParam(name = "size",required = true,defaultValue = "4") int size,
                                   String zone,String senderName,String applyZoneId,String zoneName){

        if (zoneName!=null){
            try {
               zoneName = new String(zoneName.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        zoneService.changeStatus1(applyZoneId,zoneName);
        ModelAndView mv = new ModelAndView();
        List<BbsZoneapplyTable> list = zoneService.findByPageAndTitle(page,size,zone,senderName);
        PageInfo pageInfo =new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("zone",zone);
        mv.addObject("senderName",senderName);
        mv.setViewName("ZonePage");
        return mv;
    }
    //驳回开辟新版块，版块管理分页及内容查询
    @RequestMapping("/changeStatus2.do")
    public ModelAndView changeStatus2(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                   @RequestParam(name = "size",required = true,defaultValue = "4") int size,
                                   String zone,String senderName,String applyZoneId){

        zoneService.changeStatus2(applyZoneId);
        ModelAndView mv = new ModelAndView();
        List<BbsZoneapplyTable> list = zoneService.findByPageAndTitle(page,size,zone,senderName);
        PageInfo pageInfo =new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("zone",zone);
        mv.addObject("senderName",senderName);
        mv.setViewName("ZonePage");
        return mv;
    }
}
