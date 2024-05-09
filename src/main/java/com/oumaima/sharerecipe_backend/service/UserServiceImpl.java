package com.oumaima.sharerecipe_backend.service;

import com.oumaima.sharerecipe_backend.config.JwtProvider;
import com.oumaima.sharerecipe_backend.model.User;
import com.oumaima.sharerecipe_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtProvider;


    @Override
    public User findUserById(Long userId) throws Exception {
        Optional<User> opt = userRepository.findById(userId);

        if(opt.isPresent()){
            return opt.get();
        }
        throw new Exception("User not found with id "+ userId);
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);

        if(email==null){
            throw new Exception("provide valid jwt token...");
        }

        User user=userRepository.findByEmail(email);

        if(user == null){
            throw new Exception("user not found with email"+email);
        }

        return user;
    }
}
