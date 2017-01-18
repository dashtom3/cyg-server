package com.my.spring.serviceImpl;

import com.my.spring.DAO.CommunicationDao;
import com.my.spring.model.CommunicationEntity;
import com.my.spring.service.CommunicationService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nixinan on 2017/1/18.
 */
@Service("communicationService")
public class CommunicationServiceImpl implements CommunicationService {
    @Autowired
    CommunicationDao communicationDao;
    @Override
    public DataWrapper<List<CommunicationEntity>> getCommunicationList(String numPerPage, String pageNum, String theme, String title, String userName, Long replyQuantity, String contents) {
        return communicationDao.getCommunicationList(numPerPage,pageNum,theme,title,userName,replyQuantity,contents);
    }
}
