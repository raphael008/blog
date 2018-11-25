package com.github.raphael008.model;

import lombok.Data;

/**
* Created by Mybatis Generator 2018/11/20
*/
@Data
public class UserCredential {
    private Long credentialId;

    private Long userId;

    private String userPassword;
}