package com.oumaima.sharerecipe_backend.controller;

        import com.oumaima.sharerecipe_backend.model.User;
        import com.oumaima.sharerecipe_backend.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;



@RestController

public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/api/user/profile")
    public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception{
        User user=userService.findUserByJwt(jwt);
        return user;
    }

}
