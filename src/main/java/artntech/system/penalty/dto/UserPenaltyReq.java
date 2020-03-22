package artntech.system.penalty.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class UserPenaltyReq {
    private String studentId;
    private int penaltyId;
}
