package com.github.raphael008.user.vo;

import com.github.raphael008.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO extends User {
    private String password;
}
