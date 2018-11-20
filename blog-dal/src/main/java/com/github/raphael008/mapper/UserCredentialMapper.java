package com.github.raphael008.mapper;

import com.github.raphael008.model.UserCredential;import org.apache.ibatis.annotations.Param;

/**
* Created by Mybatis Generator 2018/11/20
*/
public interface UserCredentialMapper extends BaseMapper<UserCredential> {

    UserCredential selectByUserId(@Param("userId")Long userId);
}