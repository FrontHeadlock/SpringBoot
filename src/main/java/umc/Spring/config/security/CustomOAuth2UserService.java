package umc.Spring.config.security;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import umc.Spring.domain.User;
import umc.Spring.domain.enums.Gender;
import umc.Spring.domain.enums.Role;
import umc.Spring.repository.userRepository.UserRepository;

public class CustomOAuth2UserService {
    @Service
    @RequiredArgsConstructor
    public class CustomOAuth2UserService extends DefaultOAuth2UserService {

        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;

        @Override
        public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
            OAuth2User oAuth2User = super.loadUser(userRequest);

            Map<String, Object> attributes = oAuth2User.getAttributes();
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");

            String nickname = (String) properties.get("nickname");
            String email = nickname + "@kakao.com"; // 임시 이메일 생성

            // 사용자 정보 저장 또는 업데이트
            User user = saveOrUpdateUser(email, nickname);

            Map<String, Object> modifiedAttributes = new HashMap<>(attributes);
            modifiedAttributes.put("email", email);

            // 이메일을 Principal로 사용하기 위해 DefaultOAuth2User에 닉네임 설정
            return new DefaultOAuth2User(
                    oAuth2User.getAuthorities(),
                    modifiedAttributes,  // 수정된 attributes 사용
                    "email"  // email Principal로 설정
            );
        }

        private User saveOrUpdateUser(String email, String nickname) {
            User user = userRepository.findByEmail(email)
                    .orElse(User.builder()
                            .email(email)
                            .name(nickname)
                            .password(passwordEncoder.encode("OAUTH_USER_" + UUID.randomUUID()))
                            .gender(Gender.NONE)  // 기본값 설정
                            .address("소셜로그인")  // 기본값 설정
                            .specAddress("소셜로그인")  // 기본값 설정
                            .role(Role.USER)
                            .build());

            return userRepository.save(user);
        }
    }
}
