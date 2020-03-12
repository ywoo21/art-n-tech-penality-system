package artntech.system.penalty.repository;

import artntech.system.penalty.domain.Advantage;
import artntech.system.penalty.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdvantageRepository extends JpaRepository<Advantage, Integer> {
}
