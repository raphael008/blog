package com.github.raphael008.model;


import com.github.raphael008.enums.BlockStatus;
import com.github.raphael008.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test {

    private String username;

    private String password;

    private Gender gender;

    private BlockStatus blockStatus;
}
