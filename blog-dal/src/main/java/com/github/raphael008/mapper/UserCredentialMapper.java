package com.github.raphael008.mapper;

import com.github.raphael008.model.UserCredential;

/**
* Created by Mybatis Generator 2018/11/20
*/
public interface UserCredentialMapper {
    int deleteByPrimaryKey(Long credentialId);

    int insert(UserCredential record);

    int insertSelective(UserCredential record);

    UserCredential selectByPrimaryKey(Long credentialId);

    int updateByPrimaryKeySelective(UserCredential record);

    int updateByPrimaryKey(UserCredential record);
}