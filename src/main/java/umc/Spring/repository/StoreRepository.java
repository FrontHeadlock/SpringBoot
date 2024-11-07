package umc.Spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Store;
import umc.Spring.repository.StoreRepositoryCustom;


public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
