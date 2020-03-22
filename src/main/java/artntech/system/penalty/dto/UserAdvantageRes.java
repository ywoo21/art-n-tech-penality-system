package artntech.system.penalty.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserAdvantageRes {
    private String studentId;
    private String advantageName;
    private int advantageAppliedScore;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registeredTime;
}
