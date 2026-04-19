package gasagency.hpgas.server.adminserver;

import gasagency.hpgas.dto.adminDto.AdminDto;
import gasagency.hpgas.entity.adminentity.AdminEntity;
import gasagency.hpgas.repository.adminrepository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AdminServerImplTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServerImpl adminServer;

    @Test
    void createAdmin() {

        // Arrange (prepare input)
        AdminDto adminDto = new AdminDto();
        adminDto.setName("Albin");
        adminDto.setEmail("albin@gmail.com");
        adminDto.setPassword("1234");

        // Mock repository save
        Mockito.when(adminRepository.save(Mockito.any(AdminEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Act (call method)
        AdminEntity result = adminServer.createAdmin(adminDto);

        // Assert (verify result)
        assertNotNull(result);
        assertEquals("Albin", result.getName());
        assertEquals("albin@gmail.com", result.getEmail());
        assertNotNull(result.getPassword()); // encoded password

        System.out.println("Test Passed ✅");
    }
}