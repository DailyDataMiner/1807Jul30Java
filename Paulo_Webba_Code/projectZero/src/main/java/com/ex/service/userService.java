package com.ex.service;

import com.ex.dao.InterDao;
import com.ex.dao.userDao;
import com.ex.pojos.User;

public class userService {
   static InterDao<User, Integer> uDao = new userDao();
   
}
