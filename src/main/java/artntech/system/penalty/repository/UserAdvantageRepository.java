package artntech.system.penalty.repository;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.domain.UserAdvantage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAdvantageRepository extends JpaRepository<UserAdvantage, Integer> {
}
