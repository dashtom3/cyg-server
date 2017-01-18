package com.my.spring.serviceImpl;

import com.my.spring.DAO.ItemsDao;
import com.my.spring.enums.CallStatusEnum;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.ItemsService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.ItemsEntity;
import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Service("itemsService")
public class ItemsServiceImpl  implements ItemsService{
    @Autowired
    ItemsDao itemsDao;

    @Override
    public DataWrapper<Void> add(ItemsEntity items) {
        return null;
    }

    @Override
    public DataWrapper<Void> update(ItemsEntity items) {
        return null;
    }

    @Override
    public DataWrapper<Void> delete(Long itemsid) {
        boolean result = itemsDao.delete(itemsid);
        DataWrapper<Void> data = new DataWrapper<Void>();
        if(result == true){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;

    }

    @Override
    public DataWrapper<List<ItemsEntity>> getItemsList(String numPerPage, String pageNum, String itemtype, String itemname, String teacher, String starttime, String endtime, Long type, Long state) {
        return null;
    }

    @Override
    public DataWrapper<ItemsEntity> getItems(Long itemsid) {
        DataWrapper<ItemsEntity> retDataWrapper = new DataWrapper<ItemsEntity>();

        if(itemsid != null ) {

            ItemsEntity newsEntity = itemsDao.getItems(itemsid);
            retDataWrapper.setData(newsEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> verify(Long itemsid, Long state) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        if(itemsid!=null&&state!=null)
        {
            if(itemsDao.verify(itemsid,state))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        retDataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return retDataWrapper;
    }

}
