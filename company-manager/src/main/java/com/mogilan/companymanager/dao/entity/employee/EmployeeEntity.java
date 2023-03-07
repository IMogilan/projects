package com.mogilan.companymanager.dao.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
//    @Size(min = 2, message = "Min length should be 2 symbols")
//    @Pattern(regexp = "[\\w\\sа-яА-Я]{2,}", message = "Please use only letters or numbers")
    private String firstName;

    @Column(name = "last_name")
//    @Size(min = 2, message = "Min length should be 2 symbols")
//    @Pattern(regexp = "[\\w\\sа-яА-Я]{2,}", message = "Please use only letters or numbers")
    private String lastName;

    @Column(name = "email")
//    @Size(max = 254)
//    @CheckEmailDomainName
//    @Pattern(regexp = "[\\w]+@[a-zA-Z]+\\.[a-zA-Z]{2,15}", message = "Email format should be \"name@" + COMPANY_DOMAIN_NAME + "\"")
    private String email;
}
