package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.PostsDao;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.my.spring.model.PostsEntity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixinan on 2017/1/17.
 */
@Repository
public class PostsDaoImpl extends BaseDao<PostsEntity> implements PostsDao{
    @Override
    public boolean add(PostsEntity posts) {
        return save(posts);
    }

    @Override
    public boolean delete(Long postsId) {
        return delete(get(postsId));
    }

    @Override
    public DataWrapper<List<PostsEntity>> getPostsList(String numPerPage,String pageNum,String theme, String title, String startTime, String endTime) {
        DataWrapper<List<PostsEntity>> retDataWrapper = new DataWrapper<List<PostsEntity>>();
        List<PostsEntity> ret = new ArrayList<PostsEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(PostsEntity.class);
        int numperpage = Integer.parseInt(numPerPage);
        int pagenum = Integer.parseInt(pageNum);
        criteria.setProjection(Projections.rowCount());
        int totalltemNum = ((Long) criteria.uniqueResult()).intValue();
        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numperpage);
        criteria.setProjection(null);
        if (numperpage > 0 && pagenum > 0) {
            criteria.setMaxResults(numperpage);
            criteria.setFirstResult((pagenum - 1) * numperpage);
        }
        if (theme != null) {
            criteria.add(Restrictions.like("theme", theme));
        }
        if (title != null) {
            criteria.add(Restrictions.like("title", title));
        }
        if (startTime != null || endTime != null) {
            if (startTime != null && endTime == null) {
                criteria.add(Restrictions.ge("time", Date.valueOf(startTime)));
            }
            if (startTime == null && endTime != null) {
                criteria.add(Restrictions.le("time", Date.valueOf(endTime)));
            }
            if (startTime != null & endTime != null) {
                criteria.add(Restrictions.between("time", Date.valueOf(startTime), Date.valueOf(endTime)));
            }
        }
        retDataWrapper.setCurrentPage(pagenum);
        retDataWrapper.setNumberPerPage(numperpage);
        retDataWrapper.setTotalPage(totalPageNum);
        retDataWrapper.setTotalNumber(totalltemNum);
        ret = criteria.list();
        retDataWrapper.setData(ret);
       /* DataWrapper<List<PostsEntity>> retDataWrapper = new DataWrapper<List<PostsEntity>>();
        List<PostsEntity> ret = new ArrayList<PostsEntity>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(PostsEntity.class);
        if(theme!=null)
        {
            criteria.add(Restrictions.like("theme", theme));
        }
        if(title!=null)
        {
            criteria.add(Restrictions.like("title",title));
        }
        if(startTime!=null||endTime!=null) {
            if(startTime!=null&&endTime==null)
            {
                criteria.add(Restrictions.ge("time", Date.valueOf(startTime)));
            }
            if(startTime==null&&endTime!=null){
                criteria.add(Restrictions.le("time",Date.valueOf(endTime)));
            }
            if(startTime!=null&endTime!=null)
            {
                criteria.add(Restrictions.between("time",Date.valueOf(startTime),Date.valueOf(endTime)));
            }
        }
        ret = criteria.list();
        retDataWrapper.setData(ret);*/
        return retDataWrapper;
    }

    @Override
    public PostsEntity getPosts(Long postsId) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(PostsEntity.class);
        criteria.add(Restrictions.eq("postsid", postsId));
        List<PostsEntity> result = criteria.list();
        if (result != null && result.size() > 0) {
            return  result.get(0);
        }
        return null;
    }
}
