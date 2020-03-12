package artntech.system.penalty.serviceImpl;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.domain.User;
import artntech.system.penalty.domain.UserAdvantage;
import artntech.system.penalty.repository.AdvantageRepository;
import artntech.system.penalty.repository.UserAdvantageRepository;
import artntech.system.penalty.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
     * @param userAdvantageList 회원 별 어드벤티지 정보 리스트
     * @return DefaultRes
     */
    public void saveUserAdvantages(final List<UserAdvantage> userAdvantageList) {
        userAdvantageList.stream().forEach(us-> {
            us.setRegisteredTime(LocalDateTime.now());
            User user = userRepository.findById(us.getUserId()).get();
            Advantage advantage = advantageRepository.findById(us.getAdvantageId()).get();
            user.setScore(user.getScore() + advantage.getAppliedScore());
        });
        userAdvantageRepository.saveAll(userAdvantageList);
    }

    /**
     * 회원 별 어드벤티지 정보 전체 조회
     *
     * @return DefaultRes
     */
    public List<UserAdvantage> findAllUserAdvantages() {
        return userAdvantageRepository.findAll();
    }
}
