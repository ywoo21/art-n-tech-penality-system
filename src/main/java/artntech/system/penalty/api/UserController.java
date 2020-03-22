package artntech.system.penalty.api;

import artntech.system.penalty.domain.User;
import artntech.system.penalty.dto.SignInReq;
import artntech.system.penalty.enums.UserType;
import artntech.system.penalty.serviceImpl.UserServiceImpl;
import artntech.system.penalty.utils.auth.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userServiceImpl.findAllUsers();
    }

    @Auth
    @GetMapping("")
    public User getUser(final HttpServletRequest httpServletRequest){
        final int userId = (int) httpServletRequest.getAttribute("userIdx");
        return userServiceImpl.findUserById(userId);
    }

    @Auth
    @GetMapping("/check")
    public UserType checkUserByUserType(final HttpServletRequest httpServletRequest){
        final int userId = (int) httpServletRequest.getAttribute("userIdx");
        return userServiceImpl.findUserTypeById(userId);
    }
}
