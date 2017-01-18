package com.my.spring.service;

import com.my.spring.model.CommunicationEntity;
import com.my.spring.utils.DataWrapper;

import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
public interface CommunicationService {
    DataWrapper<List<CommunicationEntity>> getCommunicationList(String numPerPage,String pageNum,String theme,String title,String userName,Long replyQuantity,String contents);
}
