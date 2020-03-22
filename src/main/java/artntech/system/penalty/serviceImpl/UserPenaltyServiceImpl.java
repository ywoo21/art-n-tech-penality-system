package artntech.system.penalty.serviceImpl;

import artntech.system.penalty.domain.User;
import artntech.system.penalty.domain.UserAdvantage;
import artntech.system.penalty.domain.UserPenalty;
import artntech.system.penalty.dto.UserAdvantageReq;
import artntech.system.penalty.dto.UserAdvantageRes;
import artntech.system.penalty.dto.UserPenaltyReq;
import artntech.system.penalty.dto.UserPenaltyRes;
import artntech.system.penalty.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserPenaltyServiceImpl {
    private final UserPenaltyRepository userPenaltyRepository;
    private final UserRepository userRepository;
    private final PenaltyRepository penaltyRepository;

    public UserPenaltyServiceImpl(final UserPenaltyRepository userPenaltyRepository,
                                    final UserRepository userRepository,
                                    final PenaltyRepository penaltyRepository) {
        this.userPenaltyRepository = userPenaltyRepository;
        this.userRepository = userRepository;
        this.penaltyRepository = penaltyRepository;
    }

    /**
     * 회원 별 패널티 정보 저장
     *
     * @param userPenaltyReqList 회원 별 패널티 정보 리스트
     * @return DefaultRes
     */
    public void saveUserPenalties(final List<UserPenaltyReq> userPenaltyReqList) {
        List<UserPenalty> userPenaltyList = new ArrayList<>();
        userPenaltyReqList.stream().forEach(up-> {
            UserPenalty userPenalty =
                    UserPenalty.builder()
                            .userId(userRepository.findByStudentId(up.getStudentId()).get().getId())
                            .penaltyId(up.getPenaltyId())
                            .registeredTime(LocalDateTime.now())
                            .build();
            userPenaltyList.add(userPenalty);

            User user = userRepository.findByStudentId(up.getStudentId()).get();

            user.setScore(user.getScore() - penaltyRepository.findById(up.getPenaltyId()).get().getAppliedScore());

            userRepository.save(user);
        });
        userPenaltyRepository.saveAll(userPenaltyList);
    }

    /**
     * 회원 별 패널티 정보 전체 조회
     *
     * @return DefaultRes
     */
    public List<UserPenaltyRes> findAllUserPenalties() {
        List<UserPenalty> userPenaltyList = userPenaltyRepository.findAll();
        List<UserPenaltyRes> userPenaltyResList = new ArrayList<>();
        userPenaltyList.stream().forEach(userPenalty -> {
            UserPenaltyRes userPenaltyRes = UserPenaltyRes.builder()
                    .penaltyName(penaltyRepository.findById(userPenalty.getPenaltyId()).get().getName())
                    .penaltyAppliedScore(penaltyRepository.findById(userPenalty.getPenaltyId()).get().getAppliedScore())
                    .studentId(userRepository.findById(userPenalty.getUserId()).get().getStudentId())
                    .registeredTime(userPenalty.getRegisteredTime())
                    .build();
            userPenaltyResList.add(userPenaltyRes);
        });
        return userPenaltyResList;
    }
}
