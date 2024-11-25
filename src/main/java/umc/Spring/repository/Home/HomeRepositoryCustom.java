package umc.Spring.repository.Home;

import umc.Spring.domain.Home;

import java.util.List;

public interface HomeRepositoryCustom {
    List<Home> dynamicQueryWithBooleanBuilder(Long id, String name);
}

