package artntech.system.penalty.api;

import artntech.system.penalty.dto.UserAdvantageReq;
import artntech.system.penalty.dto.UserAdvantageRes;
import artntech.system.penalty.serviceImpl.UserAdvantageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("userAdvantages")
public class UserAdvantageController {

    private final UserAdvantageServiceImpl userAdvantageServiceImpl;

    public UserAdvantageController(final UserAdvantageServiceImpl userAdvantageServiceImpl){
        this.userAdvantageServiceImpl = userAdvantageServiceImpl;
    }

    @PostMapping("")
    public void registerUserAdvantages(@RequestBody List<UserAdvantageReq> userAdvantageReqList){
        userAdvantageServiceImpl.saveUserAdvantages(userAdvantageReqList);
    }

    @GetMapping("")
    public List<UserAdvantageRes> getAllAdvantages(){
        return userAdvantageServiceImpl.findAllUserAdvantages();
    }
}