package artntech.system.penalty.api;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.domain.UserAdvantage;
import artntech.system.penalty.serviceImpl.AdvantageServiceImpl;
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
    public void registerUserAdvantages(@RequestBody List<UserAdvantage> userAdvantageList){
        userAdvantageServiceImpl.saveUserAdvantages(userAdvantageList);
    }

    @GetMapping("")
    public List<UserAdvantage> getAllAdvantages(){
        return userAdvantageServiceImpl.findAllUserAdvantages();
    }
}