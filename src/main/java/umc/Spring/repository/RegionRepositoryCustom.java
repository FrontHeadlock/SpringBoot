package umc.Spring.repository;

import umc.Spring.domain.Region;

import java.util.List;

public interface RegionRepositoryCustom {
    List<Region> dynamicQueryWithBooleanBuilder(String name,Long id);
}
