package umc.Spring.repository.storeRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Store;


public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
