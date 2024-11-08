package umc.Spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.User;
import umc.Spring.repository.UserRepositoryCustom;


public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}