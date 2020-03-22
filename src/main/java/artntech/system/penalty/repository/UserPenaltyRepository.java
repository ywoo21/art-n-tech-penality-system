package artntech.system.penalty.repository;

import artntech.system.penalty.domain.UserAdvantage;
import artntech.system.penalty.domain.UserPenalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPenaltyRepository extends JpaRepository<UserPenalty, Integer> {
}
