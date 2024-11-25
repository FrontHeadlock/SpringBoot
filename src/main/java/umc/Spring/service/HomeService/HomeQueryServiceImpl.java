package umc.Spring.service.HomeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.Spring.domain.Home;
import umc.Spring.repository.Home.HomeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeQueryServiceImpl implements HomeQueryService {

    private final HomeRepository homeRepository;  // 변경: storeRepository -> homeRepository

    @Override
    public Optional<Home> findHome(Long id) {
        return homeRepository.findById(id);  // 변경: HomeRepository.findById(id) -> homeRepository.findById(id)
    }

    @Override
    public List<Home> findHomesByIdAndName(Long id, String name) {
        List<Home> filteredHomes = homeRepository.dynamicQueryWithBooleanBuilder(id, name);

        filteredHomes.forEach(home -> System.out.println("home: " + home));

        return filteredHomes;
    }
}
