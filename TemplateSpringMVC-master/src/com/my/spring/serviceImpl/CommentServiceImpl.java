package com.my.spring.serviceImpl;

import com.my.spring.DAO.CommentDao;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.CommentService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.CommentEntity;
import java.sql.Timestamp;

/**
 * Created by nixinan on 2017/1/17.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentDao commentDao;

    @Override
    public DataWrapper<Void> add(CommentEntity comment) {
        comment.setTime(new Timestamp(System.currentTimeMillis()));
        boolean result = commentDao.add(comment);
        DataWrapper<Void> data = new DataWrapper<Void>();
        if(result==true)
        {
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<Void> delete(Long commentid) {
        boolean result = commentDao.delete(commentid);
        DataWrapper<Void> data = new DataWrapper<Void>();
        if(result==true){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }
}
