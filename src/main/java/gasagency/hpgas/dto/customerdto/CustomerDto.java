package gasagency.hpgas.dto.customerdto;

import lombok.Data;

@Data
public class CustomerDto {

    private String hotelName;
    private String customerName;
    private String password;
    private String phone;

    private String address;
    private String city;
    private String country;
    private String zipCode;
}