package artntech.system.penalty.serviceImpl;

import artntech.system.penalty.domain.User;
import artntech.system.penalty.domain.UserAdvantage;
import artntech.system.penalty.dto.UserAdvantageReq;
import artntech.system.penalty.dto.UserAdvantageRes;
import artntech.system.penalty.repository.AdvantageRepository;
import artntech.system.penalty.repository.UserAdvantageRepository;
import artntech.system.penalty.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserAdvantageServiceImpl {
    private final UserAdvantageRepository userAdvantageRepository;
    private final UserRepository userRepository;
    private final AdvantageRepository advantageRepository;

    public UserAdvantageServiceImpl(final UserAdvantageRepository userAdvantageRepository,
                                    final UserRepository userRepository,
                                    final AdvantageRepository advantageRepository) {
        this.userAdvantageRepository = userAdvantageRepository;
        this.userRepository = userRepository;
        this.advantageRepository = advantageRepository;
    }

    /**
     * 회원 별 어드벤티지 정보 저장
     *
     * @param userAdvantageReqList 회원 별 어드벤티지 정보 리스트
     * @return DefaultRes
     */
    public void saveUserAdvantages(final List<UserAdvantageReq> userAdvantageReqList) {
        List<UserAdvantage> userAdvantageList = new ArrayList<>();
        userAdvantageReqList.stream().forEach(us-> {
            UserAdvantage userAdvantage =
                    UserAdvantage.builder()
                            .userId(userRepository.findByStudentId(us.getStudentId()).get().getId())
                            .advantageId(us.getAdvantageId())
                            .registeredTime(LocalDateTime.now())
                            .build();
            userAdvantageList.add(userAdvantage);

            User user = userRepository.findByStudentId(us.getStudentId()).get();
            user.setScore(user.getScore() + advantageRepository.findById(us.getAdvantageId()).get().getAppliedScore());
            userRepository.save(user);
        });
        userAdvantageRepository.saveAll(userAdvantageList);
    }

    /**
     * 회원 별 어드벤티지 정보 전체 조회
     *
     * @return DefaultRes
     */
    public List<UserAdvantageRes> findAllUserAdvantages() {
        List<UserAdvantage> userAdvantageList = userAdvantageRepository.findAll();
        List<UserAdvantageRes> userAdvantageResList = new ArrayList<>();
        userAdvantageList.stream().forEach(userAdvantage -> {
            UserAdvantageRes userAdvantageRes = UserAdvantageRes.builder()
                    .advantageName(advantageRepository.findById(userAdvantage.getAdvantageId()).get().getName())
                    .advantageAppliedScore(advantageRepository.findById(userAdvantage.getAdvantageId()).get().getAppliedScore())
                    .studentId(userRepository.findById(userAdvantage.getUserId()).get().getStudentId())
                    .registeredTime(userAdvantage.getRegisteredTime())
                    .build();
            userAdvantageResList.add(userAdvantageRes);
        });
        return userAdvantageResList;
    }
}
