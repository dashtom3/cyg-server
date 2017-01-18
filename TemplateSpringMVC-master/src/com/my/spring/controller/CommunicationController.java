package com.my.spring.controller;

import com.my.spring.model.CommunicationEntity;
import com.my.spring.service.CommunicationService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Controller
@RequestMapping(value = "api/communication")
public class CommunicationController {
    @Autowired
    CommunicationService communicationService;

    @RequestMapping(value="getCommunicationList",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<CommunicationEntity>> getCommunicationList(
            @RequestParam(value = "numPerPage",required = false) String numPerPage,
            @RequestParam(value = "pageNum",required = false) String pageNum,
            @RequestParam(value = "theme",required = false) String theme,
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "userName",required = false) String userName,
            @RequestParam(value = "replyQuantity",required = false) Long replyQuantity,
            @RequestParam(value = "contents",required = false) String contents,
            @RequestParam(value = "token",required = false) String token){

        return communicationService.getCommunicationList(numPerPage,pageNum,theme,title,userName,replyQuantity,contents);
    }
}
