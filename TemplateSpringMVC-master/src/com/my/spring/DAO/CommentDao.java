package com.my.spring.DAO;
import com.my.spring.model.CommentEntity;
/**
 * Created by nixinan on 2017/1/17.
 */
public interface CommentDao {
    boolean add(CommentEntity comment);
    boolean delete(Long commentid);

}
