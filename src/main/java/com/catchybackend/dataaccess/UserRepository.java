package com.catchybackend.dataaccess;

import com.catchybackend.models.User;
import com.ts.core.repository.IUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends IUserRepository<User>, JpaRepository<User,Long> {

}
