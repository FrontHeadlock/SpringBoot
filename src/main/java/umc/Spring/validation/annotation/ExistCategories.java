package umc.Spring.validation.annotation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.Spring.validation.validator.categoriesExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = categoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}