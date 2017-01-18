package com.my.spring.service;

import com.my.spring.utils.DataWrapper;
import com.my.spring.model.CommentEntity;
/**
 * Created by nixinan on 2017/1/17.
 */
public interface CommentService {
    DataWrapper<Void> add(CommentEntity comment);
    DataWrapper<Void> delete(Long commentid);
}
