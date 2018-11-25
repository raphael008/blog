package com.github.raphael008.user.manager;

import com.github.raphael008.user.vo.UserVO;

import java.util.Map;

public interface UserManager {

    Map<String, String> addUser(UserVO vo);
}
