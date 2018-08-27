package com.eolane.ywy.api.repository;

import com.eolane.ywy.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
