package com.my.spring.controller;
import com.my.spring.model.PostsEntity;
import com.my.spring.service.PostsService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Created by nixinan on 2017/1/17.
 */
@Controller
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    PostsService postsService;
    @RequestMapping(value="add",method= RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> add(
            @ModelAttribute PostsEntity postsEntity)
    {

        return postsService.add(postsEntity);
    }
    @RequestMapping(value="delete")
    @ResponseBody
    public DataWrapper<Void> delete(
            @RequestParam(value = "postId",required = false) Long postId,
            @RequestParam(value = "token",required = false) String token)
    {

        return postsService.delete(postId);
    }

    @RequestMapping(value="getbyid")
    @ResponseBody
    public DataWrapper<PostsEntity> getbyid(
            @RequestParam(value = "postsId",required = false) Long postsId,
            @RequestParam(value = "token",required = false) String token){

        return postsService.getPostsById(postsId);
    }
    @RequestMapping(value="getPostsList")
    @ResponseBody
    public DataWrapper<List<PostsEntity>> getPostsList(
            @RequestParam(value = "numPerPage",required = false) String numPerPage,
            @RequestParam(value = "pageNum",required = false) String pageNum,
            @RequestParam(value = "theme",required = false) String theme,
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "startTime",required = false) String startTime,
            @RequestParam(value = "endTime",required = false) String endTime,
            @RequestParam(value = "token",required = false) String token){

        return postsService.getPostsList(numPerPage,pageNum,theme,title,startTime,endTime);
    }
}
