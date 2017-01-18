package com.my.spring.controller;

import com.my.spring.service.CommentService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.my.spring.model.CommentEntity;
/**
 * Created by nixinan on 2017/1/17.
 */
@Controller
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping(value="add",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute CommentEntity commentEntity)
    {

        return commentService.add(commentEntity);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "commentid",required = false) Long commentid,
            @RequestParam(value = "token",required = false) String token)
    {

        return commentService.delete(commentid);
    }
}
