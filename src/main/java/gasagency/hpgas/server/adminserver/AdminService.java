package gasagency.hpgas.server.adminserver;

import gasagency.hpgas.dto.adminDto.AdminDto;
import gasagency.hpgas.dto.adminDto.LoginDto;
import gasagency.hpgas.entity.adminentity.AdminEntity;

public interface AdminService {
    AdminEntity createAdmin(AdminDto adminDto);
    String loginAdmin(LoginDto loginDto);
}
