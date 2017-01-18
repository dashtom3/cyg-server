package com.my.spring.controller;

import com.my.spring.service.ItemsService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.my.spring.model.ItemsEntity;
import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Controller
@RequestMapping(value = "api/items")
public class ItemsController  {
    @Autowired
    ItemsService itemsService;
    @RequestMapping(value="add",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute ItemsEntity newsEntity)
    {

        return itemsService.add(newsEntity);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "itemsid",required = false) Long itemsid,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.delete(itemsid);
    }

    @RequestMapping(value="verify")
    @ResponseBody
    public DataWrapper<Void> verify(
            @RequestParam(value = "state",required = false) Long state,
            @RequestParam(value = "itemsid",required = false) Long itemsid,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.verify(itemsid,state);
    }

    @RequestMapping(value="getbyid")
    @ResponseBody
    public DataWrapper<ItemsEntity> getbyid(
            @RequestParam(value = "itemsid",required = false) Long itemsid,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.getItems(itemsid);
    }

    @RequestMapping(value="getNewsList",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<List<ItemsEntity>> getNewsList(
            @RequestParam(value = "numPerPage",required = false) String numPerPage,
            @RequestParam(value = "pageNum",required = false) String pageNum,
            @RequestParam(value = "itemtype",required = false) String itemtype,
            @RequestParam(value = "itemname",required = false) String itemname,
            @RequestParam(value = "teacher",required = false) String teacher,
            @RequestParam(value = "starttime",required = false) String starttime,
            @RequestParam(value = "endtime",required = false) String endtime,
            @RequestParam(value = "type",required = false) Long type,
            @RequestParam(value = "state",required = false) Long state,
            @RequestParam(value = "token",required = false) String token){

        return itemsService.getItemsList(numPerPage, pageNum, itemtype,itemname,teacher,starttime,endtime,type,state);
    }

}
