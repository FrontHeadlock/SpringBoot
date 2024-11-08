package umc.Spring.repository;

import umc.Spring.domain.Home;
import umc.Spring.domain.Mission;

import java.util.List;

public interface HomeRepositoryCustom {
    List<Home> dynamicQueryWithBooleanBuilder(Long id, String name);
}

