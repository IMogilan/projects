package com.mogilan.companymanager.service.user;

import com.mogilan.companymanager.web.dto.user.RoleDto;
import com.mogilan.companymanager.dao.entity.user.RoleEntity;
import com.mogilan.companymanager.service.CrudService;

public interface RoleService extends CrudService<RoleDto, Long> {
    RoleEntity findByName(String name);
}
