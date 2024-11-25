package umc.Spring.repository.userRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.User;


public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}