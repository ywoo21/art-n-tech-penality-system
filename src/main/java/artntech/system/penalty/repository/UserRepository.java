package artntech.system.penalty.repository;

import artntech.system.penalty.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<List<User>> findAllByEmailContaining(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}
