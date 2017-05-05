package com.hrbeu.zzw.service.impl;

import com.hrbeu.zzw.dao.UserMapper;
import com.hrbeu.zzw.enums.ResponseStatus;
import com.hrbeu.zzw.model.User;
import com.hrbeu.zzw.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lawrence on 2017/4/16.
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserMapper userMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    @Override
    public User dologin(User user) {
        if(user.getNickname() == null || user.getPassword() == null) {
            LOGGER.info("doLogin() userName or userPwd is illegal");
            return null;
        }

        try {
            User res = userMapper.selectByUsernameAndPassword(user);

            return res;
        } catch (Exception e) {
            LOGGER.error("doLogin() fail to get user info, userName = " + user.getNickname(), e);
        }

        return null;
    }

    @Override
    public ResponseStatus doRegister(User user) {
        if(user.getNickname() == null || user.getPassword() == null || user.getTelephone() == null) {
            LOGGER.info("doRegister() params are illegal");
            return ResponseStatus.ERROR;
        }

        try {
            int rs = userMapper.insertSelective(user);

            if(rs != 0) {
                return ResponseStatus.OK;
            } else {
                return ResponseStatus.ERROR;
            }
        } catch (Exception e) {
            LOGGER.error("doRegister() fail to insert user info", e);
        }

        return null;
    }

    @Override
    public User getAllInfo(User user) {
        if(user.getNickname() == null) {
            LOGGER.info("getAllInfo() params are illegal");
            return null;
        }

        try {
            User rs = userMapper.selectByExample(user);

            return rs;
        } catch (Exception e) {
            LOGGER.error("getAllInfo() fail to get user info", e);
        }

        return null;
    }
}
