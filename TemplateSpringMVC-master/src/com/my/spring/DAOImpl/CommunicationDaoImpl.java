package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.CommunicationDao;
import com.my.spring.model.CommunicationEntity;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Repository
public class CommunicationDaoImpl extends BaseDao<CommunicationEntity>implements CommunicationDao{

    @Override
    public DataWrapper<List<CommunicationEntity>> getCommunicationList(String numPerPage, String pageNum, String theme, String title, String userName, Long replyQuantity, String contents) {
        DataWrapper<List<CommunicationEntity>> dataWrapper=new DataWrapper<List<CommunicationEntity>>();
        List<CommunicationEntity> ret = new ArrayList<CommunicationEntity>();
        Session session = getSession();
        Transaction trans = session.beginTransaction();
        StringBuffer stringBuffer=new StringBuffer("select p.theme,p.title,u.username as username,COUNT(*) as replyQuantity,p.time as publishedTime,c.contents,c.time as replyTime FROM `comment` c inner JOIN posts p on c.postsid=p.postsid INNER JOIN `user` u on c.userid=u.userid ");
        stringBuffer.append(" where 1=1 ");
        if(theme!=null)
        {
            stringBuffer.append(" and p.theme LIKE '%"+theme+"% '");
        }
        if(title!=null)
        {
            stringBuffer.append(" and p.title LIKE '%"+title+"% '");
        }
        if(userName!=null)
        {
            stringBuffer.append(" and u.username LIKE '%"+userName+"%'  ");
        }
        if(replyQuantity!=null)
        {
            stringBuffer.append(" and replyquantity="+replyQuantity+" ");
        }
        if(contents!=null)
        {
            stringBuffer.append(" and c.contents LIKE '%"+contents+"%'  ");
        }
        stringBuffer.append(" GROUP BY p.postsid ");
        stringBuffer.append(" ORDER BY publishedTime DESC ");
        Query query=session.createSQLQuery(stringBuffer.toString());
        int numperpage = Integer.parseInt(numPerPage);
        int pagenum = Integer.parseInt(pageNum);
        int totalltemNum = (query.list().size());
        int totalPageNum = DaoUtils.getTotalPageNum(totalltemNum, numperpage);
        if (numperpage > 0 && pagenum > 0) {
            query.setMaxResults(numperpage);
            query.setFirstResult((pagenum - 1) * numperpage);
        }
        trans.commit();
        dataWrapper.setCurrentPage(pagenum);
        dataWrapper.setNumberPerPage(numperpage);
        dataWrapper.setTotalPage(totalPageNum);
        dataWrapper.setTotalNumber(totalltemNum);
        ret=query.list();
        dataWrapper.setData(ret);
        return dataWrapper;
    }
}
