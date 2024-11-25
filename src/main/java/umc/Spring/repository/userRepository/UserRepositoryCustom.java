package umc.Spring.repository.userRepository;

import umc.Spring.domain.User;
import java.util.List;

public interface UserRepositoryCustom {
    List<User> dynamicQueryWithBooleanBuilder(Long user_id, String name);
}