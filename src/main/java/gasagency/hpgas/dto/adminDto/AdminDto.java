package gasagency.hpgas.dto.adminDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private String name;
    private String email;
    private String password;

    private String phoneNumber;
    private String agencyName;
    private String address;

}