package com.my.spring.service;
import com.my.spring.utils.DataWrapper;
import com.my.spring.model.NewsEntity;
import java.util.List;

/**
 * Created by nixinan on 2017/1/16.
 */
public interface NewsService {
    DataWrapper<Void> addNews(NewsEntity news);
    DataWrapper<Void> updateNews(NewsEntity news);
    DataWrapper<Void> deleteNews(Long newsid);
    DataWrapper<List<NewsEntity>> getNewsList(String numPerPage,String pageNum,String title, String starttime, String endtime, Long state);
    DataWrapper<NewsEntity> getNewsById(Long newsid);
    DataWrapper<Void> verify(Long newsid,Long state);

}
