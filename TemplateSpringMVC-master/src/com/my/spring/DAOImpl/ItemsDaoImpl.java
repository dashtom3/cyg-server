package com.my.spring.DAOImpl;

import com.my.spring.DAO.BaseDao;
import com.my.spring.DAO.ItemsDao;
import com.my.spring.utils.DataWrapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.my.spring.model.*;
import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Repository
public class ItemsDaoImpl  extends BaseDao<ItemsEntity> implements ItemsDao{
    @Override
    public boolean add(ItemsEntity items) {
        return false;
    }

    @Override
    public boolean delete(Long itemsId) {
        return delete(get(itemsId));
    }

    @Override
    public boolean verify(Long itemsid, Long state) {
        Session session = getSession();
        String sql = "update items set state='" + state + "' where itemsid=" + itemsid;
        Query query = session.createSQLQuery(sql);
        query.executeUpdate();
        return false;
    }

    @Override
    public DataWrapper<List<ItemsEntity>> getItemsList(String numPerPage,String pageNum,String itemType,String itemName, String teacher, String startTime, String endTime,Long type, Long state){
        return null;
    }

    @Override
    public ItemsEntity getItems(Long itemsId) {
        return get(itemsId);
    }
}
