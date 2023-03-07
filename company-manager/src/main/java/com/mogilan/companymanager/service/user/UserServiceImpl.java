package com.mogilan.companymanager.service.user;

import com.mogilan.companymanager.exceptionhandler.exception.user.NoSuchUserException;
import com.mogilan.companymanager.mapper.RoleToAuthorityMapper;
import com.mogilan.companymanager.web.dto.user.Role;
import com.mogilan.companymanager.web.dto.user.UserRegistrationDto;
import com.mogilan.companymanager.dao.entity.user.UserEntity;
import com.mogilan.companymanager.dao.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    private static final String DEFAULT_ROLE_NAME = Role.EMPLOYEE.name();
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final RoleToAuthorityMapper roleToAuthorityMapper;


    @Override
    public UserRegistrationDto create(UserRegistrationDto dto) {
        UserEntity newUser = UserEntity.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(PASSWORD_ENCODER.encode(dto.getPassword()))
                .roles(Arrays.asList(roleService.findByName(DEFAULT_ROLE_NAME)))
                .build();
        userRepository.save(newUser);

        return dto;
    }

    @Override
    public List<UserRegistrationDto> readAll() {
        return null;
    }

    @Override
    public UserRegistrationDto readById(Long id) {
        return null;
    }

    @Override
    public boolean update(Long id, UserRegistrationDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow(() -> new NoSuchUserException(username));
        Collection<? extends GrantedAuthority> authorities = roleToAuthorityMapper.mapRolesToAuthorities(userEntity.getRoles());
        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }
}
