package com.hrbeu.zzw.service;

import com.hrbeu.zzw.enums.ResponseStatus;
import com.hrbeu.zzw.model.User;

/**
 * Created by lawrence on 2017/4/16.
 */
public interface UserInfoService {
    public User dologin(User user);

    public ResponseStatus doRegister(User user);

    public User getAllInfo(User user);
}
