package com.hrbeu.zzw.controller;

import com.hrbeu.zzw.enums.ResponseStatus;
import com.hrbeu.zzw.model.AjaxResponse;
import com.hrbeu.zzw.model.User;
import com.hrbeu.zzw.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by lawrence on 2017/4/16.
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("login")
    public AjaxResponse<User> login(User user, HttpSession httpSession) {
        user = userInfoService.dologin(user);

        if(user == null) {
            return new AjaxResponse<User>(ResponseStatus.ERROR, user);
        }

        return new AjaxResponse<User>(ResponseStatus.OK, user);
    }

    @RequestMapping("register")
    public AjaxResponse<String> register(User user) {
        ResponseStatus rs = userInfoService.doRegister(user);

        return new AjaxResponse<String>(rs, rs.getMsg());
    }

    @RequestMapping("allinfo")
    public AjaxResponse<User> getAllInfo(User user) {
        user = userInfoService.getAllInfo(user);
        if(user != null) {
            return new AjaxResponse<User>(ResponseStatus.OK, user);
        }
        return new AjaxResponse<User>(ResponseStatus.ERROR);
    }


}
