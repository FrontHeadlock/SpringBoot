package umc.Spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.Spring.validation.validator.ChallengeAlreadyExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChallengeAlreadyExistValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotChallenged {
    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}