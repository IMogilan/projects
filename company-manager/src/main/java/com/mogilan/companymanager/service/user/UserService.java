package com.mogilan.companymanager.service.user;

import com.mogilan.companymanager.web.dto.user.UserRegistrationDto;
import com.mogilan.companymanager.service.CrudService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, CrudService<UserRegistrationDto, Long> {
}
