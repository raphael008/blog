package com.github.raphael008.controller;

import com.github.raphael008.auth.Auth;
import com.github.raphael008.auth.CustomHttpSessionStrategy;
import com.github.raphael008.model.User;
import com.github.raphael008.service.UserService;
import com.github.raphael008.user.manager.UserManager;
import com.github.raphael008.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserManager userManager;

    @PostMapping("queryByUserId")
    public User queryByUserId(@RequestBody Long userId) {
        User user = userService.queryByUserId(userId);
        return user;
    }

    @PostMapping("queryAllUsers")
    public List<User> queryAllUsers() {
        List<User> users = userService.selectList();
        return users;
    }

    @PostMapping("addUser")
    @Auth
    public Map addUser(@RequestBody UserVO vo) {
        Map<String, String> result = userManager.addUser(vo);
        return result;
    }

    @PostMapping("test")
    @Auth
    public String test(HttpServletRequest request) {
        CustomHttpSessionStrategy customHttpSessionStrategy = new CustomHttpSessionStrategy();
        String requestedSessionId = customHttpSessionStrategy.getRequestedSessionId(request);

        return "result:" + requestedSessionId;
    }
}
