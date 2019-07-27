package com.tostringtech.refp.application.authentication.api.repository;

import com.tostringtech.refp.application.authentication.core.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {


}
