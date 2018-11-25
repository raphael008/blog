package com.github.raphael008.service;

import com.github.raphael008.model.UserCredential;

public interface UserCredentialService extends BaseService<UserCredential> {

    UserCredential queryByUserId(Long userId);
}
