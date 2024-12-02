package umc.Spring.repository.userRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByEmail(String email);

}