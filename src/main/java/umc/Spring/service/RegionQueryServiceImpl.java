package umc.Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.Spring.domain.Region;
import umc.Spring.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryServiceImpl implements RegionQueryService {

    private final RegionRepository regionRepository;

    @Override
    public Optional<Region> findRegion(Long id) {
        return regionRepository.findById(id);
    }

    @Override
    public List<Region> findRegionsByNameAndId(String name, Long id) {
        List<Region> filteredRegions = regionRepository.dynamicQueryWithBooleanBuilder(name, id);

        filteredRegions.forEach(region -> System.out.println("Region: " + region));

        return filteredRegions;
    }
}
