package artntech.system.penalty.api;

import artntech.system.penalty.domain.Penalty;
import artntech.system.penalty.serviceImpl.PenaltyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("penalties")
public class PenaltyController {

    private final PenaltyServiceImpl penaltyServiceImpl;

    public PenaltyController(final PenaltyServiceImpl penaltyServiceImpl){
        this.penaltyServiceImpl = penaltyServiceImpl;
    }

    @PostMapping("")
    public void registerPenalty(@RequestBody Penalty penalty){
        penaltyServiceImpl.savePenalty(penalty);
    }

    @GetMapping("")
    public List<Penalty> getAllPenalties(){
        return penaltyServiceImpl.findAllPenalties();
    }
}

