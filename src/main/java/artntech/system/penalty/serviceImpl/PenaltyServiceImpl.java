package artntech.system.penalty.serviceImpl;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.domain.Penalty;
import artntech.system.penalty.repository.AdvantageRepository;

import artntech.system.penalty.repository.PenaltyRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PenaltyServiceImpl {
    private final PenaltyRepository penaltyRepository;

    public PenaltyServiceImpl(final PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }

    /**
     * 패널티 정보 저장
     *
     * @param penalty 어드벤티지 정보
     * @return DefaultRes
     */
    public void savePenalty(final Penalty penalty) {
        penalty.setCreatedTime(LocalDateTime.now());
        penaltyRepository.save(penalty);
    }

    /**
     * 패널티 정보 전체 조회
     *
     * @return DefaultRes
     */
    public List<Penalty> findAllPenalties() {
        return penaltyRepository.findAll();
    }
}
