package umc.Spring.repository.FoodCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
