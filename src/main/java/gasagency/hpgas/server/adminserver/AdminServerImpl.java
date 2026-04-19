package gasagency.hpgas.server.adminserver;

import gasagency.hpgas.dto.adminDto.AdminDto;
import gasagency.hpgas.dto.adminDto.LoginDto;
import gasagency.hpgas.entity.adminentity.AdminEntity;
import gasagency.hpgas.repository.adminrepository.AdminRepository;
import gasagency.hpgas.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminServerImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServerImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminEntity createAdmin(AdminDto adminDto) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setName(adminDto.getName());
        adminEntity.setEmail(adminDto.getEmail());
        adminEntity.setPassword(encoder.encode(adminDto.getPassword()));
        adminEntity.setPhoneNumber(adminDto.getPhoneNumber());
        adminEntity.setAgencyName(adminDto.getAgencyName());
        adminEntity.setAddress(adminDto.getAddress());
        adminEntity.setCreatedAt(LocalDateTime.now());

        return adminRepository.save(adminEntity);
    }

    @Override
    public String loginAdmin(LoginDto loginDto) {

        AdminEntity admin = adminRepository.findByEmail(loginDto.getEmail());

        if(admin == null){
            throw new RuntimeException("Admin not found");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(!encoder.matches(loginDto.getPassword(), admin.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        JwtUtil jwtUtil = new JwtUtil();

        return jwtUtil.generateToken(admin.getEmail(),admin.getId());
    }
}