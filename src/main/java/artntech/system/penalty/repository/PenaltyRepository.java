package artntech.system.penalty.repository;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.domain.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {
}
