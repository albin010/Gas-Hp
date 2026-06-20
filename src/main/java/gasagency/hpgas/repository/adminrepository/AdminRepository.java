package gasagency.hpgas.repository.adminrepository;

import gasagency.hpgas.entity.adminentity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {

//    AdminEntity findById(Long Id);

    AdminEntity findByEmail(String adminEmail);
}
