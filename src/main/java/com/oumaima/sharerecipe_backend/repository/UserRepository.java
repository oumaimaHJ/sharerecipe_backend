package com.oumaima.sharerecipe_backend.repository;

import com.oumaima.sharerecipe_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
