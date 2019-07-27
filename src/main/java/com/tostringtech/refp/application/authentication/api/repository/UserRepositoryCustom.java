package com.tostringtech.refp.application.authentication.api.repository;

import com.tostringtech.refp.application.authentication.core.models.User;

public interface UserRepositoryCustom {

    User findByUsernameOrEmail(String usernameOrEmail);
}
