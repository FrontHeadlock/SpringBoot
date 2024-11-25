package umc.Spring.repository.regionRepository;

import umc.Spring.domain.Region;

import java.util.List;

public interface RegionRepositoryCustom {
    List<Region> dynamicQueryWithBooleanBuilder(String name,Long id);
}
