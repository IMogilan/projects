package com.mogilan.companymanager.web.dto.user;

import com.mogilan.companymanager.web.validation.CheckEmailDomainName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.mogilan.companymanager.util.CompanyInfoUtil.COMPANY_DOMAIN_NAME;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    @Size(min = 2, message = "Min length should be 2 symbols")
    @Pattern(regexp = "[\\w\\sа-яА-Я]{2,}", message = "Please use only letters or numbers")
    private String firstName;

    @Size(min = 2, message = "Min length should be 2 symbols")
    @Pattern(regexp = "[\\w\\sа-яА-Я]{2,}", message = "Please use only letters or numbers")
    private String lastName;

    @Size(max = 254)
    @CheckEmailDomainName
    @Pattern(regexp = "[\\w\\.]+@[a-zA-Z]+\\.[a-zA-Z]{2,15}", message = "Email format should be \"name@" + COMPANY_DOMAIN_NAME + "\"")
    private String email;

    @Size(min = 5, message = "Min length should be 5 symbols")
    @Pattern(regexp = "[\\w\\sа-яА-Я]{5,}", message = "Please use only letters or numbers")
    private String password;
}
