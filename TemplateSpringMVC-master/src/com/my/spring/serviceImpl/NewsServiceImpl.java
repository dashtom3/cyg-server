package com.my.spring.serviceImpl;

import com.my.spring.DAO.NewsDao;
import com.my.spring.enums.CallStatusEnum;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.NewsService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.NewsEntity;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by nixinan on 2017/1/16.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public DataWrapper<Void> addNews(NewsEntity news) {
        news.setTime(new Timestamp(System.currentTimeMillis()));
        boolean result = newsDao.add(news);
        DataWrapper<Void> data = new DataWrapper<Void>();
        if(result == true){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<Void> updateNews(NewsEntity news) {
        return null;
    }

    @Override
    public DataWrapper<Void> deleteNews(Long newsid) {
        boolean result = newsDao.delete(newsid);
        DataWrapper<Void> data = new DataWrapper<Void>();
        if(result == true){
            return data;
        }
        data.setErrorCode(ErrorCodeEnum.Error);
        return data;
    }

    @Override
    public DataWrapper<List<NewsEntity>> getNewsList(String numPerPage,String pageNum,String title, String Starttime, String endtime, Long state) {
        return newsDao.getNewsList(numPerPage,pageNum,title,Starttime,endtime,state);
    }

    @Override
    public DataWrapper<NewsEntity> getNewsById(Long newsid) {
        DataWrapper<NewsEntity> retDataWrapper = new DataWrapper<NewsEntity>();

        if(newsid != null ) {

            NewsEntity newsEntity = newsDao.getNews(newsid);
            retDataWrapper.setData(newsEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> verify(Long newsid, Long state) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        if(newsid!=null&&state!=null)
        {
            if(newsDao.verify(newsid,state))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        retDataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return retDataWrapper;
    }
}
