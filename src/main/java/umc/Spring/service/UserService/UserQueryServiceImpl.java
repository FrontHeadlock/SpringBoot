package umc.Spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.Spring.domain.User;
import umc.Spring.repository.userRepository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository userRepository;

    @Override
    public Optional<User> findUser(Long user_id) {
        return userRepository.findById(user_id);
    }

    @Override
    public List<User> findUsersByIdAndName(Long user_id, String name) {
        List<User> filteredUsers = userRepository.dynamicQueryWithBooleanBuilder(user_id,name);

        filteredUsers.forEach(user -> System.out.println("User: " + user));

        return filteredUsers;
    }
}