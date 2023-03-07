package com.mogilan.companymanager.service.user;

import com.mogilan.companymanager.web.dto.user.RoleDto;
import com.mogilan.companymanager.dao.entity.user.RoleEntity;
import com.mogilan.companymanager.exceptionhandler.exception.user.NoSuchRoleException;
import com.mogilan.companymanager.dao.repository.user.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public RoleDto create(RoleDto newEntity) {
        return null;
    }

    @Override
    public List<RoleDto> readAll() {
        return null;
    }

    @Override
    public RoleDto readById(Long id) {
        return null;
    }

    @Override
    public boolean update(Long id, RoleDto entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }


    @Override
    public RoleEntity findByName(String name) {
        RoleEntity roleEntity = roleRepository.findByName(name)
                .orElseThrow(() -> new NoSuchRoleException(name));
        return roleEntity;
    }
}
