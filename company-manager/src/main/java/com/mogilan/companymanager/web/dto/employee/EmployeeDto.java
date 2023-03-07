package com.mogilan.companymanager.web.dto.employee;

import com.mogilan.companymanager.web.validation.CheckEmailDomainName;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import static com.mogilan.companymanager.util.CompanyInfoUtil.COMPANY_DOMAIN_NAME;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    Long id;
    @Size(min = 2, message = "Min length should be 2 symbols")
    @Pattern(regexp = "[\\w\\sа-яА-Я]{2,}", message = "Please use only letters or numbers")
    String firstName;
    @Size(min = 2, message = "Min length should be 2 symbols")
    @Pattern(regexp = "[\\w\\sа-яА-Я]{2,}", message = "Please use only letters or numbers")
    String lastName;
    @Size(max = 254)
    @CheckEmailDomainName
    @Pattern(regexp = "[\\w\\.]+@[a-zA-Z]+\\.[a-zA-Z]{2,15}", message = "Email format should be \"name@" + COMPANY_DOMAIN_NAME + "\"")
    String email;
}
