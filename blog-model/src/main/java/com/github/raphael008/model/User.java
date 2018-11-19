package com.github.raphael008.model;

import com.github.raphael008.enums.BlockStatus;
import com.github.raphael008.enums.Gender;
import lombok.Data;

@Data
public class User {
    private Long userId;

    private String userName;

    private String userNickname;

    private String userEmail;

    private Byte userAge;

    private String userAvatar;

    private Gender userGender;

    private Long creatorId;

    private BlockStatus blocked;
}