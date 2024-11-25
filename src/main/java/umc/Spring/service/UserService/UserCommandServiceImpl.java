package umc.Spring.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.Spring.converter.MemberConverter;
import umc.Spring.domain.FoodCategory;
import umc.Spring.domain.User;
import umc.Spring.repository.FoodCategory.FoodCategoryRepository;
import umc.Spring.repository.userRepository.UserRepository;
import umc.Spring.web.dto.memberDTO.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {


    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;
    /*
    @Override
    @Transactional
    public User joinMember(MemberRequestDTO.JoinDto request) {

        User newUser = MemberConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toMemberPreferList(foodCategoryList);

        userPreferList.forEach(memberPrefer -> {memberPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }

    */
}