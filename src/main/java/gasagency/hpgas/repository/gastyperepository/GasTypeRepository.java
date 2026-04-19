package gasagency.hpgas.repository.gastyperepository;


import gasagency.hpgas.entity.gastypeentity.GasType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasTypeRepository extends JpaRepository<GasType, Long> {
}