package umc.Spring.service.HomeService;


import umc.Spring.domain.Home;

import java.util.List;
import java.util.Optional;

public interface HomeQueryService {
    Optional<Home> findHome(Long id);
    List<Home> findHomesByIdAndName(Long id, String name);

}