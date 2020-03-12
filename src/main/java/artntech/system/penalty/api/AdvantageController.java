package artntech.system.penalty.api;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.serviceImpl.AdvantageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("advantages")
public class AdvantageController {

    private final AdvantageServiceImpl advantageServiceImpl;

    public AdvantageController(final AdvantageServiceImpl advantageServiceImpl){
        this.advantageServiceImpl = advantageServiceImpl;
    }

    @PostMapping("")
    public void registerAdvantage(@RequestBody Advantage advantage){
        advantageServiceImpl.saveAdvantage(advantage);
    }

    @GetMapping("")
    public List<Advantage> getAllAdvantages(){
        return advantageServiceImpl.findAllAdvantages();
    }
}
