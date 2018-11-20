package com.github.raphael008.model;

import lombok.Data;

/**
* Created by Mybatis Generator 2018/11/20
*/
@Data
public class User {
    private Long userId;

    private String userName;

    private String userNickname;

    private String userEmail;

    private Integer userAge;

    private String userAvatar;

    private Object userGender;

    private Long creatorId;

    private Integer blocked;
}