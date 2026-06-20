//Entity Class for Admin

package gasagency.hpgas.controller.admincontroller;

import gasagency.hpgas.dto.adminDto.AdminDto;
import gasagency.hpgas.dto.adminDto.LoginDto;
import gasagency.hpgas.entity.adminentity.AdminEntity;
import gasagency.hpgas.server.adminserver.AdminServerImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class Admin {
    private final AdminServerImpl adminServerimpl;
    public Admin(AdminServerImpl adminServerimpl){
        this.adminServerimpl=adminServerimpl;
    }

    @PostMapping("/CreateAdmin")
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminDto adminDto){
        AdminEntity adminEntity=adminServerimpl.createAdmin(adminDto);
        return ResponseEntity.ok(adminEntity);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String token = adminServerimpl.loginAdmin(loginDto);
        return ResponseEntity.ok(token);
    }
}
