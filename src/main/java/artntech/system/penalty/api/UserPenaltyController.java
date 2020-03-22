package artntech.system.penalty.api;

import artntech.system.penalty.dto.UserAdvantageReq;
import artntech.system.penalty.dto.UserAdvantageRes;
import artntech.system.penalty.dto.UserPenaltyReq;
import artntech.system.penalty.dto.UserPenaltyRes;
import artntech.system.penalty.serviceImpl.UserAdvantageServiceImpl;
import artntech.system.penalty.serviceImpl.UserPenaltyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("userPenalties")
public class UserPenaltyController {

    private final UserPenaltyServiceImpl userPenaltyServiceImpl;

    public UserPenaltyController(final UserPenaltyServiceImpl userPenaltyServiceImpl){
        this.userPenaltyServiceImpl = userPenaltyServiceImpl;
    }

    @PostMapping("")
    public void registerUserPenalties(@RequestBody List<UserPenaltyReq> userPenaltyReqList){
        userPenaltyServiceImpl.saveUserPenalties(userPenaltyReqList);
    }

    @GetMapping("")
    public List<UserPenaltyRes> getAllPenalties(){
        return userPenaltyServiceImpl.findAllUserPenalties();
    }
}