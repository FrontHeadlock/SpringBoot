package umc.Spring.service;


import umc.Spring.domain.Home;
import umc.Spring.domain.Store;
import java.util.List;
import java.util.Optional;

public interface HomeQueryService {
    Optional<Home> findHome(Long id);
    List<Home> findHomesByIdAndName(Long id, String name);

}