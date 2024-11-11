package umc.Spring.service.UserService;

import umc.Spring.domain.User;
import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    Optional<User> findUser(Long user_id);
    List<User> findUsersByIdAndName(Long user_id, String name);

}