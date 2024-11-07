package umc.Spring.service;

import umc.Spring.domain.Region;
import umc.Spring.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

public interface RegionQueryService {
    Optional<Region> findRegion(Long id);
    List<Region> findRegionsByNameAndId(String name, Long id);
}
