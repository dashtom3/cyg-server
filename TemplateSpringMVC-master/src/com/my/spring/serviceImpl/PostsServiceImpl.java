package com.my.spring.serviceImpl;

import com.my.spring.DAO.PostsDao;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.PostsService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.PostsEntity;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nixinan on 2017/1/17.
 */
@Service("postsService")
public class PostsServiceImpl implements PostsService{
    @Autowired
    PostsDao postsDao;


    @Override
    public DataWrapper<Void> add(PostsEntity posts) {
        posts.setTime(new Timestamp(System.currentTimeMillis()));
        boolean result = postsDao.add(posts);
        DataWrapper<Void> data = new DataWrapper<Void>();
        if(result)
        {
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<Void> delete(Long postsId) {
        boolean result = postsDao.delete(postsId);
        DataWrapper<Void> data = new DataWrapper<Void>();
        if(result){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<PostsEntity> getPostsById(Long postsId) {
        DataWrapper<PostsEntity> retDataWrapper = new DataWrapper<PostsEntity>();

        if(postsId != null ) {

            PostsEntity newsEntity = postsDao.getPosts(postsId);
            retDataWrapper.setData(newsEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<List<PostsEntity>> getPostsList(String numPerPage,String pageNum,String theme, String title, String startTime, String endTime) {
        return postsDao.getPostsList(numPerPage,pageNum,theme,title,startTime,endTime);
    }
}
