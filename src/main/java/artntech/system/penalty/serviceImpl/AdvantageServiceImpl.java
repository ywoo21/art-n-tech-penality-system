package artntech.system.penalty.serviceImpl;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.repository.AdvantageRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class AdvantageServiceImpl {
    private final AdvantageRepository advantageRepository;

    public AdvantageServiceImpl(final AdvantageRepository advantageRepository) {
        this.advantageRepository = advantageRepository;
    }

    /**
     * 어드벤티지 정보 저장
     *
     * @param advantage 어드벤티지 정보
     * @return DefaultRes
     */
    public void saveAdvantage(final Advantage advantage) {
        advantage.setCreatedTime(LocalDateTime.now());
        advantageRepository.save(advantage);
    }

    /**
     * 어드벤티지 정보 전체 조회
     *
     * @return DefaultRes
     */
    public List<Advantage> findAllAdvantages() {
        return advantageRepository.findAll();
    }
}
