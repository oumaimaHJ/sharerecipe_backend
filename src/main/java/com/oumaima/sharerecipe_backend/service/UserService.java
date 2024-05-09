package com.oumaima.sharerecipe_backend.service;
import com.oumaima.sharerecipe_backend.model.User;
public interface UserService {
    public User findUserById(Long userId) throws Exception;
    public User findUserByJwt(String jwt) throws Exception;
}
