package artntech.system.penalty.api;

import artntech.system.penalty.domain.User;
import artntech.system.penalty.dto.SignInReq;
import artntech.system.penalty.serviceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(final UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userServiceImpl.saveUser(user);
    }

    @PostMapping("/signin")
    public String signin(@RequestBody SignInReq signInReq){
        return userServiceImpl.authUser(signInReq);
    }
}
