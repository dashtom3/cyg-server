package com.my.spring.serviceImpl;

import com.my.spring.DAO.UserDao;
import com.my.spring.enums.CallStatusEnum;
import com.my.spring.enums.ErrorCodeEnum;
import com.my.spring.service.UserService;
import com.my.spring.utils.DataWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.spring.model.*;

import java.sql.Timestamp;
import java.util.List;
/**
 * Created by Administrator on 2016/6/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public DataWrapper<Void> addUser(UserEntity user) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        if(!userDao.addUser(user)) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> delete(Long userId) {
        DataWrapper<Void> dataWrapper = new DataWrapper<Void>();
        if(!userDao.delete(userId)) {
            dataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
        return dataWrapper;
    }

    @Override
    public DataWrapper<Void> update(UserEntity user) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();

        if(user != null && user.getUserid()!=0) {
            if(userDao.update(user)) {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> changePwd(String password, Long userId) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        if(password!=null&&userId!=null)
        {
            if(userDao.changePwd(password,userId))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        retDataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return retDataWrapper;
    }

    @Override
    public DataWrapper<Void> changeType(Integer userType, Long userId) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        if(userType!=null&&userId!=null)
        {
           if(userDao.changeType(userType,userId))
            {
                retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
            }else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        retDataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
        return retDataWrapper;
    }

    /*@Override
    public DataWrapper<List<UserEntity>> getUserList() {
        return userDao.getUserList();
    }*/

    @Override
    public DataWrapper<UserEntity> getUserById(Long userId) {
        DataWrapper<UserEntity> retDataWrapper = new DataWrapper<UserEntity>();

        if(userId != null ) {

            UserEntity userApplicationEntity = userDao.getUserById(userId);
                retDataWrapper.setData(userApplicationEntity);

        } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        return retDataWrapper;

    }



    @Override
    public DataWrapper<Void> login(Long studentid, String password) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();
        UserEntity user = userDao.findBystudentid(studentid);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                retDataWrapper.setCallStatus(CallStatusEnum.SUCCEED);
            } else {
                retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
            }
        }
        else {
            retDataWrapper.setErrorCode(ErrorCodeEnum.Error);
        }
            return retDataWrapper;


    }

    @Override
    public DataWrapper<Void> register(UserEntity userEntity) {
        DataWrapper<Void> retDataWrapper = new DataWrapper<Void>();

            if(userEntity != null && userEntity.getPassword()!= null && userEntity.getUsername()!= null
                    && userEntity.getStudentid()!= null) {
                userEntity.setUsertype(0);
                userEntity.setRegistertime(new Timestamp(System.currentTimeMillis()));
                if(userDao.addUser(userEntity))
                    retDataWrapper.setErrorCode(ErrorCodeEnum.No_Error);
                else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);

            } else retDataWrapper.setErrorCode(ErrorCodeEnum.Error);



        return retDataWrapper;
    }

    @Override
    public DataWrapper<List<UserEntity>> getUserList(String numPerPage,String pageNum,String userName, Long studentId, String department, String major, Integer userType, String telephone) {

        return userDao.getUserList(numPerPage,pageNum,userName,studentId,department,major,userType,telephone);
    }

}
