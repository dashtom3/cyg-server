package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.CommentDao;
import org.springframework.stereotype.Repository;
import com.my.spring.model.CommentEntity;
/**
 * Created by nixinan on 2017/1/17.
 */
@Repository
public class CommentDaoImpl extends BaseDao<CommentEntity> implements CommentDao{
    @Override
    public boolean add(CommentEntity comment) {
        return save(comment);
    }

    @Override
    public boolean delete(Long commentid) {
        return delete(get(commentid));
    }


}
