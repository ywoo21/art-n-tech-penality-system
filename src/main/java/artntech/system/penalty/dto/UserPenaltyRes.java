package artntech.system.penalty.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserPenaltyRes {
    private String studentId;
    private String penaltyName;
    private int penaltyAppliedScore;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registeredTime;
}
