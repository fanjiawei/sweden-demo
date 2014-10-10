package com.whereareyou.service;

import com.whereareyou.model.User;

/**
 * Created by 家玮 on 2014/7/27.
 */
public interface UserService {
    User getByUsername(String username);
    User getCurrentUser();
    User getByUserId(String userId);
}
